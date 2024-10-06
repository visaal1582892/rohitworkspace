//Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.

public class HappyNumber {
    public static int sumOfSquares(int n){
        int sum=0;
        while(n!=0){
            int d=n%10;
            sum+=(d*d);
            n=n/10;
        }
        return sum;
    }
    public static boolean happyNumber(int n){
        int fast=n;
        int slow=n;
        while(fast!=1){
            fast=sumOfSquares(sumOfSquares(fast));
            slow=sumOfSquares(slow);
            if(fast==slow){
                return false;
            }
        }
        return fast==1;
    }
    public static void main(String[] args) {
        System.out.println(HappyNumber.happyNumber(23));
        // System.out.println(HappyNumber.sumOfSquares(25));
    }
}
