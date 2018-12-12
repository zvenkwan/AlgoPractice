package interviews.gg;
/**
 * 
 * @author jguan
 *
1634. Secret Word
Given a secrect word, and an encoding rule as follows: Transform each letter in the secret, different letters can not be changed to the same letter. Such as banana -> xyzyzy, but banana can not become xyyyyy, because there is no way to decode back.
Now input a very long string, and it is required to determine whether a substring exists in the string can be transformed by the above encoding rule. If exists, output string "yes", otherwise output "no".

Example
Give s="abcabcd", word="xyzxyz", return yes

Explaination:
"x" can transfer to "a", "y" can transfer to "b" and "z" can transfer to "c".
Give s="abca", word="xyzd", return no

Explaination:
the word "xyzd" has no way to transfer to "abca"
Notice
The length of the secret word does not exceed 1010.

The length of the string does not exceed 1000010000.

The string only consists of lowercase.
 */
public class SecretWord {

    /**
     * @param s: the long string
     * @param word: the secrect word
     * @return: whether a substring exists in the string can be transformed by the above encoding rule
     */
    public String getAns(String s, String word) {
        // Write a code here
        if(s == null || word == null) return "no";
        if(s.length() < word.length()) return "no";
        
        for(int i = 0; i <= s.length()-word.length(); i++) {
            
            int j=0;
            int[] sIndex = new int [256];
            int[] wIndex = new int [256];
            while(j < word.length())
            {
                if(sIndex[s.charAt(i+j)] == wIndex[word.charAt(j)])
                {
                    sIndex[s.charAt(i+j)] = wIndex[word.charAt(j)] = j+1;
                    j++;
                }
                else
                {
                    break;
                }
            }
            if(j == word.length())
            {
                return "yes";
            }
        }
        return "no";
    }

}
