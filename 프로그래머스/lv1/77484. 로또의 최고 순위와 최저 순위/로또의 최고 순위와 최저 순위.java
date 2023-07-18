class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int[] answer = new int[2];
        
        int count = 0;
        int zero = 0;
        
        for (int num : lottos) {
            if (num == 0) {
                zero++;
                continue;
            }
            
            for (int win : win_nums) {
                if (num == win) {
                    count++;
                    break;
                }
            }
        }
        
        answer[0] = rank[zero + count];
        answer[1] = rank[count];
        
        return answer;
    }
}