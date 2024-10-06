//  Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet with the smallest sum.

import java.util.Arrays;
import java.lang.Math;
public class TripletSumClosestToTarget {
    public static int tripletSumClosestToTarget(int[] array, int target){
        Arrays.sort(array);
        int n=array.length;
        int minDiff=Integer.MAX_VALUE;
        for(int i=0; i<n-2; i++){
            if (i!=0 && array[i-1]==array[i]) {
                continue;
            }
            int targetSum=target-array[i];
            int p1=i+1;
            int p2=n-1;
            int diff=0;
            while(p1<p2){
                diff=Math.abs(targetSum-(array[p1]+array[p2]));
                if(diff<minDiff){
                    minDiff=diff;
                }
                if(array[p1]+array[p2]<targetSum){
                    p1++;
                }
                else if(array[p1]+array[p2]>targetSum){
                    p2--;
                }
                else{
                    return target;
                }
            }
        }
        return Math.abs(target-minDiff);
    }
    public static void main(String[] args) {
        int array[] = {-3, -1, 1, 2};
        int target = 1;
        System.out.println(TripletSumClosestToTarget.tripletSumClosestToTarget(array, target));
    }
}