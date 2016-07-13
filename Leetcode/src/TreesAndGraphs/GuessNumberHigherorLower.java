package TreesAndGraphs;
/**
 * leetcode 374. Guess Number Higher or Lower
 * We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example:
n = 10, I pick 6.

Return 6.
Hide Company Tags Google
Hide Tags Binary Search
Hide Similar Problems (E) First Bad Version

 * @author zg55
 *
 */
public class GuessNumberHigherorLower {
    public int guessNumber(int n) {
        return guessNumber(1, n);
    }
    private int guessNumber(int s, int e) {
        int m = s+(e-s)/2;
        if(guess(m)==0) return m;
        else if(guess(m)==1) return guessNumber(m+1,e);
        else return guessNumber(s,m-1);
    }
}
/* The guess API is defined in the parent class GuessGame.
@param num, your guess
@return -1 if my number is lower, 1 if my number is higher, otherwise return 0
   int guess(int num); */

