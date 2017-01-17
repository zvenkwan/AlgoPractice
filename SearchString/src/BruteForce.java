
public class BruteForce implements SubString{
	public int searchString(String source, String target) {
		if(source == null || target == null) return -1;
		if(target.length() > source.length()) return -1;
		if(target.length() == 0) return 0;
		//starting from the first char, check for the chars of next target length, return current index if matches
		//otherwise start again from next char of source
		//considering length of source is n and length of target is m, time complexity is O(m*n)
		for(int i=0; i<=source.length()-target.length();i++) {
			int j=0;
			if(source.charAt(j) == target.charAt(i+j)) {
				j++;
				if(j == target.length()) return i;
			}
		}
		return -1;
	}
}
