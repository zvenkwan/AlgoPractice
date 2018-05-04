import java.util.HashMap;
/**
 * 
 * @author jguan
 *607. Two Sum III - Data structure design
Description
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Have you met this question in a real interview?  
Example
add(1); add(3); add(5);
find(4) // return true
find(7) // return false
 */
public class TwoSumIII {
    HashMap<Integer, Integer> map = new HashMap<>();
    /*
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        // write your code here
        map.put(number, map.getOrDefault(number, 0) +1);
    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for(int key : map.keySet()) {
            int target = value - key;
            if(target == key) {
                if(map.getOrDefault(target, 0) >= 2) return true;
            } else {
                if(map.getOrDefault(target, 0) == 1) return true;
            }
        }
        return false;
    }
}
