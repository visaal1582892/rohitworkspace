public class DutchNationalFlag {
    public static int[] dutchNationalFlag(int[] array){
        int n = array.length;
        int low = 0;
        int high = n-1;
        for (int i = 0; i < n; i++) {
            if (array[i]==0) {
                array[i] = array[low];
                array[low] = 0;
                low++;
            }
            else if (array[i] == 2) {
                array[i] = array[high];
                array[high] = 2;
                high--;
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int array[] = {2, 2, 0, 1, 2, 0};
        int[] outArray = DutchNationalFlag.dutchNationalFlag(array);
        for (int i : outArray) {
            System.out.println(i);
        }
    }
}
