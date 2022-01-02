package solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random r = new Random();
		System.out.println(r.nextInt(6) + 5);
		System.out.println(Math.max(1, 1));
		System.out.println(4321%100/10);
		
		String s = "abcde";
		System.out.println(s.substring(0,4));
		
		List<String> nameList = new ArrayList<>();
		nameList.add("Tom");
		nameList.add("Mary");
		nameList.add("Jude");
		nameList.add("Roy");
		nameList.add("Paul");
		nameList.sort(Comparator.naturalOrder());
		for (String name : nameList) {
			System.out.println(name);
		}
		
	}

}
