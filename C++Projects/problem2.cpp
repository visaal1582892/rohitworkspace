//take n as input from user and write a  program to evaluate and print sum of all the 
//digits present in n.
#include<iostream>
using namespace std;
int main(int argc, char const *argv[])
{
    int i=0;
    long int n;
    cout << "enter the value of n" << endl;
    cin >> n;
    while (n!=0)
    {
        i=i+n%10;
        n=n/10;
    }
    cout << "the sum of digits of given number is " << i << endl;

    
    return 0;
}
