package simple;

/**
 * @author TuoZhou
 * 26-删除有序数组中的重复项
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        // 1、双指针
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int fast = 1;
        int slow = 1;
        while (fast < length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
    }

}
