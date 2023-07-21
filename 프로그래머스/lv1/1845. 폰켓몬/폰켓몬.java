import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> pokemon = new HashSet<>();
        
        for (int num : nums) {
            pokemon.add(num);
        }
        
        return Math.min(pokemon.size(), nums.length / 2);
    }
}