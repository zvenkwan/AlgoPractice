import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
/**
 * 
 * @author jguan
 *120. Word Ladder 
 Description
 Notes
 Testcase
 Judge
Discuss 
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
 Notice
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
Have you met this question in a real interview? 
Example
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
 */
public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<>();
		String[] s = new String[]{"hot","dot","dog","lot","log"};
		Collections.addAll(dict, s);
		WordLadder wl = new WordLadder();
		System.out.println(wl.ladderLength(start, end, dict));
	}
	public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if(dict == null || dict.isEmpty()) return 0;
        if(start == null || end == null) return 0;
        if(start.equals(end)) return 1;
        dict.add(end);
        Queue<String> queue = new LinkedList<String>();
        Set<String> hash = new HashSet<>();
        queue.offer(start);
        hash.add(start);
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for(int i = 0 ; i < size; i ++) {
                String word = queue.poll();
                if(word.equals(end)) return step;
                for(String next: nextWords(word)) {
                	if(dict.contains(next) && !hash.contains(next)) {
                		queue.offer(next);
                		hash.add(next);
                	}
                }
                
            }
        }
        return 0;
    }
    
    private boolean oneCharDiff(String w1, String w2) {
        if(w1 == null || w2 == null) return false;
        if(w1.length() != w2.length()) return false;
        int c = 0 ;
        for(int i = 0; i < w1.length(); i ++ ) {
            if(w1.charAt(i) != w2.charAt(i)) {
                if(c++ == 1) return false;
            }
        }
        return c == 1;
    }
    
    
    private ArrayList<String> nextWords(String curr) {
    	ArrayList<String> nextWords = new ArrayList<String>();
        for(char c = 'a'; c <= 'z'; c++) {
            for(int i=0;i < curr.length(); i++) {
                nextWords.add(replace(curr, i, c));
            }
        }
        return nextWords;
    }
    
    private String replace(String curr, int i, char c) {
        return curr.substring(0, i) + c + curr.substring(i+1);
    }
}
