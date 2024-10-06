import java.util.Arrays;
public class DutchNationalFlag {
    public static int[] dutchNationalFlag(int[] array){
        int n=array.length;
        int low=0;
        int high=n-1;
        for(int i=0; i<=high;){
            if(array[i]==0){
                int temp=array[i];
                array[i]=array[low];
                array[low]=temp;
                low++;
                i++;
            }
            else if(array[i]==1){
                i++;
            }
            else{
                int temp=array[i];
                array[i]=array[high];
                array[high]=temp;
                high--;
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int array[] = {2, 2, 0, 1, 2, 0};
        int[] outArray = DutchNationalFlag.dutchNationalFlag(array);
        System.out.println(Arrays.toString(outArray));
    }
}
