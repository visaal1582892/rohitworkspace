import java.util.ArrayList;
import java.util.Arrays;

// Here we can also use brute force method which needs N*K time complexity too reduce it to N we use Sliding Window.

public class MaxSumSubArray {
    public static ArrayList<Integer> maxSumSubArray(ArrayList<Integer> list, int k){
        int n = list.size();
        int max = 0;
        ArrayList<Integer> subArray = new ArrayList<>(k);
        int start = 0;
        int sum = 0;
        for(int end=0; end<n; end++){
            sum += list.get(end);
            if (end >= k-1) {
                if(sum>max){
                    max = sum;
                    subArray = new ArrayList<Integer>(list.subList(start, end+1));
                }
                sum -= list.get(start);
                start++;
            }
        }
        return subArray;
    }
    public static void main(String[] args) {
        int k=3;
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 1, 5, 1, 3, 2));
        ArrayList<Integer> resultList = new ArrayList<>(list.size()-k+1);
        resultList = MaxSumSubArray.maxSumSubArray(list, k);
        System.out.println(resultList);
    }
}
