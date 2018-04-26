/**
 * 
 * @author jguan
 *Given a big sorted array with positive integers sorted by ascending order. The array is so big so that you can not get the length of the whole array directly, and you can only access the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++). Find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of the target number.

Return -1, if the number doesn't exist in the array.
 */
class ArrayReader {
    // get the number at index, return -1 if index is less than zero.
	public int get(int index) {
		return 0;
	}
}
public class SearchInaBigSortedArray {
	public int searchBigSortedArray(ArrayReader reader, int target) {
		int e = 1;
		while(target > reader.get(e - 1)) {
			e *= 2;
		}
		int s = 0;
		while(s + 1 < e) {
			int m = s + (e-s)/2;
			if(reader.get(m) == target) {
				return m;
			} else if (reader.get(m) < target) {
				s = m;
			} else {
				e = m;
			}
		}
		if(reader.get(s) == target) return s;
		else return e;
	}
}
