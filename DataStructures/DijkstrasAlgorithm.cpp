#include<iostream>
#define MAX 999
using namespace std;
int min(int *s,bool *v,int n,int cp)
{
    int a;
    int min=MAX;
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
    int *distance=new int[n];
    bool *visited=new bool[n];
    for (int i = 0; i < n; i++)
    {
        distance[i]=MAX;
        visited[i]=false;
    }
    cp=0;
    distance[0]=0;
    while (b)
    {
        visited[cp]=true;
        for (int i = 0; i < n; i++)
        {
            if (visited[i]==true)
            {
                continue;
            }
            if (a[cp][i]!=999&&(a[cp][i]+distance[cp])<distance[i])
            {
                distance[i]=a[cp][i]+distance[cp];
            }       
        }
        cp=min(distance,visited,n,cp);
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
    for (int i = 0; i < n; i++)
    {
        cout<<distance[i]<<" "<<" "<<visited[i]<<endl;
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