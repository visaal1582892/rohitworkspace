import java.util.ArrayList;
import java.lang.Math;

public class LonSubStrWithKDisChar {
    public static int lonSubStrLen(String str, int k){
        int start = 0;
        int maxLength = 0;
        ArrayList<Character> list = new ArrayList<>();
        for (int end = 0; end < str.length(); end++) {
            if (!(list.contains(str.charAt(end)))) {
                list.add(str.charAt(end));
            }
            if (list.size()>k) {
                maxLength = Math.max(maxLength, end-1-start+1);
                while (list.size()!=k) {
                    String subStr = str.substring(start+1, end+1);
                    if (!(subStr.contains(str.substring(start, start+1)))) {
                        list.remove(list.indexOf(str.charAt(start)));
                    }
                    start++;
                }
            }
            else if (list.size()==k && end==str.length()-1) {
                maxLength = Math.max(maxLength, end-start+1);
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String str = "abaaacdabacdbaaaaa";
        int k = 3;
        System.out.println(lonSubStrLen(str, k));
    }
}
