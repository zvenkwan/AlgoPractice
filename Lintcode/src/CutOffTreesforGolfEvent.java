import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;
/**
 * 
 * @author zg55
 *1092. Cut Off Trees for Golf Event
You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:

0 represents the obstacle can't be reached.
1 represents the ground can be walked through.
The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).
You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.

You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

Example
Input:
[
[1,2,3],
[0,0,4],
[7,6,5]
]
Output: 6

Input:
[
[1,2,3],
[0,0,0],
[7,6,5]
]
Output: -1

Input:
[
[2,3,4],
[0,0,5],
[8,7,6]
]
Output: 6
Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.

Notice
size of the given matrix will not exceed 50x50.
 */
public class CutOffTreesforGolfEvent {
    /**
     * @param forest: a list of integers
     * @return: return a integer
     */
     
    private static final int GRASS = 1;
    public int cutOffTree(List<List<Integer>> forest) {
        // write your code here
        if(forest == null || forest.isEmpty()) return 0;
        
        TreeMap<Integer, int[]> map = new TreeMap<Integer, int[]>();
        
        for(int i = 0; i < forest.size(); i++) {
            List<Integer> hs = forest.get(i);
            for(int j = 0 ; j < hs.size(); j++) {
                int key = hs.get(j);
                if(key > 1) {
                    map.put(key, new int[]{i, j});
                }
            }
        }
        
        if(map.isEmpty()) return 0;
        int[] start = {0, 0};
        int count = 0;
        for(Map.Entry<Integer, int[]> entry: map.entrySet()) {
            int[] dest = entry.getValue();
            int step = getToDest(forest, start, dest);
            if(step == -1) return -1;
            count += step;
            start = dest;
            forest.get(dest[0]).set(dest[1], GRASS);
        }
        return count;
    }
    int[] x = {0, 1, 0, -1};
    int[] y = {-1, 0, 1, 0};
    private int getToDest(List<List<Integer>> forest, int[] start, int[] dest) {
//    	return bfs(forest, start[0], start[1], dest[0], dest[1]);
        if((start[0] == dest[0]) && (start[1] == dest[1])) return 0;
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        
        LinkedList<int[]> queue = new LinkedList<int[]>();
        int step = 0;
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            step++;
            for(int i = 0; i < size; i++) {
                int[] curr = queue.poll();
//                if(curr[0] == dest[0] && curr[1] == dest[1]) return step;
                for(int j = 0 ; j < 4; j++) {
                    int[] next = {curr[0] + x[j], curr[1] + y[j]};
                    if(outbound(forest, next) || isObstacle(forest, next) || visited[next[0]][next[1]]) {
                        continue;
                    }
                    if(next[0] == dest[0] && next[1] == dest[1]) {
                    	return step;
                    }
                    queue.offer(next);
//                    set visited when add to queue, this is faster than set it when polled from queue
                    visited[next[0]][next[1]] = true;
                }
                
            }
            
        }
        
        return -1;
        
    }
    
    private boolean outbound(List<List<Integer>> forest, int[] next) {
        return next[0] < 0 || next[1] < 0 || next[0] >= forest.size() || next[1] >= forest.get(0).size();
    }
    
    private static final int OBSTACLE = 0;
    private boolean isObstacle(List<List<Integer>> forest, int[] next) {
        return forest.get(next[0]).get(next[1]) == OBSTACLE;
    }
    private boolean isGrass(List<List<Integer>> forest, int[] next) {
        return forest.get(next[0]).get(next[1]) == GRASS;
    }

    
//    @Test
//    public void test() {
//    	List<Integer> l1 = Arrays.asList(1,7,3);
//    	List<Integer> l2 = Arrays.asList(0,0,4);
//    	List<Integer> l3 = Arrays.asList(2,6,5);
//    	List<List<Integer>> forest = Arrays.asList(l1, l2, l3);
//    	int out = 6;
//    	Assert.assertEquals(cutOffTree(forest), out);
//    }
    @Test
    public void test1() {
		List<List<Integer>> forest = Arrays.asList(
				Arrays.asList(65373036,2456655,62996182,77165169,11057485,52535331,63698310,27129253,84289874),
			    Arrays.asList(18570009,29409292,57221123,27322139,5967050,25641409,59807085,41287955,67002016),
			Arrays.asList(59925393,84342153,95847740,96720219,95877289,6633239,96769252,68980562,99717888),
			Arrays.asList(38092644,69430191,46393504,75242757,38524238,92687163,72390599,86031769,97616262),
			Arrays.asList(63895259,13582559,38270398,10833444,47844868,78209342,89000764,505213,82251326),
			Arrays.asList(99638437,70547733,81264676,80087375,33825268,19488243,21385757,13931827,81384999),
			Arrays.asList(78687499,27054031,82935633,59857240,16454994,14764718,15186553,54119613,24432831),
			Arrays.asList(66192618,83872603,19246010,82241107,14604727,65304619,98680361,48033577,56249633),
			Arrays.asList(82869596,12875294,85175067,6220745,31624067,97537659,73504597,90040176,90033521)
				);

	int out = 496;
    	Assert.assertEquals(cutOffTree(forest), out);
    }
    @Test
    public void test2() {
    	List<List<Integer>> forest = 
    			Arrays.asList(Arrays.asList(69438,55243,0,43779,5241,93591,73380),Arrays.asList(847,49990,53242,21837,89404,63929,48214),Arrays.asList(90332,49751,0,3088,16374,70121,25385),Arrays.asList(14694,4338,87873,86281,5204,84169,5024),Arrays.asList(31711,47313,1885,28332,11646,42583,31460),Arrays.asList(59845,94855,29286,53221,9803,41305,60749),Arrays.asList(95077,50343,27947,92852,0,0,19731),Arrays.asList(86158,63553,56822,90251,0,23826,17478),Arrays.asList(60387,23279,78048,78835,5310,99720,0),Arrays.asList(74799,48845,60658,29773,96129,90443,14391),Arrays.asList(65448,63358,78089,93914,7931,68804,72633),Arrays.asList(93431,90868,55280,30860,59354,62083,47669),Arrays.asList(81064,93220,22386,22341,95485,20696,13436),Arrays.asList(50083,0,89399,43882,0,13593,27847),Arrays.asList(0,12256,33652,69301,73395,93440,0),Arrays.asList(42818,87197,81249,33936,7027,5744,64710),Arrays.asList(35843,0,99746,52442,17494,49407,63016),Arrays.asList(86042,44524,0,0,26787,97651,28572),Arrays.asList(54183,83466,96754,89861,84143,13413,72921),Arrays.asList(89405,52305,39907,27366,14603,0,14104),Arrays.asList(70909,61104,70236,30365,0,30944,98378),Arrays.asList(20124,87188,6515,98319,78146,99325,88919),Arrays.asList(89669,0,64218,85795,2449,48939,12869),Arrays.asList(93539,28909,90973,77642,0,72170,98359),Arrays.asList(88628,16422,80512,0,38651,50854,55768),Arrays.asList(13639,2889,74835,80416,26051,78859,25721),Arrays.asList(90182,23154,16586,0,27459,3272,84893),Arrays.asList(2480,33654,87321,93272,93079,0,38394),Arrays.asList(34676,72427,95024,12240,72012,0,57763),Arrays.asList(97957,56,83817,45472,0,24087,90245),Arrays.asList(32056,0,92049,21380,4980,38458,3490),Arrays.asList(21509,76628,0,90430,10113,76264,45840),Arrays.asList(97192,58807,74165,65921,45726,47265,56084),Arrays.asList(16276,27751,37985,47944,54895,80706,2372),Arrays.asList(28438,53073,0,67255,38416,63354,69262),Arrays.asList(23926,75497,91347,58436,73946,39565,10841),Arrays.asList(34372,69647,44093,62680,32424,69858,68719),Arrays.asList(24425,4014,94871,1031,99852,88692,31503),Arrays.asList(24475,12295,33326,37771,37883,74568,25163),Arrays.asList(0,18411,88185,60924,29028,69789,0),Arrays.asList(34697,75631,7636,16190,60178,39082,7052),Arrays.asList(24876,9570,53630,98605,22331,79320,88317),Arrays.asList(27204,89103,15221,91346,35428,94251,62745),Arrays.asList(26636,28759,12998,58412,38113,14678,0),Arrays.asList(80871,79706,45325,3861,12504,0,4872),Arrays.asList(79662,15626,995,80546,64775,0,68820),Arrays.asList(25160,82123,81706,21494,92958,33594,5243))
    			;
    	
    	int out = 5637;
    	Assert.assertEquals(out, cutOffTree(forest));
    }
}
