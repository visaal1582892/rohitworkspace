import java.util.Arrays;

public class TripletsWithSumSmallerThanTarget {
    public static int tripletsWithSumSmallerThanTarget(int[] array, int target){
        int n = array.length;
        int tripletCount = 0;
        Arrays.sort(array);
        for (int i = 0; i < n; i++) {
            if (i>0 && array[i-1] == array[i]) {
                continue;
            }
            int left = i+1;
            int right = n-1;
            int pairSum = target-array[i];
            while (left < right) {
                int currentSum = array[left]+array[right];
                if (currentSum < pairSum) {
                    tripletCount+=(right-left);
                    left++;
                }
                else{
                    right--;
                }
                while (array[left]==array[left-1]) {
                    left++;
                }
                while (right<n-1 && array[right] == array[right+1]) {
                    right--;
                }
            }
        }
        return tripletCount;
    }
    public static void main(String[] args) {
        int[] array = {-1, 4, 2, 1, 3};
        int target = 5;
        System.out.println(TripletsWithSumSmallerThanTarget.tripletsWithSumSmallerThanTarget(array, target));
    }
}
