import java.util.Arrays;
public class BubbleSort{
    public static void bubbleSort(int [] array){
        int bubble = 0;
        int n = array.length;
        for(int i=n-1; i>0; i--){
            for (int j = 1; j <= i; j++) {
                if (array[j]<array[bubble]) {
                    int temp = array[j];
                    array[j] = array[bubble];
                    array[bubble] = temp;
                }
                bubble = j;
            }
            bubble = 0;
        }
    }
    public static void main(String [] args){
        int [] array = {5,2,7,3,4,4};
        System.out.println("Before Sorting : "+Arrays.toString(array));
        bubbleSort(array);
        System.out.println("After Sorting : "+Arrays.toString(array));
    }
}