#include<stdio.h>//header file
//Arithmetic operators  *,/,%,+,-
int main(int argc, char const *argv[])
{
    int a,b;
    int sum,difference,product,division,modulo;
    printf("\nenter the value of a : ");
    scanf("%d",&a);
    printf("\nenter the value of b : ");
    scanf("%d",&b);
    sum=a+b;
    difference=a-b;
    product=a*b;
    division=a/b;
    modulo=a%b;
    printf("\nvalue of sum is : %d",sum);
    printf("\nvalue of sum is : %d",difference);
    printf("\nvalue of sum is : %d",product);
    printf("\nvalue of sum is : %d",division);
    printf("\nvalue of sum is : %d",modulo);
    return 0;
}
