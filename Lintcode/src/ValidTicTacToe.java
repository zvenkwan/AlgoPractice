/**
 * 
 * @author jguan
 *
1022. Valid Tic-Tac-Toe State
A Tic-Tac-Toe board is given as a string array board. Return True if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.

The board is a 3 x 3 array, and consists of characters " ", "X", and "O". The " " character represents an empty square.

Here are the rules of Tic-Tac-Toe:

Players take turns placing characters into empty squares (" ").
The first player always places "X" characters, while the second player always places "O" characters.
"X" and "O" characters are always placed into empty squares, never filled ones.
The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Example
Example 1:
Input: board = ["O  ", "   ", "   "]
Output: false
Explanation: The first player always plays "X".

Example 2:
Input: board = ["XOX", " X ", "   "]
Output: false
Explanation: Players take turns making moves.

Example 3:
Input: board = ["XXX", "   ", "OOO"]
Output: false

Example 4:
Input: board = ["XOX", "O O", "XOX"]
Output: true
 */
public class ValidTicTacToe {
    /**
     * @param board: the given board
     * @return: True if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game
     */
    public boolean validTicTacToe(String[] board) {
        // Write your code
        if(board == null || board.length != 3) return false;
        
        int countX = 0;
        int countO = 0;
        int lineX = countLine(board, 'X');
        int lineO = countLine(board, 'O');
        
        for(String s : board) {
            for(char c: s.toCharArray()) {
                if(c == 'X') countX++;
                else if(c == 'O') countO++;
            }
        }

        if(lineX == 0 && lineO == 0) {
            return countO == countX || countX - 1 == countO;
        }
        else if(lineX > 0 && lineO > 0) {
            return false;
        }
        else if(lineX == 1) {
            return countO == countX - 1;
        }
        else if(lineO == 1) {
            return countX == countO;
        }
        else {
            return false;
        }
    }
    
    private int countLine(String[] board, char c) {
        int line = 0;
        for(int i = 0 ; i < board.length; i++) {
            int count = 0;
            for(int j = 0; j < board[0].length(); j++) {
                if(board[i].charAt(j) == c) count++;
            }
            if(count == 3) line++;
        }
        
        for(int i = 0 ; i < board.length; i++) {
            int count = 0;
            for(int j = 0; j < board[0].length(); j++) {
                if(board[j].charAt(i) == c) count++;
            }
            if(count == 3) line++;
        }
        
        int count = 0;
        for(int i = 0; i < board.length; i++) {
            if(board[i].charAt(i) == c) count++;
        }
        if(count == 3) line++;
        
        count = 0;
        for(int i = 0; i < board.length; i++) {
            if(board[board.length - 1 - i].charAt(i) == c) count++;
        }
        if(count == 3) line++;
        
        return line;
        
    }
}
