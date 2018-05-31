import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 22. Flatten List
Description
Given a list, each element in the list can be a list or integer. flatten it into a simply list with integers.

If the element in the given list is a list, it can contain list too.

Have you met this question in a real interview?  
Example
Given [1,2,[1,2]], return [1,2,1,2].

Given [4,[3,[2,[1]]]], return [4,3,2,1].

Challenge
Do it in non-recursive.
 */
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class FlattenList {

	// @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        for (NestedInteger ele : nestedList)
            if (ele.isInteger())
                result.add(ele.getInteger());
            else
                result.addAll(flatten(ele.getList()));
        return result;
    }
}
