import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class TripletSumToZero {
    public static List<List<Integer>> tripletSumToZero(int[] array){
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(array);
        int n = array.length;
        for(int i=0; i<n; i++){
            if (i>0 && array[i-1] == array[i]) {
                continue;
            }
            int pairSum = -array[i];
            int left = i+1;
            int right = n-1;
            while(left<right){
                if (left!=i && right!=i) {
                    if (array[left]+array[right] == pairSum) {
                        triplets.add(Arrays.asList(array[i], array[left], array[right]));
                        left++;
                        right--;
                        while (left<right && array[left] == array[left-1]) {
                            left++;
                        }
                        while (left<right && array[right+1] == array[right]) {
                            right--;
                        }
                    }
                    else if (array[left]+array[right] > pairSum) {
                        right--;
                    }
                    else{
                        left++;
                    }
                }
            }
        }
        return triplets;
    }
    public static void main(String[] args) {
        int array[] = {-3, 0, 1, 2, -1, 1, -2};
        List<List<Integer>> outList = TripletSumToZero.tripletSumToZero(array);
        for (List<Integer> list : outList) {
            System.out.println(list);
        }
    }
}

// Here time complexity is NLogN * N^2 hence O(N^2)
