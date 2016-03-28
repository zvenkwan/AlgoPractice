package ArrayAndString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 118. Pascal's Triangle
 * @author zg55
 *Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> first = Arrays.asList(1);
        list.add(first);
        if(numRows==1) {
            return list;
        }
        List<Integer> second = Arrays.asList(1,1);
        list.add(second);
        if(numRows==2) {
            return list;
        }
        for(int i=2;i<numRows;i++) {
            List<Integer> innerList = new ArrayList<Integer>();
            innerList.add(0, 1);
            innerList.add(i, 1);
            for(int j=1;j<i/2+1;j++) {
                innerList.add(j, list.get(i-1).get(j)+list.get(i-1).get(j-1));
                if(i%2!=0)
                    innerList.add(i-j, list.get(i-1).get(j)+list.get(i-1).get(j-1));
            }
            list.add(innerList);
        }
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
