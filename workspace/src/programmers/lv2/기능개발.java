//https://mundol-colynn.tistory.com/126

package programmers.lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
    public static List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        //최소 일수 계산해서 queue에 넣기
        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        while (!queue.isEmpty()) {
            int minDays = queue.poll(); //최소 일수
            int count = 1;

            while (!queue.isEmpty() && queue.peek() <= minDays) {
                queue.poll();
                count++;
            }

            answer.add(count);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})); //2, 1
        System.out.println(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})); //1, 3, 2
    }
}
