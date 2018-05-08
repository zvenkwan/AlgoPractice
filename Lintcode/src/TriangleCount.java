import java.util.Arrays;
/**
 * 
 * @author jguan
 *Given an array of integers, how many three numbers can be found in the array, 
 *so that we can build an triangle whose three edges length is the three numbers that we find?
 *
 *assume there is no duplicate in the array
 */
public class TriangleCount {

	public int triangleCount(int[] edges) {
		if(edges == null || edges.length < 3) return 0;
		int count = 0;
		Arrays.sort(edges);
		int s = 0;
		int e = edges.length - 1;
		for(int i = edges.length - 1; i >= 0; i--) {
			while(s < e) {
				int sum = edges[s] + edges[e];
				if(sum > edges[i]) {
					count = count + e - s;
					e--;
				} else {
					s++;
				}
			}
		}
		
		return count;
		
	}

}
