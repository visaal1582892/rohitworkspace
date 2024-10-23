// We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.

import java.util.List;
import java.util.ArrayList;
public class AllMissingNumbers{
    public static List<Integer> allMissingNumbers(int [] array){
        int n=array.length;
        int i=0;
        while(i<n){
            if(array[i]==i+1 || array[array[i]-1]==array[i]){
                i++;
            }
            else{
                int j=array[i]-1;
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int j=0; j<n; j++){
            if(array[j]!=j+1){
                list.add(j+1);
            }
        }
        return list;
    }
    public static void main(String [] args){
        int [] array={2,3,2,1};
        List<Integer> list=AllMissingNumbers.allMissingNumbers(array);
        System.out.println(list);
    }
}