#include<iostream>
using namespace std;
class Node
{
    public :
    int data;
    Node* next;
};
class SingleLinkedList
{
private:
    Node* head;
public:
    SingleLinkedList();
    void push_front(int x);
    void push_back(int x);
    void insert(int position,int x);
    int size();
    void pop_back();
    void pop_front();
    void del(int position);
    void display();
    bool isempty();
};
bool SingleLinkedList::isempty()
{
    if (head==NULL)
    {
        return true;
    }
    else
    {
        return false;
    }
}
void SingleLinkedList::display()
{
    if (head==NULL)
    {
        cout<<"list is empty"<<endl;
    }
    else
    {
        Node* temp=head;
        cout<<"the elements of list are :";
        while (temp!=NULL)
        {
            cout<<" "<<temp->data<<" " ;
            temp=temp->next;
        }
    }    
}
SingleLinkedList::SingleLinkedList(/* args */)
{
    Node* head=NULL;
}
void SingleLinkedList::push_front(int x)
{
    Node* new_node=new Node();
    new_node->data=x;
    new_node->next=head;
    head=new_node;
}
void SingleLinkedList::push_back(int x)
{
    Node* new_node=new Node();
    new_node->data=x;
    new_node->next=NULL;
    Node* last=head;
    while (last->next!=NULL)
    {
        last=last->next;
    }
    last->next=new_node;
}
void SingleLinkedList::insert(int position,int x)
{
    if (position==size())
    {
        push_back(x);
        return;
    }
    
    if (position>size()-1 || position<0)
    {
        cout<<"given position is not present in the list"<<endl;
        return;
    }
    Node* ptr=head;
    Node* temp=NULL;
    for (int i = position; i>0; i--)
    {
        temp=ptr;
        ptr=ptr->next;
    }
    if(position!=0)
    {
        Node* new_node=new Node();
        new_node->data=x;
        new_node->next=ptr;
        temp->next=new_node;
    }
    else
    {
        push_front(x);
    }    
}
int SingleLinkedList::size()
{
    Node* temp=head;
    int size=0;
    while (temp!=NULL)
    {
        size=size+1;
        temp=temp->next;
    }
    return size;
}
void SingleLinkedList::del(int position)
{
    if (position>size()-1 || position<0)
    {
        cout<<"given position is not present in the list"<<endl;
        return;
    }
    Node* ptr=head;
    Node* temp=NULL;
    for (int i = position; i>0; i--)
    {
        temp=ptr;
        ptr=ptr->next;
    }
    if(position!=0)
    {
        Node* var=ptr;
        temp->next=ptr->next;
        free(var);
    }
    else{
        pop_front();
    }
}
void SingleLinkedList::pop_front()
{
    if (head==NULL)
    {
        cout<<"List is empty"<<endl;
    }
    else
    {
        Node* temp=head;
        head=head->next;
        free(temp);
    }
}
void SingleLinkedList::pop_back()
{
    if (head==NULL)
    {
        cout<<"List is empty"<<endl;
    }
    else
    {
     Node* last=head;
    while (last->next->next!=NULL)
    {
        last=last->next;
    }
    Node* ptr=last->next;
    last->next=NULL;
    free(ptr);
    }
}
    int main()
    {
        SingleLinkedList l1;
        l1.push_front(5);
        l1.push_front(6);
        l1.push_back(8);
        l1.del(0);
        l1.insert(2,3);
        l1.display();
    }

