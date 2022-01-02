package solutions;

public class NeedleInHaystack {
	public int getNeedle(String haystack, String needle) {
		for (int i = 0; i < haystack.length(); i++) {
			int j = 0;
			if (haystack.charAt(i) == needle.charAt(j)) {
				int k = i + 1;
				for (j = 1; j < needle.length(); j++) {
					if (haystack.charAt(k++) == needle.charAt(j)) {
						continue;
					} else {
						return -1;
					}
					
				}
				return i;
			}
			
		}
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(new NeedleInHaystack().getNeedle("power", "pow"));
	}

}
