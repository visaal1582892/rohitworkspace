//Reversing the elements of the array using a function.
#include<iostream>
#include<malloc.h>
using namespace std;
void f(int q[],int m)
{
    int b,i;
    for ( i = 0; i < (m/2); i++)
    {
        b=q[i];
        q[i]=q[m-1-i];
        q[m-1-i]=b;
    }
    
}
int main(int argc, char const *argv[])
{
    int n,i;
    cout<<"enter the size of array you want to create"<<endl;
    cin>>n;
    int *p=(int *)malloc(n*sizeof(int));
    cout<<"enter elements of array"<<endl;
    for ( i = 0; i < n; i++)
    {
        cin>>p[i];
    }
    for ( i = 0; i < n; i++)
    {
        cout<<p[i]<<" ";
    }
    cout<<endl;
    cout<<"are the elements of array before reversing"<<endl;
    f(p,n);
    cout<<"after reversing the elements of array will be"<<endl;
    for ( i = 0; i < n; i++)
    {
        cout<<p[i]<<" ";
    }
    return 0;
}
