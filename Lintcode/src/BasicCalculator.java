import java.util.ArrayDeque;
/**
 * 
 * @author jguan
 *

978. Basic Calculator
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Example
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Notice
Do not use the eval built-in library function.
 */
public class BasicCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(1+(4+5+2)-3)+(6+8)";
		BasicCalculator bc = new BasicCalculator();
		int r = bc.calculate(s);
		System.out.println(r);
	}

    /**
     * @param s: the given expression
     * @return: the result of expression
     */
    public int calculate(String s) {
        // Write your code here
        
        ArrayDeque<Character> operators = new ArrayDeque<Character>();
        ArrayDeque<Integer> operands = new ArrayDeque<Integer>();
        int num = 0;
        
        for(int i = 0 ; i < s.length(); i ++) {
            char c = s.charAt(i);
            
            
            if(Character.isDigit(c)) {
                num = num * 10 + Character.getNumericValue(c);
            }
            
            if(c == '(' || c == '+' || c == '-' || c == '*' || c == '/' || c == ')' || i + 1 == s.length()) {
            	
            	char lastOp = operators.isEmpty() ? ' ' : operators.peek();
                if(lastOp == '-') {
                	num = -num;
                	operators.pop();
                	operators.push('+');
                }
                if(lastOp == '*' || lastOp == '/') {
                	operators.pop();
                    int last = operands.pop();
                    if(c == '*') {
                        num = last * num;
                    }
                    else {
                        num = last / num;
                    }
                } else if(c == ')') {
                	while (true) {
                		char op = operators.pop();
                		if(op == '(') break;
                        int last = operands.pop();
                        if(op == '+') {
                        	num += last;
                        } else {
                        	num = last - num;
                        }
                    }
                } else if(i + 1 == s.length()) {
                    while(!operators.isEmpty()) {
                    	operators.pop();
                        int last = operands.pop();
                        num += last;
                    }
                }
                if(c != '(') {
                	operands.push(num);
                	num = 0;
                }
                if(c != ')') {
                	operators.push(c);
                	c = ' ';
                }
            }
        }
        
        return operands.pop();
    }
    

}
