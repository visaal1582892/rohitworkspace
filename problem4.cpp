//write a function to check if a string is a palindrome or not
#include<iostream>
#include<string.h>
#include<malloc.h>
using namespace std;
string f(string y,int x)
{
    int i;
    char b;
    for ( i = 0; i < (x/2); i++)
    {
        b=y[i];
        y[i]=y[x-1-i];
        y[x-1-i]=b;
    } 
    return y;    
}
int main()
{
    int n,m;
    cout<<"enter your required size"<<endl;
    cin>>n;
    char *p=(char*)malloc(n*sizeof(char));
    cout<<"enter the string"<<endl;
    cin>>p;
    m=strlen(p);
    cout<<f(p,m)<<endl;
}
 