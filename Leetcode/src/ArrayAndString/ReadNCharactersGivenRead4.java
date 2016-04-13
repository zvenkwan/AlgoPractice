package ArrayAndString;
/**
 * 157. Read N Characters Given Read4
 * @author zg55
 *The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function will only be called once for each test case.

Hide Tags String
Hide Similar Problems (H) Read N Characters Given Read4 II - Call multiple times
	
 */
public class ReadNCharactersGivenRead4 {
	public int read(char[] buf, int n) {
        int total = 0;
        char toRead[] = new char[4];
        int c=0;
        while(true) {
            c = read4(toRead);
            int next = c<(n-total)?c:(n-total);
            for(int j=0;j<next;j++) {
                buf[total++]=toRead[j];
            }
            if(c<4)
                return total;
            if(total==n)
                return n;
        }
    }
	private int read4(char[] tmp) {
		// TODO Auto-generated method stub
		return tmp.length;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ReadNCharactersGivenRead4().read("a".toCharArray(),0);
	}

}
