#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int n,k=0;
struct memory
{
    int data,link;
}m[100];
struct File
{
    char file[30];
    int start,end;
}f[50];
void create()
{
    int fl;
    char fname[30];
    printf("enter the file name to be created : ");
    scanf("%s",fname);
    strcpy(f[k].file,fname);
    for (int i = 0; i < k; i++)
    {
        if (strcmp(f[i].file,fname)==0)
        {
            printf("file already existed enter another file name : ");
            scanf("%s",fname);
            i=-1;
        }
    }
    printf("enter the start index of file : ");
    scanf("%d",&f[k].start);
    while (1)
    {
        if (m[f[k].start].data!=-1)
        {
            printf("\ngiven start is not empty enter another start : ");
            scanf("%d",&f[k].start);
        }
        else{break;}
    }
    printf("\nenter length of file you want to store : ");
    scanf("%d",&fl);
    int cp=f[k].start;
    int temp;
    for (int i = 0; i < fl; i++)
    {
        printf("%d ",cp);
        m[cp].data=k;
        if (i==fl-1)
        {
            f[k].end=cp;
        }
        printf("%d ",f[k].end);
        printf("%d ",m[cp].data);
        temp=rand()%n;
        while (1)
        {
            if (m[temp].data!=-1)
            {
                temp=rand()%n;
            }
            else{break;}
        }
        m[cp].link=temp;
        cp=temp;
    }
    printf("\nfile created successfully\n");
    k++;
}
int main(int argc, char const *argv[])
{
    int choice;
    printf("enter total number of memory blocks available : ");
    scanf("%d",&n);
    for (int i = 0; i < 100; i++)
    {
        m[i].data=-1;
        m[i].link=-1;
    }
    printf("enter 1 to create a file \n");
    printf("enter 2 to delete a file \n");
    printf("enter 3 to traverse a file \n");
    printf("enter 0 to stop execution\n");
    while (1)
    {
        printf("enter the choice : ");
        scanf("%d",&choice);
        switch (choice)
        {
        case 1:create();
            break;
        // case 2:delete();
        //     break;
        // case 3:traverse();
        //     break;
        case 0:return 1;
        default: printf("invalid choice\n");
            break;
        }
    }
      
    return 0;
}
