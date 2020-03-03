
public class MinimumMove {
	public static int solution(String str)
	{
		if(str == null || str.length() == 0)
		{
			return 0;
		}
		
		int aCount = 0;
		int bCount  = 0;
		int changes = 0;
		
		for(int i = 0; i < str.length(); i ++)
		{
			if(str.charAt(i) == 'a')
			{
				aCount ++;
				bCount = 0;
			}
			else
			{
				bCount ++;
				aCount = 0;
			}
			
			if(aCount == 3 || bCount == 3)
			{
				changes ++;
				aCount = 0;
				bCount = 0;
			}
		}
		
		return changes;
	}
	
	public static void main(String[] args) {
	    String input1 = "baaaaa";
	    int res1 = 1;

	    String input2 = "baaabbaabbba";
	    int res2 = 2;

	    String input3 = "baabab";
	    int res3 = 0;

	    String input4 = "bbaaaaaabbab";
	    int res4 = 2;

	    MinimumMove minMoves = new MinimumMove();
	    System.out.println("expected " + res1 + " actual " + minMoves.solution(input1));
	    System.out.println("expected " + res2 + " actual " + minMoves.solution(input2));
	    System.out.println("expected " + res3 + " actual " + minMoves.solution(input3));
	    System.out.println("expected " + res4 + " actual " + minMoves.solution(input4));
	  }
}
