package ArrayAndString;
/**
 * 11. Container With Most Water
 * @author guanziwen
 *Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 *Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *Note: You may not slant the container.
 */
public class ContainerWithMostWater {

//	compare all the cases will cost O(n^2)
	public int maxArea(int[] height) {
		if(height==null||height.length<2)
			return 0;
		int max = 0;
		int i=0;
		int j=height.length-1;
		while(i<j) {
        	int area = height[i]<height[j]?height[i]*(j-i):height[j]*(j-i);
        	if(max<area)
        		max=area;
        	if(height[i]<height[j])
        		i++;
        	else
        		j--;
        }
        return max;
    }
	public static void main(String[] args) {
		int[] height= {5,2,3,4,5};
		System.out.println(new ContainerWithMostWater().maxArea(height));
	}

}
