package ArrayAndString;
import java.util.Arrays;
/**
 * 252. Meeting Rooms
 * @author zg55
 *Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.
 */
public class MeetingRooms {
	public boolean canAttendMeetings(Interval[] intervals) {
//		lambda expression
        Arrays.sort(intervals, (x, y) -> x.start - y.start);
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i-1].end > intervals[i].start)
                return false;
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval[] i = {
				new Interval(0, 30),
				new Interval(5, 10),
				new Interval(15, 20)
		};
		Interval.print(i);
		System.out.println(new MeetingRooms().canAttendMeetings(i));
	}

}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
	public static void print(Interval i) {
		System.out.println("["+i.start+", "+i.end+"]");
	}
	public static void print(Interval[] intervals) {
		for(Interval i : intervals) {
			print(i);
		}
	}
}