#include <iostream>
using namespace std;
class Swap
{   
public:
    void swapping_by_call_by_value(int a,int b);
    void swapping_by_call_by_reference(int *a,int* b);
    void swapping_by_call_by_address(int& a,int& b);
};
void Swap::swapping_by_call_by_value(int a,int b)
{
    int t;
    t=b;
    b=a;
    a=t;
}
void Swap::swapping_by_call_by_reference(int* a,int* b)
{
    int t;
    t=*b;
    *b=*a;
    *a=t;
}
void Swap::swapping_by_call_by_address(int& a,int& b)
{
    int t;
    t=b;
    b=a;
    a=t;
}
int main()
{
    int a,b;
    Swap s;
    cout<<"enter any two values whose values are to be swapped"<<endl;
    cin>>a>>b;
    cout<<"before swapping by call by value"<<endl;
    cout<<"the value of a is :"<< a << endl;
    cout<<"the value of b is :"<< b << endl;
    s.swapping_by_call_by_value(a,b);
    cout<<"after swapping by call by value"<<endl; 
    cout<<"the value of a is :"<< a << endl;
    cout<<"the value of b is :"<< b << endl;
    cout<<"before swapping by call by reference"<<endl;
    cout<<"the value of a is :"<< a << endl;
    cout<<"the value of b is :"<< b << endl;
    s.swapping_by_call_by_reference(&a,&b);
    cout<<"after swapping by call by reference"<<endl; 
    cout<<"the value of a is :"<< a << endl;
    cout<<"the value of b is :"<< b << endl;
    cout<<"before swapping by call by address"<<endl;
    cout<<"the value of a is :"<< a << endl;
    cout<<"the value of b is :"<< b << endl;
    s.swapping_by_call_by_address(a,b);
    cout<<"after swapping by call by address"<<endl; 
    cout<<"the value of a is :"<< a << endl;
    cout<<"the value of b is :"<< b << endl;
}

