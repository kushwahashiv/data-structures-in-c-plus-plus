#include <cmath>
#include <cstdio>

int t;
int a, b;  // numerator and denominator of the answer

void solve()
{
    // number of the diagonal in Cantor's series
    int diag = ceil(sqrt(0.25 + 2*t) - 0.5);

    // number of the term inside the diagonal
    int n = t - (diag-1)*diag / 2;
    if (diag % 2 == 0) {
        a = n;
        b = diag + 1 - n;
    }
    else {
        a = diag + 1 - n;
        b = n;
    }
}

int main()
{
  while (true) {
    if (scanf("%d", &t) != 1) break;

    solve();
    printf("TERM %d IS %d/%d\n", t, a, b);
  }

  return 0;
}

//
//#include<stdio.h>
//#include<math.h>
//int main()
//{
//    long long int n , x ,i , j ,sub , sum , t;
//    
//    scanf("%lld",&t);
//    while(t--)
//    {
//        scanf("%lld",&x);
//        n=ceil((-1+sqrt(1+8*x))/2);
//        sub = x - n*(n-1)/2;
//        sum = n+1;
//        if (n%2==0)
//            printf("TERM %lld IS %lld/%lld\n",x , sub , sum-sub);    
//        else
//            printf("TERM %lld IS %lld/%lld\n",x, sum -sub ,sub);            
//    }
//    return 0;
//}
