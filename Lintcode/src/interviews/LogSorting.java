package interviews;

import java.util.ArrayList;
import java.util.Collections;
/**
 * 
 * @author jguan
 *sort logs
 *log format [id val1 val2 val3....]
 *all numbers stay behind
 *otherwise lexicographically, sort by id if same
 */
public class LogSorting {

	public static void main(String[] args) {
		String[] logs = {
				"[a1 9 2 3 1]",
				"[g1 act car]",
				"[zo4 4 7]",
				"[ab1 off key dog]",
				"[a8 act zoo]",
				"[a1 act zoo]",
				"[a1 9 2 5 1]"
		};
		ArrayList<Log> list = new ArrayList<>();
		for(String log : logs) {
			list.add(new Log(log));
		}
		Collections.sort(list);
		System.out.println(list);
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