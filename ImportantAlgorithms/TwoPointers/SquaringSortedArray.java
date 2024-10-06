// Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.

import java.lang.Math;
import java.util.Arrays;
public class SquaringSortedArray{
    public static int[] squaringSortedArray(int[] array){
        int n=array.length;
        int p1=0;
        int p2=n-1;
        int [] output=new int[n];
        for(int p3=n-1; p3>=0; p3--){
            double v1=Math.pow((double)array[p1],2.0);
            double v2=Math.pow((double)array[p2],2.0);
            if(v1>v2){
                output[p3]=(int)v1;
                p1++;
            }
            else{
                output[p3]=(int)v2;
                p2--;
            }
        }
        return output;
    }
    public static void main(String[] args) {
        int[] array = {-2, -1, 0, 2, 3};
        int[] output = SquaringSortedArray.squaringSortedArray(array);
        System.out.println(Arrays.toString(output));
    }
}