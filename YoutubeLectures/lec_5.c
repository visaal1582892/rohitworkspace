#include<stdio.h>
//Selection statements
int main(int argc, char const *argv[])
{
    int x=5;
    switch (x-2)
    {
    case 3:
        printf("the value of x is 3");
        break;
    case 4:
        printf("the value of x is 4");
        break;
    case 5:
        printf("the value of x is 5");
        break;
    default:
        printf("all above cases are failed");
        break;
    }
    return 0;
}
