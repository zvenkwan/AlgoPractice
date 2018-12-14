package interviews.gg;
/**
 * 
 * @author jguan
 *
888. Valid Word Square
Given a sequence of words, check whether it forms a valid word square.

A sequence of words forms a valid word square if the k^th row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

Example
Given
[
  "abcd",
  "bnrt",
  "crmy",
  "dtye"
]
return true

Explanation:
The first row and first column both read "abcd".
The second row and second column both read "bnrt".
The third row and third column both read "crmy".
The fourth row and fourth column both read "dtye".

Therefore, it is a valid word square.
Given
[
  "abcd",
  "bnrt",
  "crm",
  "dt"
]
 */
public class ValidWordSquare {
    /**
     * @param words: a list of string
     * @return: a boolean
     */
    public boolean validWordSquare(String[] words) {
        // Write your code here
        for(int r = 0; r < words.length; r++) {
            if(isValid(words, r)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    
//	pay attention to the length
    private boolean isValid(String[] word, int c) {
        for(int r = 0; r < word.length; r++) {
            if(c < word[r].length() && r < word[c].length() && word[r].charAt(c) == word[c].charAt(r)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }


}
