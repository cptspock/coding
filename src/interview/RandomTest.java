package interview;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random r = new Random();
		System.out.println(r.nextInt(6) + 5);
		System.out.println(Math.max(1, 1));
		System.out.println(4321%100/10);
		
		String s = "abcde";
		System.out.println(s.substring(0,4));
	}

}
