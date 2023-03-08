#include<stdio.h>
#include<stdlib.h>
struct ProcessInfo
{
    int at,bt,st,ct,wt,tat,pid,v,rt;
};
int min(struct ProcessInfo* p,int n,int end)
{
    int min=9999;
    int mindex;
    for (int i = 0; i < n; i++)
    {
        if (p[i].rt<min)
        {
            if (p[i].at<=end)
            {
                if(p[i].v!=1)
                {   
                    min=p[i].rt;
                    mindex=i;
                }
            }
        }
    }
    return mindex;
}
void swap(struct ProcessInfo* a,struct ProcessInfo* b)
{
    struct ProcessInfo temp=*a;
    *a=*b;
    *b=temp;
}
void rearrange(struct ProcessInfo* p,int n)
{
    for (int i = n-1; i > 0; i--)
    {
        for (int j = 0; j < i; j++)
        {
            if (p[j].pid>p[j+1].pid)
            {
                swap(&p[j],&p[j+1]);
            } 
        }
    }  
}
void bubbleSort(struct ProcessInfo* p,int n)
{
    for (int i = n-1; i > 0; i--)
    {
        for (int j = 0; j < i; j++)
        {
            if (p[j].at>p[j+1].at)
            {
                swap(&p[j],&p[j+1]);
            } 
        }
    }
}
void sjf(struct ProcessInfo* p,int n)
{
    int b=1;
    bubbleSort(p,n);
    int start=p[0].at;
    int end=p[0].at+1;
    p[0].rt--;
    if (p[0].rt==0)
    {
        p[0].v=1;
    }
    p[0].st=start;
    p[0].ct=end;
    while (b)
    {
        int i=min(p,n,end);
        p[i].st=end;
        p[i].ct=p[i].st+1;
        p[i].rt--;
        if (p[i].rt==0)
        {
            p[i].v=1;
        }
        end=p[i].ct;
        b=0;
        for (int j = 0; j < n; j++)
        {
            if (p[j].v!=1)
            {
                b=1;
                break;
            }   
        }
    }
    for (int i = 0; i < n; i++)
    {
        p[i].tat=p[i].ct-p[i].at;
        p[i].wt=p[i].tat-p[i].bt;
    }
    
    rearrange(p,n);
}
int main(int argc, char const *argv[])
{
    int wtsum=0,tatsum=0;
    float avgwt,avgtat;
    int n;
    printf("enter number of processes you want to give ");
    scanf("%d",&n);
    struct ProcessInfo* p=(struct ProcessInfo*)malloc(n*sizeof(struct ProcessInfo));
    for (int i = 0; i < n; i++)
    {
        p[i].v=0;
        printf("enter required details of process %d\n",i);
        printf("process id : ");
        scanf("%d",&p[i].pid);
        printf("arrived time : ");
        scanf("%d",&p[i].at);
        printf("burst time : ");
        scanf("%d",&p[i].bt);
        p[i].rt=p[i].bt;
    }
    sjf(p,n);
    printf("waiting time        turnaround time\n");
    for (int i = 0; i < n; i++)
    {
        printf("     %d                    %d       \n",p[i].wt,p[i].tat);
        wtsum=wtsum+p[i].wt;
        tatsum=tatsum+p[i].tat;
    }
    avgwt=(float)wtsum/n;
    avgtat=(float)tatsum/n;
    printf("average waiting time is %f and average turnaround time is %f",avgwt,avgtat);    
    return 0;
}