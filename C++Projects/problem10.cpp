#include<iostream>
using namespace std;
int fun(int p, int *q, int **r){
++*q;
**r*=2;
p%=11;
return (p+*q+**r);
}
int main(int argc, char const *argv[])
{
    int *p,a;
    cout<<"enter any number"<<endl;
    cin>>a;
    p=&a;
    cout<<"after passing value of a into function the final value result and final value of a are "<<endl;
    cout<<fun(a,&a,&p)<<endl;
    cout<<a<<endl;
    return 0;
}
