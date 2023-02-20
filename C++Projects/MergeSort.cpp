#include<iostream>
using namespace std;
void merge(int *a,int l,int mid,int h)
{
    int n1=(mid-l);
    int n2=(h-mid)+1;
    int *a1=new int[n1];
    int *a2=new int[n2];
    for (int i = 0; i < n1; i++)
    {
        a1[i]=a[l+i];
    }
    for (int i = 0; i < n2; i++)
    {
        a2[i]=a[mid+i];
    }
    int i=0;
    int j=0;
    int k=l;
    while (i<n1&&j<n2)
    {
        if (a1[i]<=a2[j])
        {
            a[k]=a1[i];
            i++;
        }
        else if (a1[i]>a2[j])
        {
            a[k]=a2[j];
            j++;
        }
        k++;
    }
    while (i<n1)
    {
        a[k]=a1[i];
        k++;
        i++;
    }
    while (j<n2)
    {
        a[k]=a2[j];
        k++;
        j++;
    }
}
void mergeSort(int *a,int l,int h)
{
    if (l<h)
    {
        int mid=(l+h)/2;
        mergeSort(a,l,mid);
        mergeSort(a,mid+1,h);
        merge(a,l,mid,h);
    }
    
}
int main(int argc, char const *argv[])
{
    int n;
    cout<<"enter number of elements you want to give"<<endl;
    cin>>n;
    cout<<"now enter the elements one by one"<<endl;
    int *a=new int[n];
    for (int i = 0; i < n; i++)
    {
        cin>>a[i];
    }
    mergeSort(a,0,n-1);
    for (int i = 0; i < n; i++)
    {
        cout<<a[i]<<endl;
    }
}