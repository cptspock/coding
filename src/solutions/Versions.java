package solutions;

public class Versions {
	public int solution(String S, String T) {
	        
	  String[] versions_S = S.split("[.]");
	  String[] versions_T = T.split("[.]");
	  
	  int maxLength = Math.max(versions_S.length, versions_T.length);
	  for (int i = 0; i < maxLength; i++) {
	      int num1 = (i < versions_S.length) ? Integer.parseInt(versions_S[i]) : 0;
	      int num2 = (i < versions_T.length) ? Integer.parseInt(versions_T[i]) : 0;
	      if (num1 < num2) return -1;
	      else if (num1 > num2) return 1;
	  }
	  return 0;
	}

public static void main(String[] args) {
  System.out.print(new Versions().solution("1.0.0", "1"));
}
}