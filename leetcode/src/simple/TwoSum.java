package simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author TuoZhou
 * 1-两数之和
 */
class TwoSum {

    public static int[] twoNum(int[] nums, int target) {
        int[] result = new int[2];

        // 1、暴力循环
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             result[0] = i;
        //             result[1] = j;
        //             break;
        //         }
        //     }
        // }
        // return result;

        // 2、
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }
            map.put(target - nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] result = twoNum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}