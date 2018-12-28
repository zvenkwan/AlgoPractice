import java.util.HashMap;
/**
 * 
 * @author jguan
 *522. Tiny Url II
As a follow up for Tiny URL, we are going to support custom tiny url, so that user can create their own tiny url.

Example
createCustom("http://www.lintcode.com/", "lccode")
>> http://tiny.url/lccode
createCustom("http://www.lintcode.com/", "lc")
>> error
longToShort("http://www.lintcode.com/problem/")
>> http://tiny.url/1Ab38c   // this is just an example, you can have you own 6 characters.
shortToLong("http://tiny.url/lccode")
>> http://www.lintcode.com/
shortToLong("http://tiny.url/1Ab38c")
>> http://www.lintcode.com/problem/
shortToLong("http://tiny.url/1Ab38d")
>> null
Notice
Custom url may have more than 6 characters in path.
 */
public class TinyUrl2 {
    private HashMap<String, String> keytolong;
    private HashMap<String, String> longtokey;
    String prefix = "http://tiny.url/";
	private static long id = 0;
	private static final String dict = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int base = dict.length();
	private static final int len = 6;
    
    public TinyUrl2() {
        longtokey = new HashMap<String, String>();
        keytolong = new HashMap<String, String>();
    }
    
    public String longToShort(String url) {
        // write your code here
        if(longtokey.containsKey(url)) {
            return longtokey.get(url);
        }
        
        
        long key = getKey();
        String shortKey = getShortKey(key);
        keytolong.put(prefix + shortKey, url);
        longtokey.put(url, prefix + shortKey);
        
        return prefix + shortKey;
    }

    /*
     * @param url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    public String shortToLong(String url) {
        // write your code here
        return keytolong.get(url);
    }
    
    private long getKey() {
        return id++;
    }
    
    private String getShortKey(long key) {
        String shortKey = "";
        int i = 0;
        while(i < len) {
            shortKey = shortKey + dict.charAt((int)key%base);
            key = key/base;
            i++;
        }
        return shortKey;
    }

    public String createCustom(String long_url, String key) {
        // write your code here
    	
//    	check if the long url has already had a short one
        if(longtokey.containsKey(long_url)) {
            if(longtokey.get(long_url).equals(prefix + key)) {
                return prefix + key;
            } else {
                return "error";
            }
        }
//        check if the short key has already been assigned to other long one
        if(keytolong.containsKey(prefix + key)) {
            return "error";
        }
        longtokey.put(long_url, prefix + key);
        keytolong.put(prefix + key, long_url);
        return prefix + key;
    }



}
