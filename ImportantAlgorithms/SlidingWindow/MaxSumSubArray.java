// Given an array of positive numbers and a positive number ‘k’,
// find the maximum sum of any contiguous subarray of size ‘k’.
import java.util.ArrayList;
import java.util.Arrays;

// Here we can also use brute force method which needs N*K time complexity to reduce it to N we use Sliding Window.

public class MaxSumSubArray {
    public static int[] maxSumSubArray(int[] array, int k){
        int start=0;
        int n=array.length;
        int maxSum=0;
        int sum=0;
        int resultStart=0;
        int resultEnd=0;
        for(int end=0; end<n; end++){
            sum+=array[end];
            if(end>=(k-1)){
                if (sum>maxSum) {
                    sum=maxSum;
                    resultStart=start;
                    resultEnd=end;
                }
                sum-=array[start];
                start++;
            }
        }
        int [] result = Arrays.copyOfRange(array, resultStart, resultEnd+1);
        return result;
    }
    public static void main(String[] args) {
        int k=3;
        int [] array = {2,1,5,1,3,2};
        int [] result=MaxSumSubArray.maxSumSubArray(array, k);
        System.out.println(Arrays.toString(result));
    }
    public static ArrayList<Integer> maxSumSubArray(ArrayList<Integer> list, int k) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'maxSumSubArray'");
    }
}