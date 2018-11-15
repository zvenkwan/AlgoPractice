import java.util.ArrayDeque;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * 
 * @author jguan
 *
527. Trie Serialization
Serialize and deserialize a trie (prefix tree, search on internet for more details).

You can specify your own serialization algorithm, the online judge only cares about whether you can successfully deserialize the output from your own serialize function.

Example
str = serialize(old_trie)
>> str can be anything to represent a trie
new_trie = deserialize(str)
>> new_trie should have the same structure and values with old_trie
An example of test data: trie tree <a<b<e<>>c<>d<f<>>>>, denote the following structure:

     root
      /
     a
   / | \
  b  c  d
 /       \
e         f
Notice
You don't have to serialize like the test data, you can design your own format.
 */
public class TrieSerialization {
	/**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a trie which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TrieNode root) {
        // Write your code here
        if(root == null) return "";
        StringBuilder sb = new StringBuilder("<");
        for(Map.Entry<Character, TrieNode> child: root.children.entrySet()) {
            sb.append(child.getKey()).append(serialize(child.getValue()));
        }
        sb.append(">");
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TrieNode deserialize(String data) {
        // Write your code here
        if(data == null) return null;
        
        TrieNode root = new TrieNode();
        ArrayDeque<TrieNode> stack = new ArrayDeque<TrieNode>();
        stack.push(root);
        for(int i = 0; i < data.length(); i++) {
            char curr = data.charAt(i);
            if(curr == '>') {
                stack.pop();
            }
            else if(Character.isLetter(curr)) {
                System.out.println(curr);
                TrieNode parent = stack.peek();
                if(parent.children == null) {
                    parent.children = new TreeMap<Character, TrieNode>();
                }
                TrieNode currNode = new TrieNode();
                parent.children.put(curr, currNode);
                stack.push(currNode);
            }
            // else {if <, do nothing
            // }
        }
        return root;
    }
    /**
     * Definition of TrieNode:
     * public class TrieNode {
     *     public NavigableMap<Character, TrieNode> children;
     *     public TrieNode() {
     *         children = new TreeMap<Character, TrieNode>();
     *     }
     * }
     */
    class TrieNode {
    	public NavigableMap<Character, TrieNode> children;
    	public TrieNode() {
    		children = new TreeMap<Character, TrieNode>();
    	}
    }
}

