// Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the new length of the array.

public class RemoveDuplicates {
    public static int removeDuplicates(int[] array){
        int n=array.length;
        int p1=1;
        for(int p2=1; p2<n; p2++){
            if(array[p1-1]!=array[p2]){
                array[p1]=array[p2];
                p1++;
            }
        }
        return p1;
    }
    public static void main(String[] args) {
        int[] array = {2, 2, 3, 3, 6, 9, 9};
        System.out.println(RemoveDuplicates.removeDuplicates(array));
    }
}
