// We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’. The array has only one duplicate but it can be repeated multiple times. Find that duplicate number without using any extra space. You are, however, allowed to modify the input array.

public class DuplicateNumber{
    public static int duplicateNumber(int [] array){
        int n=array.length;
        int i=0;
        while(i<n){
            if(array[i]!=i+1){
                int j=array[i]-1;
                if(array[j]==array[i]){
                    return array[i];
                }
                else{
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
            else{
                i++;
            }
        }
        return 0;
    }
    public static void main(String [] args){
        int [] array={2,4,1,4,4};
        int output=DuplicateNumber.duplicateNumber(array);
        System.out.println(output);
    }
}