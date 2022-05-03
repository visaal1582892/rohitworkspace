//finding second largest element in the array
#include<iostream>
#include<malloc.h>
using namespace std;
int f(int q[],int m)
{   int i;
    int max1=q[0];
    for ( i = 1; i < m; i++)
    {
        if (q[i]>max1)
        {
            max1=q[i];
        }
        
    }
    int max2=0;
    for ( i = 0; i < m; i++)
    {
        if (q[i]!=max1)
        {
            if (q[i]>=max2)
            {
                max2=q[i];        
            }
            
        }
        else
            {
                continue;
            }
        
    }
    return max2;
    
}
int main(int argc, char const *argv[])
{
    int n,i;
    cout<<"enter the size of array required"<<endl;
    cin>>n;
    int *p=(int*)malloc(n*sizeof(int));
    cout<<"Enter the elements of array"<<endl;
    for ( i = 0; i < n; i++)
    {
        cin>>p[i];
    }
    cout<<"the second largest number in given array of integers is "<<f(p,n)<<endl;
    
    return 0;
}
