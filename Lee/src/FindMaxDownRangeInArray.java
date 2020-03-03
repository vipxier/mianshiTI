import java.util.ArrayList;
import java.util.List;

import utils.ArrayUtils;

public class FindMaxDownRangeInArray {
    public static void findDownRange(int[] nums) {
        int start = 0, maxRangeStart = 0, maxLength = 0;
        boolean findStart = false;
    
        for (int i = 1; i < nums.length - 1; i++) {
            //如果是波峰则确定 start
            if (nums[i - 1] <= nums[i] && nums[i + 1] < nums[i]) {
                if (!findStart) {
                    start = i;
                    findStart = true;
                }
            }
            // 如果是波谷，则开始计算最长数组 
            else if (nums[i - 1] > nums[i] && nums[i + 1] >= nums[i]) {
                //如果新的range长度大于已有rangge
                if (findStart && maxLength < i - start + 1) {
                    maxRangeStart = Math.max(maxRangeStart, start);
                    if (maxRangeStart > 0) {
                        maxLength = i - maxRangeStart + 1;
                    } else {
                        maxLength = i - maxRangeStart;
                    }
                //如果新的range长度小于已有range
                } else {
                    start = i + 1;
                }
                findStart = false;
            }
        }
        ArrayUtils.printRangeInArray(nums, maxRangeStart, maxLength);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 4, 3, 2, 1,0, -1, 1, 7, 8, 7, 6, 4, 3, 2, 2, 1, 1 };
        findDownRange(nums);
    } 
}