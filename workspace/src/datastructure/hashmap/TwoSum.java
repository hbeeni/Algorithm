//nums의 두 수를 합해서 target이 나오는지 boolean 반환

package datastructure.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    static boolean twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(num -> map.put(num, num));

        for (Integer i : map.keySet()) {
            if (i + i == target) {
                continue;
            }
            if (map.containsKey(target - i)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 9, 7, 8, 2};
        int target = 14;

        System.out.println(twoSum(nums, target));
        System.out.println(twoSum(new int[] {4, 1, 9, 7, 8, 5, 2}, target));
    }
}
