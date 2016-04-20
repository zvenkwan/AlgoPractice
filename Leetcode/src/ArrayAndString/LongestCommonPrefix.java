package ArrayAndString;
/**
 * 14. Longest Common Prefix   
 * @author zg55
 *Write a function to find the longest common prefix string amongst an array of strings.

Hide Tags String

 */
public class LongestCommonPrefix {
	public class Solution {
	    public String longestCommonPrefix(String[] strs) {
	        if(strs==null||strs.length==0) return "";
	        if(strs.length==1) return strs[0];
	        String common="";
	        for(int i=0; i<strs[0].length(); i++) {
	            for(int j=1; j<strs.length; j++) {
	                if(i>strs[j].length()-1)
	                    return common;
	                if(strs[0].charAt(i)!=strs[j].charAt(i))
	                    return common;
	            }
	            common=common+strs[0].charAt(i);
	        }
	        return common;
	    }
	}
}
