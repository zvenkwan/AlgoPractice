package ArrayAndString;
/**
 * 6. ZigZag Conversion
 * @author zg55
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
Hide Tags String

 *n=numRows
жд=2n-2    1                           2n-1                         4n-3
жд=        2                     2n-2  2n                    4n-4   4n-2
жд=        3               2n-3        2n+1              4n-5       .
жд=        .           .               .               .            .
жд=        .       n+2                 .           3n               .
жд=        n-1 n+1                     3n-3    3n-1                 5n-5
жд=2n-2    n                           3n-2                         5n-4
that's the zigzag pattern the question asked! Be careful with nR=1 && nR=2
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        int gap = 2*numRows-2;
        char result[] = new char[s.length()];
        for(int i=0,k=0;i<numRows;i++) {
            for(int j=i;j<s.length();j=gap+j) {
                result[k++]=s.charAt(j);
//                extra char between two || except first and last row
                if(i>0 && i<numRows-1&& j+gap-2*i<s.length())
                    result[k++]=s.charAt(j+gap-2*i);
            }
        }
        return new String(result);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ABC";
		System.out.println(new ZigZagConversion().convert(s,2));
	}

}
