// Given an array of unsorted numbers, find all unique triplets in it that add up to zero.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class TripletSumToZero {
    public static List<List<Integer>> tripletSumToZero(int[] array){
        List<List<Integer>> output=new ArrayList<>();
        Arrays.sort(array);
        int n=array.length;
        for(int i=0; i<n-2; i++){
            if(array[i]==array[i+1]){
                continue;
            }
            int targetSum=-array[i];
            int p1=i+1;
            int p2=n-1;
            while(p1<p2){
                if(array[p1]+array[p2]>targetSum){
                    p2--;
                }
                else if(array[p1]+array[p2]<targetSum){
                    p1++;
                }
                else{
                    output.add(Arrays.asList(array[i],array[p1],array[p2]));
                    p1++;
                    p2--;
                    while(p1<p2 && array[p1]==array[p1-1]){
                        p1++;
                    }
                    while(p1<p2 && array[p2]==array[p2+1]){
                        p2--;
                    }
                }
            }
        }
        return output;
    }
    public static void main(String[] args) {
        int array[] = {-3, 0, 1, 2, -1, 1, -2};
        List<List<Integer>> outList = TripletSumToZero.tripletSumToZero(array);
        for (List<Integer> list : outList) {
            System.out.println(list);
        }
    }
}

// Here time complexity is NLogN + N^2 hence O(N^2)
