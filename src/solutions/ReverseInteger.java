package solutions;

public class ReverseInteger {
	public int reverseInt(int x) {
        if (x == Integer.MIN_VALUE) return 0; // check if exactly equal to -2**31 since the positive of this which 
        									  // is 2**31 will not be able to be held in 'int' type
        int reverse = 0;
        if (x < 0) return -reverseInt(-x); 
        while (x != 0) {
        	if (reverse > Integer.MAX_VALUE/10) return 0; 
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return reverse;
    }
	
	public static void main(String[] args) {
		System.out.print(new ReverseInteger().reverseInt(2147483641));
	}
}
