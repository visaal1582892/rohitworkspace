// We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. The array has some duplicates, find all the duplicate numbers without using any extra space.

import java.util.List;
import java.util.ArrayList;

public class AllDuplicateNumbers{
    public static List<Integer> allDuplicateNumbers(int [] array){
        int n=array.length;
        int i=0;
        List<Integer> list= new ArrayList<>();
        while(i<n){
            if(array[i]!=i+1){
                int j=array[i]-1;
                if(array[j]==array[i]){
                    list.add(array[i]);
                    i++;
                }
                else{
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
            else{
                i++;
            }
        }
        return list;
    }
    public static void main(String [] args){
        int [] array={5,4,7,2,3,5,3};
        List<Integer> list=AllDuplicateNumbers.allDuplicateNumbers(array);
        System.out.println(list);
    }
}