
public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("11", "1"));
	}

	public static String addBinary(String a, String b) {
        // Write your code here
        if(a == null || b == null) return null;
        int x = a.length() - 1;
        int y = b.length() - 1;
        char carry = '0';
        StringBuilder sb = new StringBuilder();
        while(x >= 0 || y >= 0) {
            char xx = x >= 0? a.charAt(x) : '0';
            char yy = y >= 0? b.charAt(y) : '0';
            char xy = '0';
            char nextCarry = '0';
            if( xx != yy ) {
                xy = '1';
            } else if( xx == yy && xx == '1') {
                nextCarry = '1';
//            } else {
//                nextCarry = '0';
            }
            
            if( xy != carry ) {
                xy = '1';
            } else if( xy == carry && xy == '1') {
            	xy = '0';
            	nextCarry = '1';
//            } else {
//            	nextCarry = '0';
            }
            
            carry = nextCarry;
//            System.out.println(carry);
            sb.append(xy);
            x--;
            y--;
        }
        if(carry == '1') sb.append(carry);
        return sb.reverse().toString();
    }
}
