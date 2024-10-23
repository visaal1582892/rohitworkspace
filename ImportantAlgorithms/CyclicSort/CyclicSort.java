// We are given an array containing ‘n’ objects. Each object, when created, was assigned a unique number from 1 to ‘n’ based on their creation sequence. This means that the object with sequence number ‘3’ was created just before the object with sequence number ‘4’. Write a function to sort the objects in-place on their creation sequence number in O(n) and without any extra space. For simplicity, let’s assume we are passed an integer array containing only the sequence numbers, though each number is actually an object.

import java.util.Arrays;

public class CyclicSort{
    public static void cyclicSort(int [] array){
        int n=array.length;
        int i=0;
        while(i<n){
            if(array[i]!=i+1){
                int j=array[i]-1;
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
            else{
                i++;
            }
        }
    }
    public static void main(String [] args){
        int [] array={3,1,5,4,2};
        CyclicSort.cyclicSort(array);
        System.out.println(Arrays.toString(array));
    }
}