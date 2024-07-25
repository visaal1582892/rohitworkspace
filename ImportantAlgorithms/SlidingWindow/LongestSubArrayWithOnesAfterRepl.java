import java.util.HashMap;

public class LongestSubArrayWithOnesAfterRepl {
    public static int longestSubArrayWithOnesAfterRepl(int[] array, int k){
        int start = 0;
        int maxLen = 0;
        int maxRep = 0;
        int[] countArray = {0,0};
        for(int end=0; end<array.length; end++){
            int endValue = array[end];
            countArray[endValue]+=1;
            maxRep = Math.max(maxRep, countArray[endValue]);
            if (end-start+1-maxRep>k) {
                int startValue = array[start];
                countArray[startValue]-=1;
                start++;
            }
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] array = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int k = 3;
        System.out.println(LongestSubArrayWithOnesAfterRepl.longestSubArrayWithOnesAfterRepl(array, k));
    }
}