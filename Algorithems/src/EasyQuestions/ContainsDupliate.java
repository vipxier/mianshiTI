package EasyQuestions;

import java.util.HashSet;
import java.util.Set;

public class ContainsDupliate {

	public static boolean containsDuplicate(int[] nums) {
		if(nums == null)
		{
			return false;
		}
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i : nums)
        {
            set.add(i);
        }
        
        if(nums.length > 0 && set.size() == nums.length)
        {
            return false;
        }
        return true;
    }
	
	
	public static void main(String[] args)
	{
		int[] nums = {};
		System.out.println(containsDuplicate(nums));
	}
}
