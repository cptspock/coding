/**
 * https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
 * https://www.youtube.com/watch?v=iplciPpgL2A&t=19s
 */
package solutions;


class MinimumNumberOfSwaps{
    
    public static int minimumSwap(String s1, String s2) 
    {
      int xy_count = 0,//count of {x,y} pairs
      yx_count = 0,//count of {y,x} pairs
      n = s1.length();
      for(int i = 0; i < n; i++)
      {
          if (s1.charAt(i) != s2.charAt(i))
          {
              if (s1.charAt(i) == 'x') xy_count++;
              else yx_count++;
          }
      }
      //if parity of count of xy pair and yx pair is same 
      /*if (xy_count % 2 == yx_count % 2) 
    	  return (xy_count + yx_count) / 2 + ((xy_count % 2 == 1) ? 1 : 0);
      else return -1; */
      if (((xy_count + yx_count) % 2) == 1) {
    	  return -1;
      }
      return xy_count / 2 + yx_count / 2 + xy_count % 2 + yx_count % 2;
  }
  
  public static void main(String args[])
  {
       String s1="xyxyxy",s2="yxyxyx";
      System.out.println(minimumSwap(s1,s2) );
  }
}