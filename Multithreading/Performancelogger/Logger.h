
#include <fstream>
#include <string>
#include <thread>
#include <functional>
#include <condition_variable>
#include <mutex>
#include <memory>
#include <sstream>
#include <chrono>
#include <ctime>
#include <iomanip>
#include <queue>
#include <iostream>
#include <cstdarg>
#include <map>
#include <windows.h>
#include <atomic>

template<typename T>
class shared_queue
{
  std::queue<T> queue_;
  mutable std::mutex m_;
  std::condition_variable data_cond_;

  shared_queue& operator=(const shared_queue&); // c++11 feature not yet in vs2010 = delete;
  shared_queue(const shared_queue& other); // c++11 feature not yet in vs2010 = delete;

public:
  shared_queue(){}

  void push(T item)
  {
    std::lock_guard<std::mutex> lock(m_);
    queue_.push(item);
    data_cond_.notify_one();
  }

  // return immediately, with true if successful retrieval
  bool try_and_pop(T& popped_item)
  {
    std::lock_guard<std::mutex> lock(m_);
    if(queue_.empty())
    {
      return false;
    }
    popped_item=std::move(queue_.front());
    queue_.pop();
    return true;
  }

  // Try to retrieve, if no items, wait till an item is available and try again
  void wait_and_pop(T& popped_item)
  {
    std::unique_lock<std::mutex> lock(m_); // note: unique_lock is needed for std::condition_variable::wait
    while(queue_.empty())
    { //                       The 'while' loop below is equal to
      data_cond_.wait(lock);  //data_cond_.wait(lock, [](bool result){return !queue_.empty();});
    }
    popped_item=std::move(queue_.front());
    queue_.pop();
  }

  bool empty() const
  {
    std::lock_guard<std::mutex> lock(m_);
    return queue_.empty();
  }

  unsigned size() const
  {
    std::lock_guard<std::mutex> lock(m_);
    return queue_.size();
  }
};

namespace SSK
{
  typedef std::function<void()> Callback;

  class Active 
  {
  private:
    Active(const Active&);
    Active& operator=(const Active&);
    Active(): done_(false){}// Construction ONLY through factory createActive();

    void doDone()
    {
      done_ = true;
    }
    // Will wait for msgs if queue is empty
    void Active::run() 
    {
      while (!done_) 
      {
        // wait till job is available, then retrieve it and
        // executes the retrieved job in this thread (background)
        Callback func;
        mq_.wait_and_pop(func);
        func();
      }
    }

    shared_queue<Callback> mq_;
    std::thread thd_;
    bool done_;  // finished flag to be set through msg queue by ~Active

  public:
    virtual ~Active() 
    {
      Callback quit_token = std::bind(&Active::doDone, this);
      send(quit_token); // tell thread to exit
      thd_.join();
    }

    // Add asynchronously a work-message to queue
    void send(Callback msg_)
    {
      mq_.push(msg_);
    }

    static std::unique_ptr<Active> createActive() // Factory: safe construction & thread start
    {
      std::unique_ptr<Active> aPtr(new Active());
      aPtr->thd_ = std::thread(&Active::run, aPtr.get());
      return aPtr;
    }
  };
}

namespace
{
  bool openLogFile(const std::string& complete_file_with_path, std::ofstream& outstream)
  {
    std::ios_base::openmode mode = std::ios_base::out; // for clarity: it's really overkill since it's an ofstream
    mode |= std::ios_base::app;
    outstream.open(complete_file_with_path, mode);
    if(!outstream.is_open())
    {
      std::ostringstream ss_error;
      ss_error << "FILE ERROR:  could not open log file:[" << complete_file_with_path << "]";
      ss_error << "\n\t\t std::ios_base state = " << outstream.rdstate();
      std::cerr << ss_error.str().c_str() << std::endl << std::flush;
      outstream.close();
      return false;
    }
    return true;
  }

  std::unique_ptr<std::ofstream> createLogFile(const std::string& file_with_full_path)
  {
    std::unique_ptr<std::ofstream> out(new std::ofstream);
    std::ofstream& stream(*(out.get()));
    bool success_with_open_file = openLogFile(file_with_full_path, stream);
    if(false == success_with_open_file)
    {
      out.release(); // nullptr contained ptr<file> signals error in creating the log file
    }
    return out;
  }
}

struct LogWorkerImpl
{
  std::string log_file_with_path_;
  std::unique_ptr<SSK::Active> bg_;
  std::unique_ptr<std::ofstream> outptr_;

  LogWorkerImpl(const std::string& file_name)
    : log_file_with_path_(file_name)
    , bg_(SSK::Active::createActive())
    , outptr_(new std::ofstream)
  {
    outptr_ = createLogFile(log_file_with_path_);
    if(!outptr_) 
    {
      std::cerr << "Cannot write logfile to location, attempting current directory" << std::endl;
      log_file_with_path_ = file_name;
      outptr_ = createLogFile(log_file_with_path_);
    }
    assert((outptr_) && "cannot open log file at startup");
  }

  ~LogWorkerImpl()
  {
    bg_.reset(); // flush the log queue
  }

  void backgroundFileWrite(std::string message)
  {
    using namespace std;
    std::ofstream& out(filestream());
    out << "\t" << message << std::flush;
  }

private:
  LogWorkerImpl& operator=(const LogWorkerImpl&);
  LogWorkerImpl(const LogWorkerImpl& other);
  std::ofstream& filestream(){return *(outptr_.get());}
};


class LogWorker
{
public:
  LogWorker::LogWorker(const std::string& fileName) :pimpl_(new LogWorkerImpl(fileName)), log_file_with_path_(pimpl_->log_file_with_path_)
  {
    assert((pimpl_ != nullptr) && "shouild never happen");
  }
  virtual ~LogWorker()
  {
    pimpl_.reset();
    std::cerr << "\nExiting, log location: " << log_file_with_path_ << std::endl << std::flush;
  }

  /// pushes in background thread (asynchronously) input messages to log file
  void save(const std::string& msg)
  {
    pimpl_->bg_->send(std::bind(&LogWorkerImpl::backgroundFileWrite, pimpl_.get(), msg));
  }

private:
  std::unique_ptr<LogWorkerImpl> pimpl_;
  const std::string log_file_with_path_;
  LogWorker(const LogWorker&);
  LogWorker& operator=(const LogWorker&);
};

//Query performance based calculation
class Stopwatch
{
private:
 double m_pcFreq;
__int64 m_start;
__int64 m_difference;
double elapsedTime;

public:
  Stopwatch() : m_start(0), m_difference(0), m_pcFreq(0.0), elapsedTime(0.0) 
  {
    LARGE_INTEGER largeInteger;
    if(QueryPerformanceFrequency(&largeInteger))
    {
      m_pcFreq = double(largeInteger.QuadPart)/1000.0;
      QueryPerformanceCounter(&largeInteger);
      m_difference = m_start = largeInteger.QuadPart;
    }
  }

  double Elapsed()
  {
    LARGE_INTEGER largeInteger;
    QueryPerformanceCounter(&largeInteger);
    elapsedTime = double(largeInteger.QuadPart - m_difference) / m_pcFreq;
    m_difference = largeInteger.QuadPart;

    return elapsedTime;
  }

  double TotalElapsed()
  {
    LARGE_INTEGER largeInteger;
    QueryPerformanceCounter(&largeInteger);
    return double(largeInteger.QuadPart - m_start) / m_pcFreq;
  }
};

namespace
{
  class PerfLogger
  {
    static std::atomic<PerfLogger*> m_instance;
    static std::mutex m_mutex;
    LogWorker* logWorker;
    PerfLogger(const PerfLogger&);
    PerfLogger& operator=(const PerfLogger&);

    PerfLogger(): logWorker(new LogWorker("D:\\Logs\\Logger.txt"))
    {
    }

  public:
    void saveToLogger(const std::string& log_entry)
    {
      logWorker->save(log_entry);
    }

    static PerfLogger* GetInstance()
    {
      PerfLogger* instance = m_instance.load();
      if (instance == nullptr) 
      {
        std::lock_guard<std::mutex> lock(m_mutex);
        instance = m_instance.load();
        if (instance == nullptr) 
        {
          instance = new PerfLogger();
          m_instance.store(instance);
        }
      }
      return instance;
    }

    ~PerfLogger()
    {
      if(logWorker)
      {
        delete logWorker;
      }
    }
  };

  std::atomic<PerfLogger*> PerfLogger::m_instance= nullptr;
  std::mutex PerfLogger::m_mutex;
}


class LogMessage
{
public:
  LogMessage()
  {
  }

  virtual ~LogMessage() // at destruction will flush the message
  {
    std::ostringstream oss;
    oss << "\n["<<TimeStamp()<<"] ";

    const std::string str(stream_.str());
    if(!str.empty())
    {
      oss <<str;
    }
    log_entry_ += oss.str();

    PerfLogger::GetInstance()->saveToLogger(log_entry_); // message saved
  }

  std::ostringstream& messageStream(){return stream_;}
private:
  std::string TimeStamp()
  {
    SYSTEMTIME sysTime;
    FILETIME fileTime;
    FILETIME fileTimeStamp;
    char timeStamp[256];//to store TimeStamp information
    GetSystemTimeAsFileTime(&fileTimeStamp); //Gets the current system time
    FileTimeToLocalFileTime (&fileTimeStamp, &fileTime);//convert in local time and store in ltime
    FileTimeToSystemTime(&fileTime, &sysTime);//convert in system time and store in sysTime

    sprintf_s(timeStamp, "%d-%d-%d %d:%d:%d:%3d", sysTime.wYear, sysTime.wMonth, sysTime.wDay, sysTime.wHour, sysTime.wMinute, sysTime.wSecond, sysTime.wMilliseconds);
    return timeStamp;
  }

  std::ostringstream stream_;
  std::string log_entry_;
};


#define G2_LOG LogMessage()
#define LOG G2_LOG.messageStream()

class CPerformanceLog
{
  typedef struct
  {
  public:
    double difference;
    double totalElapsed;
    std::wstring msg;
  } LogEntry;

public:
  CPerformanceLog(double threshold) : _threshold(threshold)
  {
  }

  ~CPerformanceLog()
  {
    if(_timer.TotalElapsed() >= _threshold)
    {
      LOG<< "ThreshHold : " + std::to_string(_threshold);
      LOG<< GetLogText();
    }
  }

  void Add(const std::wstring logTxt)
  {
    auto entry =std::make_shared<LogEntry>();
    entry->difference = _timer.Elapsed();
    entry->totalElapsed = _timer.TotalElapsed();
    entry->msg = logTxt;
    _logEntries.emplace_back(entry);
  }

  std::string GetLogText()
  {
    std::string logText;
    logText.append("\n----------------------------------------------------------");

    for(auto& x: _logEntries)
    {
      if(!x->msg.empty())
      {
      logText.append("\n");
      logText.append(doubleFormat(x->totalElapsed) + "   " + doubleFormat(x->difference) + "   |");
      logText.append(std::string(x->msg.begin(), x->msg.end()));
      }
    }
    logText.append("\n");
    return logText;
  }

private:
  std::string doubleFormat(double& value)
  {
    std::ostringstream d2s;
    d2s << std::setfill(' ') << std::setw(9) << std::setiosflags(std::ios::fixed) << std::setprecision(3) << value;
    return d2s.str();
  }

private:
  double _threshold;
  Stopwatch _timer;
  typedef std::vector<std::shared_ptr<LogEntry>> LogEntriesType;
  LogEntriesType _logEntries;
};
