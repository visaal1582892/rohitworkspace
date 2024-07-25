import java.util.ArrayList;
import java.util.Arrays;

// Here we can also use brute force method which needs N*K time complexity too reduce it to N we use Sliding Window.

public class SumsOfSubsets {
    public static ArrayList<Integer> maxSumSubArray(ArrayList<Integer> list, int k){
        int n = list.size();
        ArrayList<Integer> resultList = new ArrayList<>(n-k+1);
        int start = 0;
        int sum = 0;
        for(int end=0; end<n; end++){
            sum += list.get(end);
            if (end >= k-1) {
                resultList.add(sum);
                sum -= list.get(start);
                start++;
            }
        }
        return resultList;
    }
    public static void main(String[] args) {
        int k=3;
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 1, 5, 1, 3, 2));
        ArrayList<Integer> resultList = new ArrayList<>(list.size()-k+1);
        resultList = MaxSumSubArray.maxSumSubArray(list, k);
        System.out.println(resultList);
    }
}

