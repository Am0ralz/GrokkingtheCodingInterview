package SlidingWindow;

import java.util.HashMap;
//Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.
//
//        Example 1:
//
//        Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
//        Output: 6
//        Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
//        Example 2:
//
//        Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
//        Output: 9
//        Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
public class EX8_FindLongestSubArrayReplacingZeros {

    //used an array instead of typical hashmap to count
    public static int findLength(int[] arr, int k) {
        int start = 0;
        int maxLen = 0;
        int[] counter = {0,0};
        for (int end = 0; end < arr.length; end++) {
            counter[arr[end]] += 1;
            while (end - start + 1 - counter[1] > k) {
                counter[arr[start]] -= 1;
                start += 1;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;

        }
// More efficient way fo doing it from the tutorial
    public static int findLength2(int[] arr, int k) {
        int windowStart = 0, maxLength = 0, maxOnesCount = 0;
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1)
                maxOnesCount++;

            // current window size is from windowStart to windowEnd, overall we have a maximum of 1s
            // repeating a maximum of 'maxOnesCount' times, this means that we can have a window with
            // 'maxOnesCount' 1s and the remaining are 0s which should replace with 1s.
            // now, if the remaining 0s are more than 'k', it is the time to shrink the window as we
            // are not allowed to replace more than 'k' Os
            if (windowEnd - windowStart + 1 - maxOnesCount > k) {
                if (arr[windowStart] == 1)
                    maxOnesCount--;
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }


    public static void main(String[] args) {
        System.out.println(findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
    }

