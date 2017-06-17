#include <iostream>
#include "LFUCache.h"
#include "cache.h"



using namespace std;

class proxyHandler //: virtual public proxyIf
{
private:
  string* loadPage(const string& URL)
  {
    /*
    CURL *curl;
    CURLcode res;
    struct wd_in wdi;

    memset(&wdi, 0, sizeof(wdi));

    // Get a curl handle.  Each thread will need a unique handle.
    curl = curl_easy_init();

    if (nullptr != curl)//following block is a copy-paste from the given libcurl example
    {
      wdi.size = 1024;
      // Check for malloc failure in real code.
      wdi.data = (char*)malloc(wdi.size);

      //Set the URL for the operation. 
      curl_easy_setopt(curl, CURLOPT_URL, URL.c_str());

      // "write_data" function to call with returned data. 
      curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, write_data);

      // userp parameter passed to write_data.
      curl_easy_setopt(curl, CURLOPT_WRITEDATA, &wdi);

      // Actually perform the query.
      res = curl_easy_perform(curl);

      // Check the return value and do whatever.

      // Clean up after ourselves.
      curl_easy_cleanup(curl);
    }
    else
    {
      fprintf(stderr, "Error: could not get CURL handle.\n");
      exit(EXIT_FAILURE);
    }
    */

    //string* page_ptr = new string(wdi.data, wdi.len);
    string* page_ptr;

   // cleanup wdi.data buffer. 
    //free(wdi.data);

    //cout << "TEST" << endl;
    //_return = URL;

    return page_ptr;
  }

  int hit_count;
  int miss_count;
  int network_volume;
  int cached_volume;


public:
  proxyHandler(string& policy, unsigned int cache_size)
  {
    hit_count = 0;
    miss_count = 0;
    network_volume = 0;
    cached_volume = 0;

    cout << "Cache  LFU (" << cache_size << " Bytes)" << endl << endl;
    cache = new LFUCache(cache_size);
  }

  ~proxyHandler()
  {
    delete cache;
  }

  void getPage(string& _return, const string& URL)
  {
    cout << "Page requested: '" << URL << "'" << endl;

    string* page_ptr = cache->find(URL);

    if (page_ptr != nullptr)//page found in local cache
    {
      hit_count++;
      cached_volume += page_ptr->size();

      cout << "	Found requested page in cache: '" << URL << "\' (" << page_ptr->size() << " Bytes)" << endl;

      _return = *page_ptr;
    }
    else//page not found in local cache
    {
      page_ptr = loadPage(URL);//load it from the web

      if (page_ptr != nullptr)
        _return = *page_ptr;

      cout << "	Cache current size: " << cache->getCurrentSize() << " Bytes" << endl;
      cout << "	Inserting page: '" << URL << "\' (" << _return.size() << " Bytes)" << endl;

      ++miss_count;
      network_volume += page_ptr->size();

      cache->add(URL, page_ptr);//put it in the cache
    }

    cout << endl;
  }

  int getCachedVolume()
  {
    return cached_volume;
  }

  int getNetworkVolume()
  {
    return network_volume;
  }

  int getHitCount()
  {
    return hit_count;
  }

  int getMissCount()
  {
    return miss_count;
  }

  void resetCounters()
  {
    cached_volume = 0;
    network_volume = 0;
    hit_count = 0;
    miss_count = 0;
  }

private:
  Cache* cache;

};




int main()
{
  unsigned int cache_size;
  Cache* cache;

  
  
  string URL;
  string* page_ptr = cache->find(URL);
  cache->add(URL, page_ptr);


  return 0;
}