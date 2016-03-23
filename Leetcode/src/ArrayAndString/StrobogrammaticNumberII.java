package ArrayAndString;
/**
 * 247. Strobogrammatic Number II
 * @author zg55
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].

Hint:

Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumberII {

	public static void main(String[] args) {
		System.out.println(
		new StrobogrammaticNumberII().findStrobogrammatic(4));
	}
	
    public List<String> findStrobogrammatic(int n) {
    	return getStrobo(n,n);
    }
    
    public List<String> getStrobo(int n, int o) {
    	if(n==0)
    		return (List<String>) Arrays.asList("");
    	if(n==1)
        	return (List<String>) Arrays.asList("0","1","8");
    	
    	List<String> inner = getStrobo(n-2, o);
    	List<String> result = new ArrayList<String>();
    	for(String s:inner) {
    		if(n!=o)
    			result.add('0'+s+'0');
    		result.add('1'+s+'1');
    		result.add('6'+s+'9');
    		result.add('8'+s+'8');
    		result.add('9'+s+'6');
    	}
    	return result;
    }
}
