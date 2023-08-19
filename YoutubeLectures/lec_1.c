#include<stdio.h>      //preprocessor directive(i.e will be decoded by preprocessor)
/*int 
float
double
char....
*/
//These data types are used to say whether the given value is integer,character,real number and so  on
int main(int argc, char const *argv[])
{
    int temp=5;
    float temp1=3.5;
    double temp2=5.673;
//These functions printf and scanf are used to recieve output from system and give input to system
    //format specifiers
//\n used to specify that goto next line
    printf("the value of temp is %d\n",temp);
    printf("the value of temp is %f\n",temp1);
    printf("the value of temp is %lf\n",temp2);
    return 0;
}

