#include<iostream>
#include<malloc.h>
using namespace std;
void func(int ram[])//here we can also write int ram[6] or int *ram
{
    ram[4]=ram[4]+3;
    cout<<ram[4];
}
int main(int argc, char const *argv[])
{
    int i,n;
    cout<<"enter the required size of array"<<endl;
    cin>>n;
    int *p=(int *)malloc(n*sizeof(int));
    cout<<"enter the elements of array"<<endl;
    for(i=0;i<n;i++)
    {
        cin>>p[i];
    }
    func(p);
    return 0;
}
