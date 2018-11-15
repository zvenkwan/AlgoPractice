/**
 * 
 * @author jguan
 *442. Implement Trie (Prefix Tree)
Implement a trie with insert, search, and startsWith methods.

Example
insert("lintcode")
search("code")
>>> false
startsWith("lint")
>>> true
startsWith("linterror")
>>> false
insert("linterror")
search("lintcode)
>>> true
startsWith("linterror")
>>> true
Notice
You may assume that all inputs are consist of lowercase letters a-z.
 */
public class Trie {
    private TrieNode head = null;
    public Trie() {
        // do intialization if necessary
        head = new TrieNode();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        TrieNode curr = head;
        for(char c: word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.hasWord = true;
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        TrieNode curr = head;
        for(char c: word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                return false;
            } else {
                curr = curr.children[c - 'a'];
            }
        }
        return curr.hasWord;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        TrieNode curr = head;
        for(char c: prefix.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                return false;
            } else {
                curr = curr.children[c - 'a'];
            }
        }
        return true;
    }
    private class TrieNode {
    	boolean hasWord;
    	TrieNode[] children;
    	public TrieNode() {
    		children = new TrieNode[26];
    	}
    }
}
