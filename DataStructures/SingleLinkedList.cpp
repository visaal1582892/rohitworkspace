#include<iostream>
#include<stdlib.h>
using namespace std;
template <class T>
class Node
{
    public :
    T data;
    Node<T>* next;
};

template <class T>
class SingleLinkedList
{
private:
    Node<T>* head;
public:
    SingleLinkedList();
    void push_front(T x);
    void push_back(T x);
    void insert(int position,T x);
    int size();
    void pop_back();
    void pop_front();
    void del(int position);
    void display();
    bool isempty();
};

template <class T>
bool SingleLinkedList<T>::isempty()
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

template <class T>
void SingleLinkedList<T>::display()
{
    if (head==NULL)
    {
        cout<<"list is empty"<<endl;
    }
    else
    {
        Node<T>* temp=head;
        cout<<"the elements of list are :";
        while (temp!=NULL)
        {
            cout<<" "<<temp->data<<" " ;
            temp=temp->next;
        }
        cout<<endl;
    }    
}

template <class T>
SingleLinkedList<T>::SingleLinkedList()
{
    head=NULL;
}

template <class T>
void SingleLinkedList<T>::push_front(T x)
{
    Node<T>* new_node=new Node<T>();
    new_node->data=x;
    new_node->next=head;
    head=new_node;
}

template <class T>
void SingleLinkedList<T>::push_back(T x)
{
    Node<T>* new_node=new Node<T>();
    new_node->data=x;
    new_node->next=NULL;
    Node<T>* last=head;
    while (last->next!=NULL)
    {
        last=last->next;
    }
    last->next=new_node;
}

template <class T>
void SingleLinkedList<T>::insert(int position,T x)
{
    
    if (position!=0 && position>size()-1 || position<0)
    {
        cout<<"given position is not present in the list"<<endl;
        return;
    }
    Node<T>* ptr=head;
    Node<T>* temp=NULL;
    for (int i = position; i>0; i--)
    {
        temp=ptr;
        ptr=ptr->next;
    }
    if(position!=0)
    {
        Node<T>* new_node=new Node<T>();
        new_node->data=x;
        new_node->next=ptr;
        temp->next=new_node;
    }
    else if(position==0)
    {
        push_front(x);
    }    
}

template <class T>
int SingleLinkedList<T>::size()
{
    Node<T>* temp=head;
    int size=0;
    while (temp!=NULL)
    {
        size=size+1;
        temp=temp->next;
    }
    return size;
}

template <class T>
void SingleLinkedList<T>::del(int position)
{
    if (position>size()-1 || position<0)
    {
        cout<<"given position is not present in the list"<<endl;
        return;
    }
    Node<T>* ptr=head;
    Node<T>* temp=NULL;
    for (int i = position; i>0; i--)
    {
        temp=ptr;
        ptr=ptr->next;
    }
    if(position!=0)
    {
        Node<T>* var=ptr;
        temp->next=ptr->next;
        free(var);
    }
    else{
        pop_front();
    }
}

template <class T>
void SingleLinkedList<T>::pop_front()
{
    if (head==NULL)
    {
        cout<<"List is empty"<<endl;
    }
    else
    {
        Node<T>* temp=head;
        head=head->next;
        free(temp);
    }
}

template <class T>
void SingleLinkedList<T>::pop_back()
{
    if (head==NULL)
    {
        cout<<"List is empty"<<endl;
    }
    else
    {
     Node<T>* last=head;
    while (last->next->next!=NULL)
    {
        last=last->next;
    }
    Node<T>* ptr=last->next;
    last->next=NULL;
    free(ptr);
    }
}
    int main()
    {
        int o;
        string s;
        cout<<"enter the type of numbers  which you want to enter into list :"<<endl;
        cout<<"enter 'double' if you want to enter fractional numbers "<<endl;
        cout<<"enter 'int' if you want to enter whole numbers "<<endl;
        cin>>s;
        if (s=="double")
        {
            SingleLinkedList<double> l1;
            double x;
            int y;   
            cout<<"if you want to push an element from front enter '1'"<<endl;
            cout<<"if you want to pop an element from front enter '2'"<<endl;
            cout<<"if you want to push an element from end enter '3'"<<endl;
            cout<<"if you want to pop an element at end enter '4'"<<endl;
            cout<<"if you want to insert an element at a particular position enter '5'"<<endl;
            cout<<"if you want to delete an element at a particular position enter '6'"<<endl;
            cout<<"if you want to know the size of created list enter '7'"<<endl;
            cout<<"if you want to display the elements of list enter '8'"<<endl;
            cout<<"to end the process enter '0'"<<endl;
            start1 :
            cout<<"enter the number code for required operation"<<endl;
            cin>>o;
            switch (o)
            {
            case 1:
                cout<<"enter the element which you want to push from front"<<endl;
                cin>>x;
                l1.push_front(x);
                cout<<"element successfully pushed into list from front"<<endl;
                goto start1;
            case 2:
                l1.pop_front();
                cout<<"element successfully popped from list from front"<<endl;
                goto start1;
            case 3:
                cout<<"enter the element which you want to push from end"<<endl;
                cin>>x;
                l1.push_back(x);
                cout<<"element successfully pushed into list from end"<<endl;
                goto start1;        
            case 4:
                l1.pop_back();
                cout<<"element successfully pushed into list from front"<<endl;
                goto start1;
            case 5:
                cout<<"enter the element which you want to insert"<<endl;
                cin>>x;
                cout<<"now enter the position where you want to insert it"<<endl;
                cin>>y;
                l1.insert(y,x);
                cout<<"element successfully inserted at given position"<<endl;
                goto start1;
            case 6:
                cout<<"enter the position at which you want to delete an element"<<endl;
                cin>>y;
                l1.del(y);
                cout<<"element at given position is successfully deleted"<<endl;
                goto start1;
            case 7:
                cout<<"the size of created list is : "<<l1.size()<<endl;
                goto start1;
            case 8:
                l1.display();
                goto start1;
            case 0:
                break;                    
            default:
                cout<<"the requested operation is not possible, please try again"<<endl;
                break;
            }
        }

        else if(s=="int")
        {
            SingleLinkedList<int> l1;
            int x,y;
            cout<<"if you want to push an element from front enter '1'"<<endl;
        cout<<"if you want to pop an element from front enter '2'"<<endl;
        cout<<"if you want to push an element from end enter '3'"<<endl;
        cout<<"if you want to pop an element at end enter '4'"<<endl;
        cout<<"if you want to insert an element at a particular position enter '5'"<<endl;
        cout<<"if you want to delete an element at a particular position enter '6'"<<endl;
        cout<<"if you want to know the size of created list enter '7'"<<endl;
        cout<<"if you want to display the elements of list enter '8'"<<endl;
        cout<<"to end the process enter '0'"<<endl;
        start2 :
        cout<<"enter the number code for required operation"<<endl;
        cin>>o;
        switch (o)
        {
        case 1:
            cout<<"enter the element which you want to push from front"<<endl;
            cin>>x;
            l1.push_front(x);
            cout<<"element successfully pushed into list from front"<<endl;
            goto start2;
        case 2:
            l1.pop_front();
            cout<<"element successfully popped from list from front"<<endl;
            goto start2;
        case 3:
            cout<<"enter the element which you want to push from end"<<endl;
            cin>>x;
            l1.push_back(x);
            cout<<"element successfully pushed into list from end"<<endl;
            goto start2;        
        case 4:
            l1.pop_back();
            cout<<"element successfully pushed into list from front"<<endl;
            goto start2;
        case 5:
            cout<<"enter the element which you want to insert"<<endl;
            cin>>x;
            cout<<"now enter the position where you want to insert it"<<endl;
            cin>>y;
            l1.insert(y,x);
            cout<<"element successfully inserted at given position"<<endl;
            goto start2;
        case 6:
            cout<<"enter the position at which you want to delete an element"<<endl;
            cin>>y;
            l1.del(y);
            cout<<"element at given position is successfully deleted"<<endl;
            goto start2;
        case 7:
            cout<<"the size of created list is : "<<l1.size()<<endl;
            goto start2;
        case 8:
            l1.display();
            goto start2;
        case 0:
            break;                    
        default:
            cout<<"the requested operation is not possible, please try again"<<endl;
            break;
        }
        }
        else
        {
            cout<<"given type of numbers cannot be used in the list"<<endl;
        }     
    }

