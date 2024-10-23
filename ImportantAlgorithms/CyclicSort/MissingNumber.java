
import java.util.Arrays;

// We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’. Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.

public class MissingNumber{
    public static int missingNumber(int [] array){
        int n=array.length;
        int i=0;
        while(i<n){
            if(array[i]==i || array[i]==n){
                i++;
            }
            else{
                int j=array[i];
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        for(int j=0; j<n; j++){
            if(array[j]!=j){
                return j;
            }
        }
        return 0;
    }
    public static void main(String [] args){
        int [] array={4,0,3,1};
        int output=MissingNumber.missingNumber(array);
        System.out.println(output);
    }
}