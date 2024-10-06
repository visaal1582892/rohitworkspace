import java.util.Arrays;

public class MergeSort {
    public static void merge(int[] array, int start, int mid, int end){
        int []array1 = new int[mid-start+1];
        int []array2 = new int[end-mid];
        for(int i=0; i<mid-start+1; i++){
            array1[i] = array[start+i];
        }
        for(int i=0; i<end-mid; i++){
            array2[i] = array[mid+1+i];
        }
        int i = 0;
        int j = 0;
        int k = start;
        while(i<mid-start+1 && j<end-mid){
            if(array1[i] < array2[j]){
                array[k] = array1[i];
                k++;
                i++;
            }
            else{
                array[k] = array2[j];
                k++;
                j++;
            }
        }
        while(j<end-mid){
            array[k] = array2[j];
            j++;
            k++;
        }
        while(i<mid-start+1){
            array[k] = array1[i];
            i++;
            k++;
        }
    }
    public static void mergeSort(int[] array,int start,int end){
        if (start != end) {
            int mid = (start+end)/2;
            mergeSort(array, start, mid);
            mergeSort(array, mid+1, end);
            merge(array, start, mid, end);
        }
    }
    public static void main(String [] args){
        int array[] = {5,2,7,3,4,4};
        System.out.println("Before Sorting : "+Arrays.toString(array));
        mergeSort(array, 0, array.length-1);
        System.out.println("After Sorting : "+Arrays.toString(array));
    }
}
