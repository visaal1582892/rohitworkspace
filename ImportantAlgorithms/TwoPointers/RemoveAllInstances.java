public class RemoveAllInstances {
    public static int removeAllInstances(int[] array, int key){
        int toRepl = 0;
        for(int iter=0; iter<array.length; iter++){
            if (array[iter]!=key) {
                array[toRepl] = array[iter];
                toRepl++;
            }
        }
        return toRepl;
    }
    public static void main(String[] args) {
        int[] array = {3, 2, 3, 6, 3, 10, 9, 3};
        int key = 3;
        System.out.println(RemoveAllInstances.removeAllInstances(array, key));
    }
}
