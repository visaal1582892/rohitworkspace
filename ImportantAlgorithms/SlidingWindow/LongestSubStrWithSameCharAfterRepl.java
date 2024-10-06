import java.util.HashMap;

public class LongestSubStrWithSameCharAfterRepl {
    public static int longestSubStrWithSameCharAfterRepl(String str, int k){
        int start=0;
        int maxLen=0;
        int n=str.length();
        int maxCharCount=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int end=0; end<n; end++){
            char ec=str.charAt(end);
            map.put(ec,map.getOrDefault(ec,0)+1);
            maxCharCount=Integer.max(map.get(ec),maxCharCount);
            if(end-start+1-maxCharCount>k){
                char sc=str.charAt(start);
                map.put(sc,map.get(sc)-1);
                start++;
            }
            maxLen=Integer.max(maxLen,end-start+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String str = "abccde";
        int k = 1;
        System.out.println(LongestSubStrWithSameCharAfterRepl.longestSubStrWithSameCharAfterRepl(str, k));
    }
}
