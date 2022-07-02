//Fibonacci series using recursion 
#include<iostream>
using namespace std;
int f(int n)
{
    if (n!=1&&n!=2)
    {
        return f(n-1)+f(n-2);
    }
    if (n==2)
    {
        return 1;
    }
     return 0;
}
    int main()
    {
        int x,i;
        cout<<"enter number of terms of fibonacci series you want to print "<<endl;
        cin>>x;
        cout<<"the requested number of terms in fibonacci series are"<<endl;
        for ( i = 1; i <= x; i++)
        {
            cout<<f(i)<<",";
        }
        
        return 0;
    }
    

        