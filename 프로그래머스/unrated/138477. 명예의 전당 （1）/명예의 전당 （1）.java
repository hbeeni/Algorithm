import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        //PriorityQueue: 명예의 전당
        PriorityQueue<Integer> queue = new PriorityQueue<>(); 
        
        /*
        for (i: score)
            if (queue 크기가 k보다 작으면)
                queue에 넣기
            else
                if (queue 첫번째 원소보다 현재 원소가 크면)
                    queue에 넣기
        queue의 첫번째 원소 answer에 넣기
         */
        for (int i = 0; i < score.length; i++) {
            if (queue.size() < k) {
                queue.add(score[i]);
            } else {
                if (queue.peek() < score[i]) {
                    queue.poll();
                    queue.add(score[i]);
                }
            }

            answer[i] = queue.peek();
        }
        
        return answer;
    }
}