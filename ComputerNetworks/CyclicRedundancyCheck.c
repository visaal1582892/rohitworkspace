#include <stdio.h>
#include <stdlib.h>
void xor(int* polynomial,int* tp,int p)
{
    for (int i = 0; i < p; i++)
    {
        tp[i]=polynomial[i]^tp[i];
    }
}
void leftshift(int* data,int* visited,int d,int* tp,int p,int* v)
{
    if ((*v)==d)
    {
        (*v)++;
        return;   
    }
    for (int i = 0; i < p-1; i++)
    {
        tp[i]=tp[i+1];
    }
    for (int i = 0; i < d; i++)
    {
        if (visited[i]==0)
        {
            tp[p-1]=data[i];
            visited[i]=1;
            (*v)++;
            return;
        }
    }
}
void CRC(int* data,int d,int m,int* polynomial,int p)
{
    int* tp=(int*)malloc(p*sizeof(int));
    int* visited=(int*)malloc(d*sizeof(int));
    int v=p;
    for (int i = 0; i < d; i++)
    {
        if (i<=p-1)
        {
            visited[i]=1;    
        }
        else
        {
            visited[i]=0;
        }
    }
    for (int i = 0; i < p; i++)
    {
        tp[i]=data[i];
    }
    while (v<=d)
    {  
        if (tp[0]==0)
        {
            leftshift(data,visited,d,tp,p,&v);
        }
        else
        {
            xor(polynomial,tp,p);
            leftshift(data,visited,d,tp,p,&v);
        }
    } 
    for (int i = 1; i < p; i++)
    {
        data[(m-1)+i]=tp[i];
    }
    printf("the final data to be sent is : ");
    for (int i = 0; i < d; i++)
    {
        printf("%d ",data[i]);
    }
}
int main(int argc, char const *argv[])
{
    int m,p,d;
    printf("enter number of message bits you want to give : ");
    scanf("%d",&m);
    int* message=(int*)malloc(m*sizeof(int));
    printf("now enter the message bits : ");
    for (int i = 0; i < m; i++)
    {
        scanf("%d",&message[i]);
    }
    printf("enter number of terms in the polynomial including those with zero coefficients : ");
    scanf("%d",&p);
    int* polynomial=(int*)malloc(p*sizeof(int));
    printf("now enter the coefficients of polynomial from highest degree to lowest degree : ");
    for (int i = 0; i < p; i++)
    {
        scanf("%d",&polynomial[i]);
    }
    d=m+p-1;
    int* data=(int*)malloc((d)*sizeof(int));
    for (int i = 0; i < d; i++)
    {
        if (i<=m-1)
        {
            data[i]=message[i];
        }
        else if (i>m-1)
        {
            data[i]=0;
        }
    }
    CRC(data,d,m,polynomial,p);
    return 0;
}
