import java.util.ArrayDeque;
/**
 * 
 * @author jguan
 *
980. Basic Calculator II
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Example
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Notice
Do not use the eval built-in library function.
 */
public class BasicCalculatorII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = " 3/2 ";
		BasicCalculatorII bc = new BasicCalculatorII();
		bc.calculate(s);
	}

    /**
     * @param s: the given expression
     * @return: the result of expression
     */
    public int calculate(String s) {
        // Write your code here
        if(s == null || s.length() == 0) return 0;
        
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        int result = 0;
        int num = 0;
        char prevSign = '+';
        for(int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            
            
            if(Character.isDigit(c)) {
                num = Character.getNumericValue(c) + num * 10;
            }
            
            if(c == '+' || c == '-' || c == '*' || c == '/' || i + 1 == s.length()) {
                // calculate when meet next sign
                if(prevSign == '+') {
                    stack.push(num);
                } else if(prevSign == '-') {
                    stack.push(-num);
                } else if (prevSign == '*') {
                    stack.push(stack.pop() * num);
                } else if (prevSign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                prevSign = c;
            }
        }
        
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
    

}
