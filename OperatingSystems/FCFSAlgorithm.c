#include <stdio.h>
#include <stdlib.h>
struct ProcessInfo
{
    int at,bt,st,ct,wt,tat;
};
int min(struct ProcessInfo* p,int *v,int n)
{
    int mindex;
    int min=999;
    for (int i = 0; i < n; i++)
    {
        if (p[i].at<min)
        {
            if (v[i]==1)
            {
                continue;
            }
            min=p[i].at;
            mindex=i;
        }
    }
    return mindex;
}
void fcfs(struct ProcessInfo* p,int *v,int n)
{
    int cp,ini,b=1;
    ini=min(p,v,n);
    v[ini]=1;
    int start=p[ini].at;
    p[ini].st=start;
    int end=p[ini].at+p[ini].bt;
    p[ini].ct=end;
    p[ini].wt=0;
    p[ini].tat=p[ini].wt+p[ini].bt;
    while (b)
    {
        b=0;
        cp=min(p,v,n);
        v[cp]=1;
        if (cp!=ini)
        {
            if (p[cp].at<=end)
            {
                p[cp].st=end;
                p[cp].ct=p[cp].st+p[cp].bt;
                end=p[cp].ct;
                p[cp].wt=p[cp].st-p[cp].at;
                p[cp].tat=p[cp].wt+p[cp].bt;
            }
            else
            {
                start=p[cp].at;
                p[cp].st=start;
                p[cp].ct=p[cp].st+p[cp].bt;
                end=p[cp].ct;
                p[cp].wt=p[cp].st-p[cp].at;
                p[cp].tat=p[cp].wt+p[cp].bt;
            }
        }
        for (int i = 0; i < n; i++)
        {
            if (v[i]!=1)
            {
                b=1;
                break;
            }
            
        }
        
    }
    
}
int main(int argc, char const *argv[])
{
    int n;
    printf("enter number of processes you want to give ");
    scanf("%d",&n);
    int *visited=(int*)malloc(n*sizeof(int));
    struct ProcessInfo* p=(struct ProcessInfo*)malloc(n*sizeof(struct ProcessInfo));
    for (int i = 0; i < n; i++)
    {
        visited[i]=0;
        printf("enter required details of process %d\n",i);
        printf("arrived time : ");
        scanf("%d",&p[i].at);
        printf("burst time : ");
        scanf("%d",&p[i].bt);
    }
    fcfs(p,visited,n);
    for (int i = 0; i < n; i++)
    {
        printf("%d\n",p[i].wt);
    }
    
    return 0;
}
