package algorithm;

import java.util.Arrays;

/**
 * @author shanruiyu <shanruiyu@kuaishou.com>
 * Created on 2021-12-15
 */
public class Swap {
    public static void main(String[] args) {
        int[] nums = {1, 2 ,3, 4, 5, 6};
        System.out.println(Arrays.toString(nums));
        swap(nums, 0, 5);
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
