// Given a string, find the length of the longest substring which has no repeating characters.

import java.util.HashMap;

public class NoRepeatSubString {
    public static int noRepeatSubString(String str){
        int start=0;
        int n=str.length();
        int maxLen=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int end=0; end<n; end++){
            char ec=str.charAt(end);
            if(map.containsKey(ec)){
                start=Integer.max(start,map.get(ec)+1);
            }
            map.put(ec,end);
            maxLen=Integer.max(maxLen,end-start+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String str = "abccde";
        System.out.println(NoRepeatSubString.noRepeatSubString(str));
    }
}
