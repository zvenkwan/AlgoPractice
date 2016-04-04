package ArrayAndString;
/**
 * 278. First Bad Version
 * @author zg55
 *You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Company Tags Facebook
Hide Tags Binary Search
Hide Similar Problems (M) Search for a Range (M) Search Insert Position

 */
public class FirstBadVersion {
//	add another method with iteration
//    public int firstBadVersion(int n) {
//        int l=1,r=n;
//        while(l<r){
//            int mid=l+((r-l)>>1);
//            if (!isBadVersion(mid)) l = mid + 1;
//            else r = mid;   
//        }
//        return l;
//    }
    public int firstBadVersion(int n) {
        return firstBadVersion(1,n);
    }
    public int firstBadVersion(int s, int e) {
        if(s==e&&isBadVersion(e))
            return e;
        int half=(int)Math.floor((double) (e-s)/2)+s;
        if(isBadVersion(half))
            return firstBadVersion(s,half);
        else
            return firstBadVersion(half+1,e);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
	boolean isBadVersion(int version) {
		return version==3;
	}
}
