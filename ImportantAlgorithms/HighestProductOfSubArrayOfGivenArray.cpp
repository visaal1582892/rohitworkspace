#include <iostream>
#include <bits/stdc++.h>
using namespace std;
int max(vector<int> b)
{
    int n=b.size();
    int max=b[0];
    for (int i = 1; i < n; i++)
    {
        if (b[i]>max)
        {
            max=b[i];
        }
        
    }
    return max;
}
int main(int argc, char const *argv[])
{
    vector<int> b,c;
    int max_product;
    int n;
    cout<<"enter number of elements you want to give to an array"<<endl;
    cin>>n;
    int* a=new int(n);
    cout<<"now enter the elements of array"<<endl;
    for (int i = 0; i < n; i++)
    {
        cin>>a[i];
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = i+1; j < n; j++)
        {
            int product=1;
            for(int k=i;k<=j;k++)
            {
                product=product*a[k];
            }
            c.push_back(product);
        }
        b.push_back(max(c));
    }
    cout<<"maximum product that can be obtained is "<<max(b)<<endl;
    return 0;
}
