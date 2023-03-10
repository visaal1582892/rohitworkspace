#include<iostream>
using namespace std;
class Node
{
    public:
    int data;
    Node* lc;
    Node* rc;
};
Node *rightRotate(Node* root)
{
    Node* y=root->lc->rc;
    root->lc->rc=root;
    root=root->lc;
    root->rc->lc=y;
    return root;
}
Node *leftRotate(Node* root)
{
    Node* x=root->rc->lc;
    root->rc->lc=root;
    root=root->rc;
    root->lc->rc=x;
    return root;
}
int height(Node* root)
{
    if (root==NULL)
    {
        return -1;
    }
    else
    {
        int hl=height(root->lc);
        int hr=height(root->rc);
        if (hl>hr)
        {
            return hl+1;
        }
        else
        {
            return hr+1;
        }
    }
}
int getBalance(Node* root)
{
    int b=height(root->lc)-height(root->rc);
    return b;
}
Node *insert(Node* root,int item)
{
    if (root==NULL)
    {
        Node *newnode=new Node();
        newnode->data=item;
        newnode->lc=NULL;
        newnode->rc=NULL;
        root=newnode;
        return root;
    }
    if (item>root->data)
    {
        root->rc=insert(root->rc,item);
    }
    if (item<root->data)
    {
        root->lc=insert(root->lc,item);
    }
    int b=getBalance(root);
    if (b>1&&item<root->lc->data)
    {
        root=rightRotate(root);
    }
    if (b<-1&&item>root->rc->data)
    {
        root=leftRotate(root);
    }
    if (b>1&&item>root->lc->data)
    {
        root=leftRotate(root->lc);
        root=rightRotate(root);
    }
    if (b<-1&&item<root->rc->data)
    {
        root=rightRotate(root->rc);
        root=leftRotate(root);
    }
    return root;
}
void preorder(Node *root)
{
    if (root==NULL)
    {
        return;
    }
    cout<<root->data;
    preorder(root->lc);
    preorder(root->rc);
}
int main(int argc, char const *argv[])
{
    Node* root=NULL;
    root=insert(root,5);
    root=insert(root,6);
    root=insert(root,7);
    root=insert(root,8);
    preorder(root);
    return 0;
}
