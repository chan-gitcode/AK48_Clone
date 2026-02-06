package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    class Solution {
        //nums   = [4, 6, 1, 9]
        //target = 10
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];

                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
                }

                map.put(nums[i], i);
            }

            // Just to satisfy compiler; problem guarantees a solution
            return new int[0];
        }
    }
}
