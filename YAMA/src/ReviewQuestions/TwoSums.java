package ReviewQuestions;

import java.util.HashMap;

public class TwoSums {
	 public int[] twoSum(int[] nums, int target) {
		 int[] result = new int[] {-1, -1};
		 if(nums == null ||nums.length == 0)
		 {
			 return result;
		 }
		 
		 HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		 
		 for(int i = 0; i< nums.length; i ++)
		 {
			 if(hashMap.containsKey(nums[i]))
			 {
				 result[0] = i;
				 result[1] = hashMap.get(nums[i]);
			 }
			 else
			 {
				 hashMap.put(target - nums[i], i);
			 }
		 }
		 
		 return result;
	 }
}
