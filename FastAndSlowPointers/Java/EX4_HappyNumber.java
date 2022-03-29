package FastAndSlowPointers;
//# Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the
// square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’. Instead,
//they will be stuck in a cycle of numbers which does not include ‘1’.
//
//  Example 1:
//
// Input: 23
//  Output: true (23 is a happy number)
//  Explanations: Here are the steps to find out that 23 is a happy number:
//
//Example 2:
// 
//  Input: 12
//  Output: false (12 is not a happy number)
// Explanations: Here are the steps to find out that 12 is not a happy number:
public class EX4_HappyNumber {
    public static boolean find(int num) {
        int slow = num;
        int fast = num;
        while(fast != 1){
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
            if(fast == slow){
                return false;
            }
        }
        return true;
    }
    static int findSquareSum(int num) {
        int sum=0;
        while(num>0){
            sum += num % 10 * num % 10;
            num /=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(find(23));
        System.out.println(find(12));
    }
}
