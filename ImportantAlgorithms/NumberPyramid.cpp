#include <iostream>
using namespace std;
int main(int argc, char const *argv[])
{
    int n;
    cout<<"enter number of lines of pattern you want : ";
    cin>>n;
    for (int i = 1; i <= n; i++)
    {
        for (int j = n-1; j >= i ; j--)
        {
            cout<<" ";
        }
        int k=i;
        while (k<=i+(i-1))
        {
            cout<<k;
            k+=1;
        }
        int l=k-2;
        while (l>=i)
        {
            cout<<l;
            l-=1;
        }
        cout<<"\n";
    }
    
    return 0;
}
