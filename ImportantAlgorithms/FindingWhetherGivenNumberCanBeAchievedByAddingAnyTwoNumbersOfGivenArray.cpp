#include <iostream>
using namespace std;
void check(int *a,int n,int key)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (key==a[i]+a[j])
            {
                cout<<"we can get the given number by adding numbers "<<a[i]<<" and "<<a[j]<<" of given array"<<endl;
                return;
            }
            else if((i==(n-1))&&(j==(n-1)))
            {
                cout<<"we cannot get the given number by adding any of the elements of given array"<<endl;
                return;
            }
            
        }
        
    }
}
int main()
{
    int n,key;
    cout<<"enter number of elements you want to enter into an array"<<endl;
    cin>>n;
    int *a=new int(n);
    cout<<"now enter elements one by one : ";
    for (int i = 0; i < n; i++)
    {
        cin>>a[i];
    }
    cout<<"now enter the number to check that we can get that number by adding any two numbers of the array"<<endl;
    cin>>key;
    check(a,n,key);   
}