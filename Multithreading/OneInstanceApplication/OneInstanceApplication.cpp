#include <windows.h> 
#include <iostream>

using namespace std;

int main()
{
  try 
  {
    // Try to open the mutex.
    HANDLE hMutex = OpenMutex(MUTEX_ALL_ACCESS, FALSE, L"MyApp1.0");

    if (!hMutex)
    {
      // Mutex doesn’t exist. This is the first instance so create the mutex.
        hMutex = CreateMutex(0, FALSE, L"MyApp1.0");
    }
    else
    {
      // The mutex exists so this is the the second instance so return.
      std::cout<<"Application instance is already running.\nClosing now..."<<endl;
      getchar();
      return 0;
    }

    // The app is closing so release the mutex.
    ReleaseMutex(hMutex);
  }
  catch(...) 
  {
  }

  getchar();

  return 0;
}