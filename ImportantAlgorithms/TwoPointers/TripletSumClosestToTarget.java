package ImportantAlgorithms.TwoPointers;
/**
 * TripletSumClosestToTarget
 */
import java.util.Arrays;
public class TripletSumClosestToTarget {
    public static int tripletSumClosestToTarget(int[] array, int target){
        int n = array.length;
        Arrays.sort(array);
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i>0 && array[i] == array[i-1]) {
                continue;
            }
            int pairSum = target-array[i];
            int left = i+1;
            int right = n-1;
            while(left<right){
                int currentSum = array[left]+array[right];
                if (currentSum == pairSum) {
                    return target;
                }
                else if (currentSum < pairSum) {
                    if (currentSum+array[i] > max) {
                        max = currentSum+array[i];
                    }
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int array[] = {1, 0, 1, 1};
        int target = 100;
        System.out.println(TripletSumClosestToTarget.tripletSumClosestToTarget(array, target));
    }
}