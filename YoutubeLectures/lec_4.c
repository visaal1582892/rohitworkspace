#include<stdio.h>
//Assignment operators
int main(int argc, char const *argv[])
{
    int x=1,y=2,z=3;
    x+=y-=z*=2;
    //z=z*2
    //z=6
    //x+=y-=6
    //y=y-6
    //y=-4
    //x+=-4
    //x=x+(-4)
    //x=-3
    printf("x=%d y=%d z=%d",x,y,z);
    return 0;
}
