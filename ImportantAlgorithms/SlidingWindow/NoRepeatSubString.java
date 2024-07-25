import java.util.ArrayList;
import java.lang.Math;

public class NoRepeatSubString {
    public static int noRepeatSubString(String str){
        int start = 0;
        int maxLen = 0;
        ArrayList<Character> list = new ArrayList<>();
        for (int end = 0; end < str.length(); end++) {
            if (!(list.contains(str.charAt(end)))) {
                list.add(str.charAt(end));
                if (end==(str.length()-1)) {
                    maxLen = Math.max(maxLen, end-start+1);
                }
            }
            else{
                maxLen = Math.max(maxLen, end-1-start+1);
                while (list.contains(str.charAt(end))) {
                    if (list.contains(str.charAt(start))) {
                        list.remove(list.indexOf(str.charAt(start)));
                    }
                    start++;
                }
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String str = "abccdeabcdeagh";
        System.out.println(NoRepeatSubString.noRepeatSubString(str));
    }
}
