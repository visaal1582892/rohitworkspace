// Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.

import java.util.Arrays;

public class TripletsWithSumSmallerThanTarget {
    public static int tripletsWithSumSmallerThanTarget(int[] array, int target){
        Arrays.sort(array);
        int triplets=0;
        int n=array.length;
        for(int i=0; i<n-2; i++){
            if(i>0 && array[i]==array[i-1]){
                continue;
            }
            int p1=i+1;
            int p2=n-1;
            int targetTwoSum=target-array[i];
            while(p1<p2){
                int twoSum=array[p1]+array[p2];
                if(twoSum<targetTwoSum){
                    triplets+=(p2-p1);
                    p1++;
                }
                else{
                    p2--;
                }
            }
        }
        return triplets;
    }
    public static void main(String[] args) {
        int[] array = {-1, 0, 2, 3};
        int target = 3;
        System.out.println(TripletsWithSumSmallerThanTarget.tripletsWithSumSmallerThanTarget(array, target));
    }
}
