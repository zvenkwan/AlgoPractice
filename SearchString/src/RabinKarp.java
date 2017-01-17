
public class RabinKarp implements SubString {

	@Override
	public int searchString(String source, String target) {
		// TODO Auto-generated method stub
		if(source == null || target == null) return -1;
		if(target.length() > source.length()) return -1;
		if(target.length() == 0) return 0;
		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
