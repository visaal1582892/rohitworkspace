//write a function to find number of vowels in a string.
#include<iostream>
#include<malloc.h>
using namespace std;
int f(string y)
{
    int v=0;
    int i=0;
    for ( i = 0;y[i] != '\0'; i++)
    {
        if (y[i]=='a'||y[i]=='e'||y[i]=='i'||y[i]=='o'||y[i]=='u')
        {
            v=v+1;
        }
        
    }
    return v;
}
using namespace std;
int main()
{
    int n;
    cout<<"enter number of characters you want to enter" << endl;
    cin>>n;
    char *p=(char *)malloc(n*sizeof(char));
    cout<<"enter the string " << endl;
    cin>>p;
    cout<<"number of vowels in given string is " << f(p) << endl;
    return 0;
}
