import java.util.ArrayList;
import java.util.HashMap;

public class LongestSubStrWithSameCharAfterRepl {
    public static int longestSubStrWithSameCharAfterRepl(String str, int k){
        int start = 0;
        int maxLen = 0;
        int moreRepeatingValue = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char endChar = str.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0)+1);
            moreRepeatingValue = Math.max(moreRepeatingValue, map.get(endChar));
            if (end-start+1-moreRepeatingValue>k) {
                char startChar = str.charAt(start);
                map.put(startChar, map.get(startChar)-1);
                start++;
            }
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String str = "abccde";
        int k = 1;
        System.out.println(LongestSubStrWithSameCharAfterRepl.longestSubStrWithSameCharAfterRepl(str, k));
    }
}
