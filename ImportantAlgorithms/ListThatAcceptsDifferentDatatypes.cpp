#include <iostream>
#include <string>
using namespace std;
class Node
{
    public:
    void *dp;
    int type;
    Node *next;
    Node* prev;
};
void push(void* key,int ty,Node** start)
{
    Node* newnode=new Node();
    newnode->dp=key;
    newnode->type=ty;
    newnode->next=*start;
    *start=newnode;
    cout<<"element inserted"<<endl;

}
void pop(Node** start)
{
    Node* temp;
    if ((*start)==NULL)
    {
        cout<<"stack empty"<<endl;
        return;
    }
    temp=(*start);
    (*start)=(*start)->next;
    free(temp);
    cout<<"element deleted"<<endl;
}
void display(Node* start)
{
    Node* t=start;
    if (t==NULL)
    {
        cout<<"stack is empty"<<endl;
        return;
    }
    cout<<"the elements of stack are :"<<endl;
    do
    {
        switch (t->type)
        {
        case 1:
            cout<<*((string*)t->dp)<<endl;
            break;
        case 2:
            cout<<*((int*)t->dp)<<endl;
            break;
        case 3:
            cout<<*((double*)t->dp)<<endl;
            break;
        case 4:
            cout<<*((char*)t->dp)<<endl;
            break;
        case 5:
            cout<<*((bool*)t->dp)<<endl;
            break;
        }
        t=t->next;
    } while (t!=NULL);
    
}
int main()
{   
    char dt;
    int ch;
    string a;
    int b;
    double c;
    char d;
    bool e;
    Node *start=NULL;
    Node *last=NULL;
    cout<<"enter 1 to push an element into stack"<<endl;
    cout<<"enter 2 to pop an element from stack"<<endl;
    cout<<"enter 3 to display elements of stack"<<endl;
    cout<<"enter 0 to exit"<<endl;
    cout<<endl;
    do
    {
        cout<<"enter your choice from above given options"<<endl;
        cin>>ch;
        switch (ch)
        {
        case 1:
            cout<<"enter s to enter string data"<<endl;
            cout<<"enter i to enter int data"<<endl;
            cout<<"enter d to enter double data"<<endl;
            cout<<"enter c to enter char data"<<endl;
            cout<<"enter b to enter bool data"<<endl;
            cout<<endl;
            cout<<"now enter your choice"<<endl;
            cin>>dt;
            switch (dt)
            {
            case 's':
                cout<<"enter the string element which you want to push into stack"<<endl;
                cin>>a;
                push(&a,1,&start);
                break;
            case 'i':
                cout<<"enter the int element which you want to push into stack"<<endl;
                cin>>b;
                push(&b,2,&start);
                break;
            case 'd':
                cout<<"enter the double element which you want to push into stack"<<endl;
                cin>>c;
                push(&c,3,&start);
                break;
            case 'c':
                cout<<"enter the char element which you want to push into stack"<<endl;
                cin>>d;
                push(&d,4,&start);
                break;
            case 'b':
                cout<<"enter the bool element which you want to push into stack"<<endl;
                cin>>e;
                push(&e,5,&start);
                break;

            default:
                cout<<"element of datatype entered by you cannot be pushed into stack"<<endl;
                break;
            }
            break;
        case 2:
            pop(&start);
            break;
        case 3:
            display(start);
            break;
        case 0:
            cout<<"exited"<<endl;
            exit;
            break;
        default:
            cout<<"invalid choice entered"<<endl;
            break;
        }
    }while (ch!=0);
}