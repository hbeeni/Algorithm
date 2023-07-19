import java.util.*;

class Solution {
    static class Stage {
        int stage;
        float failureRate;
        
        public Stage(int stage, float failureRate) {
            this.stage = stage;
            this.failureRate = failureRate;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] fail = new int[N + 1];
        int[] sum = new int[N + 1];
        int[] arrival = new int[N + 1];
        
        Arrays.sort(stages);
        
        for (int stage : stages) {
            if (stage <= N) {
                fail[stage]++;
            }
        }
        
        for (int i = 1; i <= N; i++) {
            sum[i] += sum[i - 1] + fail[i];
        }
        
        arrival[1] = stages.length;
        for (int i = 2; i <= N; i++) {
            arrival[i] = stages.length - sum[i - 1];
        }
        
        Stage[] a = new Stage[N];
        for (int i = 0; i < N; i++) {
            a[i] = new Stage(i + 1, (float) (fail[i + 1]) / arrival[i + 1]);
        }
        
        Arrays.sort(a, (s1, s2) -> {
           if (s2.failureRate - s1.failureRate > 0) {
               return 1;
           } else if (s2.failureRate - s1.failureRate < 0) {
               return -1;
           } else {
               return s1.stage - s2.stage;
           }
        });
        
        for (int i = 0; i < N; i++) {
            answer[i] = a[i].stage;
        }
        
        return answer;
    }
}