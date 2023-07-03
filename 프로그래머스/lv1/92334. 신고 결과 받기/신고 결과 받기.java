import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int l = id_list.length;
        int[] a = new int[l];
        boolean[][] reported = new boolean[l][l];
        
        for (int i = 0; i < report.length; i++) {
            String[] tmp = report[i].split(" ");
            
            for (int from = 0; from < l; from++) {
                if (tmp[0].equals(id_list[from])) {
                    for (int to = 0; to < l; to++) {
                        if (tmp[1].equals(id_list[to])) {
                            reported[from][to] = true;
                        }
                    }
                }
            }
        }
        
        int[] count = new int[l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (reported[i][j]) {
                    count[j]++;
                }
            }
        }
        
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (reported[i][j] && count[j] >= k) {
                    a[i]++;
                }
            }
        }
        
        return a;
    }
}