#include<iostream>
#define MAX 999
using namespace std;
int min(int *s,bool *v,int n,int cp)
{
    int a;
    int min=s[0];
    for (int i = 1; i < n; i++)
    {
        if (s[i]<min)
        {
            if (v[i]==true)
            {
                continue;
            }
            
            min=s[i];
            a=i;
        }
    }
    return a;
}
void mst(int **a,int n)
{
    bool b=true;
    int cp;
    int *parent=new int[n];
    int *weight=new int[n];
    bool *visited=new bool[n];
    for (int i = 0; i < n; i++)
    {
        parent[i]=-1;
        weight[i]=MAX;
        visited[i]=false;
    }
    cp=0;
    while (b)
    {
        visited[cp]=true;
        for (int i = 0; i < n; i++)
        {
            if (visited[i]==true)
            {
                continue;
            }
            if (a[cp][i]!=999&&a[cp][i]<weight[i])
            {
                parent[i]=cp;
                weight[i]=a[cp][i];
            }       
        }
        cp=min(weight,visited,n,cp);
        for (int i = 1; i < n; i++)
        {
            b=false;
            if (visited[i]!=true)
            {
                b=true;
                break;
            }
        } 
    }
    weight[0]=0;
    for (int i = 0; i < n; i++)
    {
        cout<<weight[i]<<" "<<parent[i]<<" "<<visited[i]<<endl;
    }
    
}
int main(int argc, char const *argv[])
{
    int n;
    cout<<"enter number of vertices you want to use"<<endl;
    cin>>n;
    int **a=new int*[n];
    for (int i = 0; i < n; i++)
    {
        a[i]=new int[n];
        cout<<"now enter weights corresponding to edges starting from vertex "<<i<<endl;
        for (int j = 0; j < n; j++)
        {
            cin>>a[i][j];
        }
    }
    mst(a,n);
    return 0;
}

