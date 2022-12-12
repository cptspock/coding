package solutions;

public class NumberComplement {

	public int findComplement(int num) {
		if (num == 0)
			return 1;
		int temp = num;
		int bit = 1;
		while (temp != 0) {
			num = num ^ bit;
			bit = bit << 1;
			temp = temp >> 1;
		}
		return num;

	}

	public static void main(String[] args) {
		System.out.println(
			new NumberComplement().findComplement(5));

	}

}
