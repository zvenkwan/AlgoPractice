package ArrayAndString;
import java.util.ArrayList;
import java.util.List;
/**
 * 293. Flip Game
 * @author zg55
 *You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:
 */
public class FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
        List<String> moves = new ArrayList<String>();
        for(int i=0; i<s.length()-1; i++) {
        	if(s.charAt(i)=='+'&&s.charAt(i+1)=='+')
        		moves.add(s.substring(0,i)+"--"+s.substring(i+2,s.length()));
        }
        return moves;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "++++";
		System.out.println(new FlipGame().generatePossibleNextMoves(s));
	}

}
