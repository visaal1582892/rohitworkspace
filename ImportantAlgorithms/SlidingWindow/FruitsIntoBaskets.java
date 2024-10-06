// Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
// You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
// Write a function to return the maximum number of fruits in both the baskets.

import java.util.HashMap;

public class FruitsIntoBaskets {
    public static int fruitsIntoBaskets(char[] array){
        HashMap<Character,Integer> map = new HashMap<>();
        int n=array.length;
        int start=0;
        int maxLen=0;
        for(int end=0; end<n; end++){
            char ec=array[end];
            map.put(ec,map.getOrDefault(ec, 0)+1);
            if(map.size()<=2){
                maxLen=Integer.max(maxLen, end-start+1);
            }
            else{
                char sc=array[start];
                map.put(sc,map.get(sc)-1);
                map.remove(sc, 0);
                start++;
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        char[] array = {'A', 'B', 'C', 'A', 'C'};
        System.out.println(fruitsIntoBaskets(array));
    }
}
