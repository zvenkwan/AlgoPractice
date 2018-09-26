/**
 * 
 * @author jguan
 *
1617. Array Maximum Difference
Given an array a, output the maximum value of a[j] - a[i], where i<j, a[i]<a[j], a[i] is an odd number, and a[j] is an even number

Example
a = [1,2,3,4]
return 3
 */
public class ArrayMaximumDifference {

    /**
     * @param a: the array a
     * @return: return the maximum value
     */
    public int getAnswer(int[] a) {
        // Write your code here
        if(a == null || a.length <= 1) return 0;
        
        int i = 0;
        while(a[i] % 2 == 0) {
            i++;
            if(i == a.length - 1) return 0;
        }
        int min = a[i];
        int res = 0;
        for(int j = i + 1; j < a.length; j++) {
            if(a[j] % 2 == 1) {
                if(a[j] < min) {
                    min = a[j];
                }
            } else {
                if(a[j] > min) {
                    res = Math.max(res, a[j] - min);
                }
            }      
        }
        
        return res;
    }
}
