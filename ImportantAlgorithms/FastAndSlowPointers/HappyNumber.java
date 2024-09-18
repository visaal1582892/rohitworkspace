public class HappyNumber {
    public static int squaredDigitSum(int number){
        int sum = 0;
        while (number != 0) {
            int digit = number%10;
            sum+=(digit*digit);
            number = number/10;
        }
        return sum;
    }
    public static boolean happyNumber(int number){
        int slow = number;
        int fast = number;
        do {
            if (HappyNumber.squaredDigitSum(fast) != 1) {
                fast = HappyNumber.squaredDigitSum(HappyNumber.squaredDigitSum(fast));
            }
            else{
                fast = HappyNumber.squaredDigitSum(fast);
            }
            slow = HappyNumber.squaredDigitSum(slow);
        } while (fast != slow && fast != 1);
        if (fast == slow) {
            return false;
        }
        if (fast == 1) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(HappyNumber.happyNumber(12));
    }
}
