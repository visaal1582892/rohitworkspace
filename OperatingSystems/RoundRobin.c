#include<stdio.h>
#include<stdlib.h>
struct ProcessInfo
{
    int at,bt,st,ct,wt,tat,pid,v;
};
void roundrobin()
{
       
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
        printf("arrived time : ");
        scanf("%d",&p[i].at);
        printf("burst time : ");
        scanf("%d",&p[i].bt);
        printf("process id : ");
        scanf("%d",&p[i].pid);
    }
    roundrobin(p,n);
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