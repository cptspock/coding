package solutions;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * determine if a person could attend all meetings.
	
	https://www.lintcode.com/problem/920/description
	
	Example1:
		Input: intervals = [(0,30),(5,10),(15,20)]
		Output: false
		Explanation: 
		(0,30), (5,10) and (0,30),(15,20) will conflict
		
	Example2:
		Input: intervals = [(5,8),(9,15)]
		Output: true
		Explanation: 
		Two times will not conflict 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval {
	int start, end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class MeetingRooms {
	// O(nlogn) time || O(1) space
	public boolean canAttendMeetings(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return true;
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i + 1][0] < intervals[i][1]) {
				return false;
			}
		}
		return true;
	}

	// O(nlogn) time || O(1) space
	public boolean canAttendMeetings(
		List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0)
			return true;
		intervals.sort((a, b) -> a.start - b.start);
		for (int i = 0; i < intervals.size() - 1; i++) {
			if (intervals.get(i + 1).start < intervals
				.get(i).end) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] intervals = new int[][] { { 5, 10 },
			{ 0, 30 }, { 15, 20 } };
		System.out.println(new MeetingRooms()
			.canAttendMeetings(intervals));
		intervals = new int[][] { { 5, 10 }, { 20, 30 },
			{ 15, 20 } };
		System.out.println(new MeetingRooms()
			.canAttendMeetings(intervals));

		List<Interval> intervalList = new ArrayList<>();
		Interval int1 = new Interval(5, 17);
		Interval int2 = new Interval(15, 20);
		intervalList.add(int1);
		intervalList.add(int2);
		System.out.println(new MeetingRooms()
			.canAttendMeetings(intervalList));
	}

}
