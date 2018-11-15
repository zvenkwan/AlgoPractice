package interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
/**
 * 
 * @author jguan
 * 
 * 1380. Log Sorting
Give a log, consisting of List< String >, each element representing one line of logs. Each line of log information is separated by a space. The first is the ID of the log, followed by the log content.
There are two ways to make content:

All consist of letters and spaces.
All consist of numbers and spaces.
Now that the logs are sorted, it is required that component 1 be sorted in order of content lexicography and placed at the top, and component 2 should be placed at the bottom and output in the order of input. (Note that the space also belongs to the content, and when the lexicographic order of the composition method 1 is equal, sort according to the dictionary order of log ID., and the guarantee ID is not repeated)
Example
Given

[
    "zo4 4 7",
    "a100 Act zoo",
    "a1 9 2 3 1",
    "g9 act car"
]
, return

[
    "a100 Act zoo",
    "g9 act car",
    "zo4 4 7",
    "a1 9 2 3 1"
]
Explanation:
"Act zoo" < "act car", So the output is as above.
Given

[
    "zo4 4 7",
    "a100 Actzoo",
    "a100 Act zoo",
    "Tac Bctzoo",
    "Tab Bctzoo",
    "g9 act car"
]
, return

[
    "a100 Act zoo",
    "a100 Actzoo",
    "Tab Bctzoo",
    "Tac Bctzoo",
    "g9 act car",
    "zo4 4 7"
]
Explanation:
Because "Bctzoo" == "Bctzoo", the comparison "Tab" and "Tac" have "Tab" < Tac ", so" Tab Bctzoo "< Tac Bctzoo".
Because ' '<'z', so "A100 Act zoo" < A100 Actzoo".
Notice
The total number of logs entered was n, and n < = 10000.

The length of each line is mi, and mi < = 100.
 *sort logs
 *log format [id val1 val2 val3....]
 *all numbers stay behind
 *otherwise lexicographically, sort by id if same
 */
public class LogSorting {

	public static void main(String[] args) {
		String[] logs = null;
//		String[] logs = {
//				"[a1 9 2 3 1]",
//				"[g1 act car]",
//				"[zo4 4 7]",
//				"[ab1 off key dog]",
//				"[a8 act zoo]",
//				"[a1 act zoo]",
//				"[a1 9 2 5 1]"
//		};
		ArrayList<Log> list = new ArrayList<>();
		for(String log : logs) {
			list.add(new Log(log));
		}
		Collections.sort(list);
		System.out.println(list);
	}
	
    /**
     * @param logs: the logs
     * @return: the log after sorting
     */
    public String[] logSort(String[] logs) {
        // Write your code here
		ArrayList<Log> list = new ArrayList<>();
    	for(String log : logs) {
			list.add(new Log(log));
		}
		Collections.sort(list);
		String[] res = new String[list.size()];
		for(int i = 0; i < list.size(); i ++) {
			res[i] = list.get(i).toString();
		}
		return res;
    }
    
    /**
     * @param logs: the logs
     * @return: the log after sorting
     */
    public String[] logSort2(String[] logs) {
        // Write your code here
        if(logs == null||logs.length == 0) return null;
        
        List<String> list = new ArrayList<String>();
        String [] ans = new String[logs.length];
        int cnt = logs.length - 1;
        for(int i = logs.length - 1; i >= 0; i--) {
            int index = logs[i].indexOf(' ');
            String body = logs[i].substring(index + 1);
            if(body.charAt(0) >= '0' && body.charAt(0) <= '9') {
                ans[cnt--] = logs[i];
            } else {
                list.add(new String(logs[i]));
            }
        }
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                int idx1 = o1.indexOf(' ');
                int idx2 = o2.indexOf(' ');
                String head1 = o1.substring(0, idx1);
                String head2 = o2.substring(0, idx2);
                String body1 = o1.substring(idx1);
                String body2 = o2.substring(idx2);
                if(body1.equals(body2)) {
                    return head1.compareTo(head2);
                } else {
                    return body1.compareTo(body2);
                }
            }
            
        });
        
        cnt = 0;
        for(String i: list) {
            ans[cnt++] = i; 
        }
        return ans;
    }
    @Test
    public void test() {
    	String[] input = {
				"[a1 9 2 3 1]",
				"[g1 act car]",
				"[zo4 4 7]",
				"[ab1 off key dog]",
				"[a8 act zoo]",
				"[a1 act zoo]",
				"[a1 9 2 5 1]"
		};
    	
    	String[] out = {
				"[g1 act car]",
				"[a1 act zoo]",
				"[a8 act zoo]",
				"[ab1 off key dog]",
				"[zo4 4 7]",
				"[a1 9 2 3 1]",
				"[a1 9 2 5 1]"
    	};
    	
    	Assert.assertArrayEquals(out, logSort(input));
    }
    @Test
    public void testEmpty() {
    	String[] input = {
    	};
    	
    	String[] out = {
    	};
    	
    	Assert.assertArrayEquals(out, logSort(input));
    }
    @Test
    public void testOneElement() {
    	String[] input = {
				"[a1 9 2 5 1]"
    	};
    	
    	String[] out = {
				"[a1 9 2 5 1]"
    	};
    	
    	Assert.assertArrayEquals(out, logSort(input));
    }
    @Test
    public void testTwoSameElements() {
    	String[] input = {
    			"[a1 9 2 5 1]",
    			"[a1 9 2 5 1]"
    	};
    	
    	String[] out = {
    			"[a1 9 2 5 1]",
    			"[a1 9 2 5 1]"
    	};
    	
    	Assert.assertArrayEquals(out, logSort(input));
    }
    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Test
    public void testNull() {
    	String[] input = null;
    	exception.expect(NullPointerException.class);
    	logSort(input);
    }
}

class Log implements Comparable<Log> {
	
	Word id;
	boolean isNumber;
	Word[] values;
	String log;
	public Log(String log) {
		this.log = log;
		log = log.substring(1, log.length() - 1);
		String[] arr = log.split("\\s+");
		this.id = new Word(arr[0]);
		values = new Word[arr.length - 1];
		this.isNumber = true;
		for(int i = 1; i < arr.length; i++) {
			values[i - 1] = new Word(arr[i]);
			if(isNumber) {
				for(char c: arr[i].toCharArray()) {
					if(Character.isLetter(c)) {
						isNumber = false;
					}
				}
			}
		}
	}
	@Override
	public int compareTo(Log o) {
		// TODO Auto-generated method stub
		if(this.isNumber && o.isNumber || !this.isNumber && !o.isNumber) {
			int i = 0;
			while(i < this.values.length && i < o.values.length) {
				int res = this.values[i].compareTo(o.values[i]);
				if(res != 0) {
					return res;
				}
				i++;
			}
			
			if(this.values.length == o.values.length) {
				return this.id.compareTo(o.id);
			}
		} else {
			if(this.isNumber) return 1;
			else return -1;
		}
		return 0;
	}
	
	public String toString() {
		return log;
	}
	
}

class Word implements Comparable<Word> {
	
	String value;
	
	public Word(String value) {
		this.value = value;
	}
	
	@Override
	public int compareTo(Word o) {
		// TODO Auto-generated method stub
		int i = 0;
		while(i < this.value.length() && i < o.value.length()) {
			if( this.value.charAt(i) < o.value.charAt(i)) {
				return -1;
			} else if( this.value.charAt(i) > o.value.charAt(i)) {
				return 1;
			}
			i++;
		}
		if(this.value.length() == o.value.length()) return 0;
		else {
			if(this.value.length() == i) {
				return -1;
			} else {
				return 1;
			}
		}
	}
	
}