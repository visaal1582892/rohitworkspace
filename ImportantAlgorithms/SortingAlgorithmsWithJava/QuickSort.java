import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = start;
            int i = pivot + 1;
            int j = end;
            while (i <= j ) {
                if (array[i] > array[pivot] && array[j] <= array[pivot]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                    i++;
                    j--;
                }
                else{
                    while (array[i]<=array[pivot] && i<=end) {
                        i++;
                        if(i>j){
                            break;
                        }
                    }
                    if(i>j){
                        break;
                    }
                    while (array[j]>array[pivot] && j>=start) {
                        j--;
                        if(i>j){
                            break;
                        }
                    }
                    if(i>j){
                        break;
                    }
                }
                System.out.println(i+" "+j);
            }
            if (i > j) {
                int temp = array[j];
                array[j] = array[pivot];
                array[pivot] = temp;
                pivot = j;
            }
            System.out.println(Arrays.toString(array));
            quickSort(array, start, pivot-1);
            quickSort(array, pivot+1, end);
        }
    }

    public static void main(String[] args) {
        int array[] = { 5, 3, 7, 3, 3, 4 };
        System.out.println("Before Sorting : " + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("After Sorting : " + Arrays.toString(array));
    }
}
