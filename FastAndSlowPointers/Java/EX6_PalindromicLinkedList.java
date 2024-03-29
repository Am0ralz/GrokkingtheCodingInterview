package FastAndSlowPointers;
//Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.
//
//        Your algorithm should use constant space and the input LinkedList should be in the original form once the algorithm is finished. The algorithm should have O(N)O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.
//
//        Example 1:
//
//        Input: 2 -> 4 -> 6 -> 4 -> 2 -> null
//        Output: true
//        Example 2:
//
//        Input: 2 -> 4 -> 6 -> 4 -> 2 -> 2 -> null
//        Output: false
public class EX6_PalindromicLinkedList {
    static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // find middle of the LinkedList
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headSecondHalf = reverse(slow); // reverse the second half
        // store the head of reversed part to revert back later
        ListNode copyHeadSecondHalf = headSecondHalf;

        // compare the first and the second half
        while (head != null && headSecondHalf != null) {
            if (head.value != headSecondHalf.value) {
                break; // not a palindrome
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }

        reverse(copyHeadSecondHalf); // revert the reverse of the second half
        // if both halves match
        return head == null || headSecondHalf == null;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindrome(head));
    }
}
