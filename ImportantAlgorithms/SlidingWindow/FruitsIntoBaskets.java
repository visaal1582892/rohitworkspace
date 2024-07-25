import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class FruitsIntoBaskets {
    public static int fruitsIntoBaskets(char[] array){
        int start = 0;
        int maxFruits = 0;
        ArrayList<Character> treeList = new ArrayList<>();
        for (int end = 0; end < array.length; end++) {
            if (!(treeList.contains(array[end]))) {
                treeList.add(array[end]);
            }
            if (treeList.size()>2) {
                maxFruits = Math.max(maxFruits, end-1-start+1);
                while(treeList.size()>2){
                    char[] subArray = Arrays.copyOfRange(array, start+1, end);
                    char valueAtStart = array[start];
                    if (!(Arrays.asList(subArray).contains(valueAtStart))) {
                        treeList.remove(treeList.indexOf(array[start]));
                    }
                    start++;
                }
            }
            if (treeList.size()==2 && end==array.length-1) {
                maxFruits = Math.max(maxFruits, end-start+1);
            }
        }
        return maxFruits;
    }
    public static void main(String[] args) {
        char[] array = {'A', 'B', 'C', 'B', 'B', 'C'};
        System.out.println(fruitsIntoBaskets(array));
    }
}
