package rohitworkspace.JavaProjects;

import java.util.Scanner;

class MergeSort
{
    public static void merge(int [] a,int l,int mid,int u) {
        int arr1[]=new int[mid-l+1];
        int arr2[]=new int[u-mid];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i]=a[l+i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i]=a[mid+i+1];
        }
        int i=0;
        int j=0;
        int k=l;
        while ((i<arr1.length)&&j<(arr2.length)) {
            if (arr1[i]<=arr2[j]) {
                a[k]=arr1[i];
                i++;
            }
            else{
                a[k]=arr2[j];
                j++;
            }
            k++;
        }
        while (i<arr1.length) {
            a[k]=arr1[i];
            i++;
            k++;
        }
        while (j<arr2.length) {
            a[k]=arr2[j];
            j++;
            k++;
        }
        }
    
    public static void mergesort(int [] a,int l,int u) {
        if (l>=u) {
            return;
        }
        int mid=(l+u)/2;
        mergesort(a,l,mid);
        mergesort(a,mid+1,u);
        merge(a,l,mid,u);
    }
    public static void main(String[] args) {
        System.out.println("enter number of elements which you want to give");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        System.out.println("now enter the numbers one by one");
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        mergesort(a,0,(n-1));
        System.out.println("The sorted elements are : ");
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]+" ");
        }    
        sc.close();
    }
}
