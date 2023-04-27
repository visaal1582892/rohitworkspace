#include<stdio.h>
#include<stdlib.h>
struct ProcessInfo
{
    int at,bt,st,ct,wt,tat,pid,v,mbt;
};
struct Node
{
    int data;
    struct Node* next;
};
struct Node* front=NULL;
struct Node* rear=NULL;
void enqueue(int data)
{
    struct Node* newnode=(struct Node*)malloc(sizeof(struct Node));
    newnode->data=data;
    newnode->next=NULL;
    if (rear==NULL)
    {
        rear=newnode;
        front=newnode;
    }
    else
    {
        rear->next=newnode;
        rear=newnode;
    }
}
int dequeue()
{
    int temp=front->data;
    if (front==rear)
    {
        front=NULL;
        rear=NULL;
    }
    else
    {
        front=front->next;
    }
    return temp;
}
int inqueue(int temp)
{
    struct Node* t=front;
    while (t!=NULL)
    {
        if (temp==t->data)
        {
            return 1;
        }
        t=t->next;
    }
    return 0;
}
void swap(struct ProcessInfo* p,struct ProcessInfo* q)
{
    struct ProcessInfo temp=*p;
    *p=*q;
    *q=temp;
}
void bubbleSort(struct ProcessInfo* p,int n)
{
    for (int i = n-1; i > 0; i--)
    {
        for (int j = 0; j <= i; j++)
        {
            if (p[j].at>p[j+1].at)
            {
                swap(&p[j],&p[j+1]);
            }            
        }
    }
}
void rearrange(struct ProcessInfo* p,int n)
{
    for (int i = n-1; i > 0; i--)
    {
        for (int j = 0; j <= i; j++)
        {
            if (p[j].pid>p[j+1].pid)
            {
                swap(&p[j],&p[j+1]);
            }            
        }
    }
}
void roundrobin(struct ProcessInfo* p,int n,int tq)
{
    int cp;
    int visited=0;
    bubbleSort(p,n);
    int end=p[0].at;
    enqueue(0);
    while (visited!=n)
    {
        cp=dequeue();
        if (p[cp].mbt<=tq)
        {
            p[cp].ct=end+p[cp].mbt;
            end=p[cp].ct;
            p[cp].v=1;
            visited++;
            p[cp].mbt=0;
        }
        else
        {
            p[cp].ct=end+tq;
            end=p[cp].ct;
            p[cp].mbt=p[cp].mbt-tq;
        }
        printf("%d",end);
        for (int i = 0; (i < n); i++)
        {
            if ((i!=cp) && (inqueue(i)!=1) && p[i].v!=1 && i<=end)
            {
                enqueue(i);   
            }          
        }
        if (p[cp].v!=1)
        {
            enqueue(cp);
        }
    }
    rearrange(p,n);
}
int main()
{
    int tq;
    int wtsum=0,tatsum=0;
    float avgwt,avgtat;
    int n;
    printf("enter number of processes you want to give ");
    scanf("%d",&n);
    struct ProcessInfo* p=(struct ProcessInfo*)malloc(n*sizeof(struct ProcessInfo));
    for (int i = 0; i < n; i++)
    {
        printf("enter required details of process %d\n",i);
        p[i].v=0;
        printf("process id : ");
        scanf("%d",&p[i].pid);
        printf("arrived time : ");
        scanf("%d",&p[i].at);
        printf("burst time : ");
        scanf("%d",&p[i].bt);
        p[i].mbt=p[i].bt;
    }
    printf("enter the value of time quantum");
    scanf("%d",&tq);
    roundrobin(p,n,tq);
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