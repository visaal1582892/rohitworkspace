#include <iostream>
using namespace std;
bool binarySearch(int difference,int n,int *a)
{
    bool b=false;
    int l=0;
    int h=n-1;
    while (l<=h)
    {
        int mid=(l+h)/2;
        if (difference==a[mid])
        {
            b=true;
            break;
        }
        else if(difference<a[mid])
        {
            h=mid-1;
        }
        else if(difference>a[mid])
        {
            l=mid+1;
        }   
    }
    return b;    
}
void check(int *a,int n,int key)
{
    for (int i = 0; i < n; i++)
    {
        int difference=key-a[i];
        bool c=binarySearch(difference,n,a);
        if(c)
        {
            cout<<"we can get the given number by adding numbers "<<a[i]<<" and "<<difference<<" of given array"<<endl;
            return;
        }
        else
        {
            cout<<"we cannot get the given number by adding any of the elements of given array"<<endl;
            return;
        }   
    }
}
int main()
{
    int n,key;
    cout<<"enter number of elements you want to enter into an array"<<endl;
    cin>>n;
    int *a=new int(n);
    cout<<"now enter elements one by one in accending order: ";
    for (int i = 0; i < n; i++)
    {
        cin>>a[i];
    }
    cout<<"now enter the number to check that we can get that number by adding any two numbers of the array"<<endl;
    cin>>key;
    check(a,n,key);   
}