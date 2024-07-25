import java.lang.Math;
public class SquaringSortedArray{
    public static int[] squaringSortedArray(int[] array){
        int p1 = 0;
        int p2 = array.length-1;
        int n = array.length;
        int[] squaredArray = new int[n];
        for (int i = n-1; i >= 0; i--) {
            if (Math.pow(array[p1], 2)>Math.pow(array[p2], 2)) {
                squaredArray[i] = (int)Math.pow(array[p1], 2);
                p1++;
            }
            else{
                squaredArray[i] = (int)Math.pow(array[p2], 2);
                p2--;
            }
        }
        return squaredArray;
    }
    public static void main(String[] args) {
        int[] array = {-3, -1, 0, 1, 2};
        int[] squaredArray = SquaringSortedArray.squaringSortedArray(array);
        for (int i : squaredArray) {
            System.out.println(i);
        }
    }
}