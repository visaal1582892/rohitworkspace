// Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.



public class SmallestSubArrayWithSum{
    public static int smallestSubArrayWithSum(int [] array, int s){
        int start=0;
        int n=array.length;
        int sum=0;
        int minLen=Integer.MAX_VALUE;
        for(int end=0; end<n; end++){
            sum+=array[end];
            while(sum>=s){
                minLen=Integer.min(minLen, end-start+1);
                sum-=array[start];
                start++;
            }
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
    public static void main(String [] args){
        int [] array={3, 4, 1, 1, 6};
        int s=8;
        System.out.println(SmallestSubArrayWithSum.smallestSubArrayWithSum(array, s));
    }
}