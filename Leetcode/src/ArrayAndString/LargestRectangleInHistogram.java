package ArrayAndString;
/**
 * 84. Largest Rectangle in Histogram
 * @author zg55
 *Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
//    	stack approach O(n)
        if(heights==null||heights.length==0)
            return 0;
        int save[]=new int[heights.length];//used like a stack
        int s=-1;//s is used like pointer to save the position of the last element in stack save
        int sum=0;
        int i=0;
        while(i<=heights.length) {
            if(i==heights.length) {
                sum=Math.max(sum, heights[save[s--]]*(s<0?i:i-1-save[s]));
            if(s==-1) break;
                continue;
            }
            if(s<0||heights[i]>heights[save[s]]) {
                save[++s]=i++;
            } else {
                sum=Math.max(sum, heights[save[s--]]*(s<0?i:i-1-save[s]));
            }
        }
//        also can be implemented by divide and conquer
//        fisrt find the min bar(shortest)
//        a.then look for the left area
//        b.look for the right area
//        c.check number of bars*height of shortest
//        compare the above three values
//        this approach takes O(n logn )
        return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
