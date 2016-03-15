package ArrayAndString;
/**
 * 243. Shortest Word Distance
 * @author zg55
 *Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = ��coding��, word2 = ��practice��, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistance {
	
		
    public int shortestDistance(String[] words, String word1, String word2) {
        String s[] = {word1, word2};
        int shortest = Integer.MAX_VALUE;
        int pw1 = -1;
        int pw2 = -1;
        for(int i=0; i<words.length; i++) {
        	if(words[i].equals(s[0])&&i>pw1)
        		pw1=i;
        	else if(words[i].equals(s[1])&&i>pw2)
        		pw2=i;
    		System.out.println("pw1 is "+pw1+"   pw2 is "+pw2+"   shortest is "+shortest+"  distance is "+Math.abs(pw1-pw2));
        	if(pw1>-1&&pw2>-1)
        		shortest=Math.min(Math.abs(pw1-pw2), shortest);
        }
        return shortest;
    }
	public static void main(String[] args) {
		String words[] = {"a", "b", "c", "d", "d"};
		System.out.println(new ShortestWordDistance().shortestDistance(words, "a", "d"));
		
	}

}
