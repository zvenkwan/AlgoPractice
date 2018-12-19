package interviews.wyfr;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MultiplicationTable {
	
	
	public void print(int start, int end) {
		
		int target = String.valueOf(start).length() > String.valueOf(end).length()? start: end;
		List<Integer> lengthList = new ArrayList<Integer>();
		lengthList.add(String.valueOf(target).length());
		System.out.print(leftPad(' ', "X", lengthList.get(0)));
		
		for(int i = start; i <= end; i++) {
			int l = String.valueOf(i * target).length() + 1;
			lengthList.add(l);
			System.out.print(leftPad(i, l));
		}

		System.out.println();

//		System.out.println(lengthList);
		for(int i = start; i <= end; i++) {
			System.out.print(leftPad(' ', String.valueOf(i), lengthList.get(0)));
			for(int j = start; j <= end; j++) {
				System.out.print(leftPad(i*j, lengthList.get(j - start + 1)));
			}
			System.out.println();
		}
	}
	
	public String leftPad(char pad, String str, int size) {
		if(str == null) return null;
		if(size < 0 || size <= str.length()) return str;
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size - str.length(); i++) {
			sb.append(pad);
		}
		sb.append(str);
		return sb.toString();
	}
	
	public String leftPad(int i, int size) {
		return String.format("%" + size + "d", i);
	}
	
	
//	@Test
//	public void test() {
//		int start = 9;
//		int end = 14;
//		print(start, end);
//	}
//	
//	@Test
//	public void test2() {
//		int start = 1;
//		int end = 1;
//		print(start, end);
//	}
//	
	@Test
	public void test3() {
		int start = 1;
		int end = 10;
		print(start, end);
	}
	
	@Test
	public void test4() {
		int start = -5;
		int end = 0;
		print(start, end);
	}
}
