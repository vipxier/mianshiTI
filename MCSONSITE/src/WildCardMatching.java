
public class WildCardMatching {
	 public boolean isMatch(String s, String p) {
	        if(s == null || p == null || s.length() == 0 || p.length() == 0)
	        {
	            return false;
	        }
	        
	        boolean[][] visited = new boolean[s.length()][p.length()];
	        boolean[][] result = new boolean[s.length()][p,length()];
	        
	        return isMatch(visited, result, s, 0, p, 0)
	    }
	    
	    private boolean isMatch(boolean[][] visited, boolean[][] result, String s, int sIndex, String p, int pIndex)
	    {
	        if(sIndex == s.length())
	        {
	            return allStars(p, pIndex);
	        }
	        
	        if(pIndex == p.length())
	        {
	            return sIndex == s.length();
	        }
	    }
}
