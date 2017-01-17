public class KMP implements SubString{

	@Override
	/**
	 * length of source is n, length of target is m
	 * time complexity O(n+m)
	 * space O(m)
	 */
	public int searchString(String source, String target) {
		// TODO Auto-generated method stub
		if(source == null || target == null) return -1;
		if(target.length() > source.length()) return -1;
		if(target.length() == 0) return 0;
		int[] count = buildKMPArray(target);
		int j=0;
		int startIndex = 0;
		for(int i=0; i <= source.length()-target.length(); i++) {
			startIndex = i-j;
			while(j<target.length() && source.charAt(i+j) == target.charAt(j)) {
				j++;
			} 
			if(j == target.length()) return startIndex;
//			by the time the match fails, do not have to check from the beginning of the target 
//			finding how many digits have already been checked from the KMP array and then
//			check the next digit
			j = j>1?count[j-1]:0;
		}
		return -1;
	}
	
	/**
	 * 
	 * @param target
	 * @return check given string, return each index in string that length of the prefix it has by that point
	 * represented as array
	 */
	private int[] buildKMPArray(String target) {
		int[] count = new int[target.length()];
		int j = 0;
		for(int i=1; i < target.length();) {
			if(target.charAt(i) == target.charAt(j)) {
				count[i++] = ++j;
			} else {
				if(j == 0) 
					count[i++] = 0;
				if(j > 0) j = count[j-1];
			}
		}
		return count;
	}
	
	public static void main (String[] args) {
		String target = "abcaby";
		String source = "abcabcbasdbcbabcabacbcyabcabxyancbacda";
		int c = new KMP().searchString(source,target);
		System.out.println(c);
		
		
//		System.out.println(b);
//		System.out.println(d);
	}
}
