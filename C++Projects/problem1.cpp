//Take n as input from user and write a program which works as follows :
//if n s odd : evaluates and prints factorial of n
//if n is even : evaluates and prints sum of all the whole numbers upto and including n
#include<iostream>
using namespace std;
int main()
{
    long int n,sum,i;
    double f;
    cout << "enter the value of n" << endl;
    cin>>n;
    if (n%2==0)
    {
        sum=0;
        for ( i = 0; i <= n; i++)
        {
            sum = i+sum;
        }
        cout << "the given value of n is even so as requestesd by the question" << endl;
        cout << "the sum of whole numbers upto and including n is " << sum << endl;
        
    }
    else
    {f=1;
    for ( i = 1; i <= n; i++)
    {
        f=f*i;
    }
    cout << "the given value of n is odd so as requestesd by the question" << endl;
        cout << "the factorial of given number is " << f << endl;
    }
    
    
    return 0;
}

