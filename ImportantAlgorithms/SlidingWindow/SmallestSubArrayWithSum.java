import java.util.Arrays;

public class SmallestSubArrayWithSum {
    public static int[] smallestSubArrayWithSum(int[] array, int k){
        int start = 0;
        int sum = array[0];
        int end = 0;
        int subArray[] = Arrays.copyOf(array, array.length);
        int minSubArrayLength = array.length;
        while (end<array.length) {
            if (sum >= k) {
                if ((end-start+1)<=minSubArrayLength) {
                    subArray = Arrays.copyOfRange(array, start, end+1);
                    minSubArrayLength = subArray.length;
                }
                sum -= array[start];
                start++;
            }
            else{
                end++;
                if (end<array.length) {
                    sum += array[end];
                }
            }
        }
        return subArray;
    }
    public static void main(String[] args){
        int array[] = {3, 4, 1, 1, 6};
        int k = 8;
        if (Arrays.stream(array).sum()<k) {
            System.err.println("No Such Sub Array Exists");
        }
        else{
            int smallestSubArray[] = SmallestSubArrayWithSum.smallestSubArrayWithSum(array, k);
            for(int num : smallestSubArray){
                System.err.print(num+" ");
            }
        }
    }
}

// better solution is :

// Here we can ue a for loop to continuosly increment end
// and if sum>=7 then we use a while loop to increment start until sum remains
// >= 7 and size is as small as possible. time complexity is N.