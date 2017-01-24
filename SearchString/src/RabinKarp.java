
public class RabinKarp implements SubString {

	@Override
	public int searchString(String source, String target) {
		// TODO Auto-generated method stub
		int mod = 100000;
        int power33 = 1;
        int hash_target = 0;
//        if terminal check i < m -1, we should increase candidate before decrement 
//        if check i < m, decrease before increment
        for(int i=0; i < target.length()-1; i++) {
            power33 = power33*33%mod;
            hash_target = (hash_target*33+target.charAt(i)) % mod;
        }
        hash_target = (hash_target*33+target.charAt( target.length()-1)) % mod;
        int candidate = 0;
//        do not check if i <= source.length()-target.length(), loop will end when i = 3
        for(int i=0; i < source.length();i++) {
            candidate = (candidate*33+source.charAt(i)) % mod;
            if(i >= target.length() - 1) {
            	if(candidate == hash_target && source.substring(i-target.length()+1, i+1).equals(target)) {
            		return i-target.length()+1;
            	}
                candidate = (candidate - source.charAt(i-target.length()+1)*power33) % mod;
                candidate = candidate < 0 ? (candidate+mod) : candidate;
            }
        }
        return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source = "tartarget";
		String target = "target";
//		RabinKarp r = new RabinKarp();
//		System.out.println(r.searchString(source, target));
		System.out.println(source.substring(3,9));
	}

}
