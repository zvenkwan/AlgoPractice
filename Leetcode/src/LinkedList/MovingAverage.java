package LinkedList;

import java.util.LinkedList;

/**
 * leetcode 346. Moving Average from Data Stream
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 Google
Hide Tags Design Queue

 * @author zg55
 *
 */
public class MovingAverage {
    private LinkedList<Integer> que;
    private double sum;
    private int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        if(que == null) que = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        if(que.size() == this.size) {
            sum-=que.poll();
        }
        sum+=val;
        que.add(val);
        return sum/que.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
