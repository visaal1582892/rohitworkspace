//Factorial using recursion 
#include<iostream>
using namespace std;
long int f(int x)
{
    if (x==1)
    {
        return 1;
    }
    return x*f(x-1);
    
}
int main()
{
    int n;
    cout<<"enter the number whose factorial you want"<<endl;
    cin>>n;
    long int y=f(n);
    cout<<"the factorial of given number is "<<y<<endl;
    return 0;
}
