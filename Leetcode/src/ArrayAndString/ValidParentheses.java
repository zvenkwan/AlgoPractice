package ArrayAndString;
import java.util.Stack;
/**
 * 20. Valid Parentheses
 * @author zg55
 *Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public boolean isValid(String st) {
        if(st.length()%2!=0)
        return false;
        Stack<Character> s = new Stack<Character>();
        s.push('0');
        for(char c:st.toCharArray()) {
            if(isPair((char)s.peek(), c))
                s.pop();
            else
                s.push(c);
        }
        return (char)s.peek()=='0';
    }
    public boolean isPair(char left, char right) {
        
        if(left=='('&&right==')')
            return true;
        if(left=='['&&right==']')
            return true;
        if(left=='{'&&right=='}')
            return true;
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
