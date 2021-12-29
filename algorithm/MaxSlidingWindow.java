package algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shanruiyu <shanruiyu@kuaishou.com>
 * Created on 2021-12-28
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {7, 2, 4};
        int k = 2;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
        System.out.println("[3, 3, 5, 5, 6, 7]");
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] res = new int[n - k + 1];
        res[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }
}
