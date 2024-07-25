public class PairWithTargetSum {
    public static int[] pairWithTargetSum(int[] array, int targetSum){
        int start = 0;
        int end = array.length-1;
        while (start!=end && array[start]+array[end]!=targetSum) {
            if (array[start]+array[end]>targetSum) {
                end--;
            }
            else{
                start++;
            }
        }
        if (array[start]+array[end]==targetSum) {
            return new int[] {start, end};
        }
        else{
            return new int[] {-1, -1};
        }
    }
    public static void main(String[] args) {
        int[] array = {2, 5, 9, 11};
        int targetSum = 11;
        int [] output = PairWithTargetSum.pairWithTargetSum(array, targetSum);
        for(int i : output){
            System.out.print(i+" ");
        }
    }
}

// Here better solution is we can write a condition in while loop as start < end
// then code length can be minimized.
// Here we can also iterate each and every element and calculate other element
// using binary search, the time complexity will be NlogN. but in above two pointer
// approach we need only N which is better.