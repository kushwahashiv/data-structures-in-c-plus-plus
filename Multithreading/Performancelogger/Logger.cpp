#include"logger.h"

int main()
{
  CPerformanceLog performanceLog(0.0);
  performanceLog.Add(L"Entered in function CClientCommission::GetCommissionAmountV5");

  //stuff of which performace logging u want

  performanceLog.Add(L"Exited from CClientCommission::GetCommissionAmountV5");

  return 0;

}