/**
 * 정렬되어 있지 않은 정수형 배열 nums의 원소를 가지고 만들 수 있는 가장 긴 연속된 숫자의 개수
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 *
 * input: nums = [100, 4, 200, 1, 3, 2]
 * output: 4 ([1, 2, 3, 4])
 *
 * input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
 * output: 9 ([0, 1, 2, 3, 4, 5, 6, 7, 8])
 */

package datastructure.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Integer[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int longest = 0;

        Set<Integer> set = new HashSet<Integer>(Arrays.asList(nums));
        for (Integer num : set) {
            int count = 1;
            int target = num + 1;

            if (!set.contains(num - 1)) {
                while (set.contains(target)) {
                    target++;
                    count++;
                }
            }

            longest = Math.max(longest, count);
        }

        System.out.println("longest = " + longest);
    }
}