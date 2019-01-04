import java.util.LinkedList;
/**
 * 
 * @author jguan
 *
423. Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

Example
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
//        if(s == null || s.length() == 0 )  return true;
//        LinkedList<Character> stack = new LinkedList<Character>();
//        for( char c: s.toCharArray()) {
//            if(stack.size() == 0) {
//                if(isLeft(c))
//                    stack.push(c);
//                else
//                    return false;
//            }
//            else {
//                if(isPair(stack.peek(), c) ){
//                    stack.pop();
//                }
//                else {
//                    if(isLeft(c))
//                        stack.push(c);
//                    else
//                        return false;
//                }
//            }
//        }
//        return stack.isEmpty();

        // Write your code here
        if(s == null || s.length() == 0 )  return true;
        LinkedList<Character> stack = new LinkedList<Character>();
        for( char c: s.toCharArray()) {
            if(c == '(') {
                stack.push(')');
            } else if(c == '[') {
                stack.push(']');
            } else if(c == '{') {
                stack.push('}');
            } else if(stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
    
//    private boolean isLeft(char c) {
//        return c == '(' || c == '[' || c == '{';
//    }
//    
//    private boolean isPair(char c1, char c2) {
//        return c1 == '(' && c2 == ')' || c1 == '[' && c2 == ']' || c1 == '{' && c2 == '}';
//    }

}
