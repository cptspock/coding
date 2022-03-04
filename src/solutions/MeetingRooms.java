package solutions;

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
