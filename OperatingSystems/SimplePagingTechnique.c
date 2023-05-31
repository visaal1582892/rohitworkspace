#include <stdio.h>
#include <math.h>
int main(int argc, char const *argv[])
{
    int np,nf,las,pas,ps,lab,pab,la,pa,pageno,pageoffset;
    printf("\nenter the total size of logical address space : ");
    scanf("%d",&las);
    printf("\nenter the total size of phisical address space : ");
    scanf("%d",&pas);
    printf("\nenter page size : ");
    scanf("%d",&ps);
    lab=(int)log2();
    printf("\nnumber of bits required to store logical address is : %d",lab);
    // pab=log2(pas);
    // printf("\nnumber of bits required to store phisical address is : %lf",pab);
    np=las/ps;
    printf("\ntotal number of pages : %d",np);
    nf=pas/ps;
    printf("\ntotal number of frames : %d",nf);
    int pte[np];
    printf("\nnow enter the page table entries for: ");
    for (int i = 0; i < np; i++)
    {
        printf("\npage%d ",i);
        scanf("%d",&pte[i]);
    }
    printf("\nnow enter the logical address : ");
    scanf("%d",&la);
    pageno=la/ps;
    pageoffset=la%ps;
    pa=ps*pte[pageno]+pageoffset;
    printf("\nthe corresponding phisical address is : %d",pa);
    return 0;
}
