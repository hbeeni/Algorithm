import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1 ,2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] count = new int[3];
        int[] index = new int[3];
        
        for (int answer : answers) {
            if (first[index[0]++] == answer) count[0]++;
            if (second[index[1]++] == answer) count[1]++;
            if (third[index[2]++] == answer) count[2]++;
            
            if (index[0] == first.length) index[0] = 0;
            if (index[1] == second.length) index[1] = 0;
            if (index[2] == third.length) index[2] = 0;
        }
        
        int max = Math.max(Math.max(count[0], count[1]), count[2]);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (count[i] == max) {
                list.add(i + 1);
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}