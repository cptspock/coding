package solutions;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

	https://www.lintcode.com/problem/642/
	Example 1:

	MovingAverage m = new MovingAverage(3);
	m.next(1) = 1 // return 1.00000
	m.next(10) = (1 + 10) / 2 // return 5.50000
	m.next(3) = (1 + 10 + 3) / 3 // return 4.66667
	m.next(5) = (10 + 3 + 5) / 3 // return 6.00000
 */

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
	private Queue<Integer> queue;
	private int maxSize;
	private double sum;

	public MovingAverage(int size) {
		this.maxSize = size;
		this.queue = new LinkedList<>();
		this.sum = 0.0;
	}

	public double next(int val) {
		if (queue.size() == maxSize) {
			sum -= queue.remove();
		}
		queue.add(val);
		sum += val;
		return sum / queue.size();

	}

	public static void main(String[] args) {
		MovingAverage ma = new MovingAverage(3);
		System.out.println(ma.next(1));
		System.out.println(ma.next(10));
		System.out.println(ma.next(3));
		System.out.println(ma.next(5));

	}

}
