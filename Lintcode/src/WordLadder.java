import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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
        int step = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for(int i = 0 ; i < size; i ++) {
                String word = queue.poll();
                for(String d: dict) {
                	if(hash.contains(d)) continue;
                    if(oneCharDiff(word, d)) {
                        if(d.equals(end)) {
                            return step;
                        }
                        queue.offer(d);
                        hash.add(d);
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
}
