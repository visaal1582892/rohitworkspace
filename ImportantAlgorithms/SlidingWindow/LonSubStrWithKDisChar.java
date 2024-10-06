// Given a string, find the length of the longest substring in it with no more than K distinct characters.

import java.util.HashMap;

public class LonSubStrWithKDisChar {
    public static int lonSubStrLen(String str, int k){
        HashMap<Character,Integer> map=new HashMap<>();
        int start=0;
        int n=str.length();
        int maxLen=0;
        for(int end=0; end<n; end++){
            char ec=str.charAt(end);
            map.put(ec, map.getOrDefault(ec, 0)+1);
            if(map.size()<=k){
                maxLen=Integer.max(maxLen, end-start+1);
            }
            else{
                char sc=str.charAt(start);
                map.put(sc,map.get(sc)-1);
                map.remove(sc,0);
                start++;
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String str = "babbcccc";
        int k = 2;
        System.out.println(lonSubStrLen(str, k));
    }
}
