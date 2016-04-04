package ArrayAndString;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
/**
 * 170. Two Sum III - Data structure design
 * @author zg55
 *Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
Hide Company Tags LinkedIn
Hide Tags Hash Table Design
Hide Similar Problems (E) Two Sum (E) Unique Word Abbreviation
 */
public class TwoSumIII {
	private List<Integer> list = new ArrayList<Integer>();
	private HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
    public void add(int number) {
    	if(map.containsKey(number)) 
    		map.put(number, map.get(number)+1);
    	else {
    		map.put(number,1);
    		list.add(number);
    	}
    }
    public boolean find(int value) {
    	for(int i:list) {
    		if((value-i==i&&map.get(i)>1)||(value-i!=i&&map.containsKey(value-i)))
    			return true;
    	}
    	return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
