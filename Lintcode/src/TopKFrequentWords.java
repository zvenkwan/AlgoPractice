import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;
/**
 * 
 * @author jguan
 *
471. Top K Frequent Words
Given a list of words and an integer k, return the top k frequent words in the list.

Example
Given

[
    "yes", "lint", "code",
    "yes", "code", "baby",
    "you", "baby", "chrome",
    "safari", "lint", "code",
    "body", "lint", "code"
]
for k = 3, return ["code", "lint", "baby"].

for k = 4, return ["code", "lint", "baby", "yes"],

Challenge
Do it in O(nlogk) time and O(n) extra space.

Notice
You should order the words by the frequency of them in the return list, the most frequent one comes first. If two words has the same frequency, the one with lower alphabetical order come first.
 */
public class TopKFrequentWords {
    /**
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // write your code here
        if(words == null || k < 0) return null;
        if(k == 0) return new String[0];
        String[] res = new String[k];
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
//            want max count ----> min heap(to poll the min out)
        // want min string -----> max heap(to poll the max out) when count is same
         PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<Map.Entry<String, Integer>>(k, ((a,b) -> (
            a.getValue() - b .getValue() != 0?a.getValue() - b .getValue() : b.getKey().compareTo(a.getKey())
            )));
        for(Map.Entry<String, Integer> ent: map.entrySet()) {
            heap.offer(ent);
            if(heap.size() > k) {
            	heap.poll();
            }
        }
        
        for(int i = k - 1; i >= 0; i--) {
            res[i] = heap.poll().getKey();
        }
        
        return res;
            
        
    }
    
    
    @Test
    public void Test1() {
    	String[] input = {"aa", "ab"
    	};
    	int k = 1;
    	String[] out = {"aa"
    	};
    	
    	Assert.assertArrayEquals(out, topKFrequentWords(input, k));
    }
}
