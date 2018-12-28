import java.util.HashMap;

/**
 * 
 * @author jguan
 *232. Tiny Url
Given a long url, make it shorter. To make it simpler, let's ignore the domain name.

You should implement two methods:

longToShort(url). Convert a long url to a short url.
shortToLong(url). Convert a short url to a long url starts with http://tiny.url/.
You can design any shorten algorithm, the judge only cares about two things:

The short key's length should equal to 6 (without domain and slash). And the acceptable characters are [a-zA-Z0-9]. For example: abcD9E
No two long urls mapping to the same short url and no two short urls mapping to the same long url.
Example
Given url = http://www.lintcode.com/faq/?id=10, run the following code (or something similar):

short_url = longToShort(url) // may return http://tiny.url/abcD9E
long_url = shortToLong(short_url) // return http://www.lintcode.com/faq/?id=10
The short_url you return should be unique short url and start with http://tiny.url/ and 6 acceptable characters. For example "http://tiny.url/abcD9E" or something else.

The long_url should be http://www.lintcode.com/faq/?id=10 in this case.
 */
public class TinyUrl {
    /*
     * @param url: a long url
     * @return: a short url starts with http://tiny.url/
     */
    
    private HashMap<String, String> keytolong;
    private HashMap<String, String> longtokey;
    String prefix = "http://tiny.url/";
	private static long id = 0;
	private static final String dict = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int base = dict.length();
	private static final int len = 6;
    
    public TinyUrl() {
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


}
