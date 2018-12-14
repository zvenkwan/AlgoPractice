package interviews.gg;

import java.util.LinkedList;
import java.util.List;
/**
 * 
 * @author jguan
 *914. Flip Game
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

Example
Given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].
 */
public class FlipGame {

    /**
     * @param s: the given string
     * @return: all the possible states of the string after one valid move
     */
    public List<String> generatePossibleNextMoves(String s) {
        // write your code here
        List<String> res = new LinkedList<String>();
        
        if(s == null || s.length() < 2) return res;
        
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                res.add(s.substring(0, i) + "--" + s.substring(i + 2));
            } 
        }
        return res;
    }

}
