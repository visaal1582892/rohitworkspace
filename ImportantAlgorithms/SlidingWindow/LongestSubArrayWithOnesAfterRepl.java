import java.util.HashMap;

public class LongestSubArrayWithOnesAfterRepl {
    public static int longestSubArrayWithOnesAfterRepl(int[] array, int k){
        int start=0;
        int maxLen=0;
        int n=array.length;
        int maxIntCount=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int end=0; end<n; end++){
            int ei=array[end];
            map.put(ei,map.getOrDefault(ei,0)+1);
            maxIntCount=Integer.max(maxIntCount,map.get(ei));
            if(end-start+1-maxIntCount>k){
                int si=array[start];
                map.put(si,map.get(si)-1);
                start++;
            }
            maxLen=Integer.max(maxLen,end-start+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] array = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        int k = 2;
        System.out.println(LongestSubArrayWithOnesAfterRepl.longestSubArrayWithOnesAfterRepl(array, k));
    }
}