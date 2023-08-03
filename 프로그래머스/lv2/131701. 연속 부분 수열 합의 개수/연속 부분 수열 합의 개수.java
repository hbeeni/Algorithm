import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int length = elements.length;
        Set<Integer> set = new HashSet<>();
        int total = 0;
        
        for (int n : elements) {
            set.add(n);
            total += n;
        }
        set.add(total);

        int count = 2;
        while (count < length) {
            for (int i = 0; i < length; i++) {
                int index = i, sum = 0, temp = 0;
                
                while (temp < count) {
                    sum += elements[index++];
                    if (index == length) {
                        index = 0;
                    }
                    temp++;
                }
                
                set.add(sum);
            }
            
            count++;
        }
        
        return set.size();
    }
}