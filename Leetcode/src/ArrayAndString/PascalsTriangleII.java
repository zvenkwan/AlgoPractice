package ArrayAndString;
import java.util.Arrays;
import java.util.List;
/**
 * 119. Pascal's Triangle II
 * @author zg55
 *Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {

	public List<Integer> getRow(int rowIndex) {
		Integer result[] = new Integer[rowIndex+1];
		Arrays.fill(result, 0);
		result[0]=1;
		for(int i=0;i<rowIndex+1;i++) {
			for(int j=i;j>=1;j--)
				result[j]=result[j]+result[j-1];
			result[rowIndex]=1;
		}
		return (List<Integer>) Arrays.asList(result);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PascalsTriangleII().getRow(3));
	}

}
