package ArrayAndString;
/**
 * leetcode 288. Unique Word Abbreviation
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
Hide Company Tags Google
Hide Tags Hash Table Design
Hide Similar Problems (E) Two Sum III - Data structure design (M) Generalized Abbreviation

 */
import java.util.HashMap;

public class ValidWordAbbr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s[] = {"hello"};
		ValidWordAbbr v = new ValidWordAbbr(s);
		System.out.println(v.isUnique("hello"));
	}
    private HashMap<String,String> map;
    public ValidWordAbbr(String[] dictionary) {
        if(map==null) map = new HashMap<String, String>();
        for(String s:dictionary) {
            String k = getKey(s);
            if(map.containsKey(k)&&!map.get(k).equals(s)) map.put(k, "");
            else map.put(k, s);
        }
    }

    public boolean isUnique(String word) {
        String k = getKey(word);
        return map.get(k) == null || map.get(k).equals(word);
    }
    
    private String getKey(String word) {
        if(word.length()<=2) return word;
        else return ""+word.charAt(0)+Integer.toString(word.length()-2)+word.charAt(word.length()-1);
    }
}
