package interviews.amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author jguan
 *1562. Number of restaurants
Give a List of data representing the coordinates[x,y] of each restaurant and the customer is at the origin[0,0]. Find the n restaurants closest to the customer firstly. Then you need to pick n restaurants which appeare firstly in the List and the distance between the restaurant and the customer can't more than the longest distance in the n closest restaurants. Return their coordinates in the original order.

Example
Given : n = 2 , List = [[0,0],[1,1],[2,2]]
Return : [[0,0],[1,1]]
Given : n = 3,List = [[0,1],[1,2],[2,1],[1,0]]
Return :[[0,1],[1,2],[2,1]]
Notice
1.Coordinates in range [-1000,1000]
2.n>0
3.No same coordinates
 */
public class Numberofrestaurants {
    private int X = 0;
    private int Y = 1;
    public List<List<Integer>> nearestRestaurant(List<List<Integer>> restaurant, int n) {
        // Write your code here
        if (restaurant == null || restaurant.size() == 0 || n > restaurant.size()) {
            return null;
        }
        
        int furthestDistance = 0;
        int[] distances = new int[restaurant.size()];
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < distances.length; i++) {
            distances[i] = calculateDistance(restaurant.get(i));
        }
        
        Arrays.sort(distances);
        furthestDistance = distances[n - 1];

        for (int i = 0; i < distances.length; i++) {
            if(res.size() == n) break;
            if (calculateDistance(restaurant.get(i)) <= furthestDistance) {
                res.add(restaurant.get(i));
            }
        }
        
        return res;
    }

    private int calculateDistance (List<Integer> point) {
        return point.get(X) * point.get(X) + point.get(Y) * point.get(Y);
    }


}
