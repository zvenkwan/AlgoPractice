/**
 * 
 * @author jguan
 *1095. Maximum Swap
Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example
Example 1:

Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:

Input: 9973
Output: 9973
Explanation: No swap.
Notice
The given number is in the range [0, 10^8]
 */
public class MaximumSwap {

    /**
     * @param num: a non-negative intege
     * @return: the maximum valued number
     */
    public int maximumSwap(int num) {
        // Write your code here
        
        if(num <= 0) return 0;
        if(num <= 11) return num;
        
        char[] arr = (""+num).toCharArray();
        for(int i = 0 ; i < arr.length; i++) {
            int index = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] >= arr[index]) {
                    index = j;
                }
            }
            if(arr[index] != arr[i]) {
                char t = arr[i];
                arr[i] = arr[index];
                arr[index] = t;
                return Integer.parseInt(String.valueOf(arr));
            }
        }
        return num;
    }

}
