#include <stdio.h>
#include <stdlib.h>
void enqueue(int* sequence,int data,int n)
{
    int i=0;
    while (sequence[i]!=-1)
    {
        i++;
    }
    sequence[i]=data;
}
void BankersSafetyAlgorithm(int** max,int** alloc,int* tempavail,int* sequence,int n,int m)
{
    int visitedcount=0;
    int visited[n];
    int temp[m];
    while(visitedcount!=n)
    {
        for (int i = 0; i < n; i++)
        {
            int typecount=0;
            for (int j = 0; j < m; j++)
            {
                for (int k = 0; k < m; k++)
                {
                    temp[k]=tempavail[k];
                }
                if (alloc[i][j]+tempavail[j]>=max[i][j]&&visited[i]!=1)
                {
                    typecount++;
                    tempavail[j]=tempavail[j]+alloc[i][j];
                    if (typecount==m)
                    {
                        enqueue(sequence,i,n);
                        visited[i]=1;
                        visitedcount++;
                    }
                }
                else
                {
                    typecount=0;
                    for (int k = 0; k < m; k++)
                    {
                        tempavail[k]=temp[k];
                    }
                    break;
                }
            }
        }
    }
}
int main()
{
    int n,m;
    printf("enter number of processes available : ");
    scanf("%d",&n);
    printf("enter number of types of resources available : ");
    scanf("%d",&m);
    int** max=(int**)malloc(n*sizeof(int*));
    int** alloc=(int**)malloc(n*sizeof(int*));
    int* avail=(int*)malloc(m*sizeof(int));
    int* sequence=(int*)malloc(n*sizeof(int));
    int* tempavail=(int*)malloc(m*sizeof(int));
    for (int i = 0; i < n; i++)
    {
        max[i]=(int*)malloc(m*sizeof(int));
        alloc[i]=(int*)malloc(m*sizeof(int));
        sequence[i]=-1;
    }
    printf("enter maximum number of instances of resources to be allocated for all the processes :\n");
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            scanf("%d",&max[i][j]);
        }
    }
    printf("enter number of instances of resources allocated for all the processes :\n");
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            scanf("%d",&alloc[i][j]);
        }
    }
    printf("now enter number of instances of resources available : ");
    for (int i = 0; i < m; i++)
    {
        scanf("%d",&avail[i]);
        tempavail[i]=avail[i];
    }
    BankersSafetyAlgorithm(max,alloc,tempavail,sequence,n,m);
    if (sequence[n-1]==-1)
    {
        printf("Unsafe\n");
    }
    else
    {
        printf("The safe sequence is :");
        for (int i = 0; i < n; i++)
        {
            printf(" %d",sequence[i]);
        }
    }
}