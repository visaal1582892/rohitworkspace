public class RemoveDuplicates {
    public static int removeDuplicates(int[] array){
        int toRepl = 1;
        for(int it=1; it<array.length; it++){
            if (array[toRepl-1]!=array[it]) {
                array[toRepl] = array[it];
                toRepl++;
            }
        }
        return toRepl;
    }
    public static void main(String[] args) {
        int[] array = {2, 2, 2, 11};
        System.out.println(RemoveDuplicates.removeDuplicates(array));
    }
}
