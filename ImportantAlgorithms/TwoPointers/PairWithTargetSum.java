// Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.

import java.util.Arrays;

public class PairWithTargetSum {
    public static int[] pairWithTargetSum(int[] array, int targetSum){
        int n=array.length;
        int p1=0;
        int p2=n-1;
        int sum=0;
        while(p1<p2){
            sum=array[p1]+array[p2];
            if(sum<targetSum){
                p1++;
            }
            else if(sum>targetSum){
                p2--;
            }
            else{
                return new int[] {p1,p2};
            }
        }
        return new int[] {-1,-1};
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 6};
        int targetSum = 6;
        int [] output = PairWithTargetSum.pairWithTargetSum(array, targetSum);
        System.out.println(Arrays.toString(output));
    }
}
// Here we can also iterate each and every element and calculate other element
// using binary search, the time complexity will be NlogN. but in above two pointer
// approach we need only N which is better.