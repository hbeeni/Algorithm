//277p

package algorithmcodingtest.graph.expression;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2251_s {
    /*
    sender, receiver: 6가지 경우: A->B, A->C, B->A, B->C, C->A, C->B
    visited: 방문 체크 배열 - [A 부피][B 부피]
    answer: 정답 배열 - [C 부피]
    volume: A, B, C 부피 저장 배열
     */
    static int[] sender = {0, 0, 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited = new boolean[201][201]; //A, B만 있으면 C 고정 -> 2개만 체크
    static boolean[] answer = new boolean[201];
    static int[] volume = new int[3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        volume[0] = sc.nextInt();
        volume[1] = sc.nextInt();
        volume[2] = sc.nextInt();

        //bfs() 수행
        bfs();

        /*
        for (i: 0 ~ answer 길이)
            answer 배열에서 true면 index 출력
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static void bfs() {
        //큐에 출발 노드 더하기 -> A, B 0이므로 0, 0 노드에서 시작
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));

        //visited 배열에 방문 체크
        visited[0][0] = true;

        //answer 배열에 현재 C 값 체크
        answer[volume[2]] = true;

        /*
        while (큐가 빌 때까지)
            큐에서 노드 데이터 가져오기
            데이터 이용해 A, B, C 초기화
            for (6가지 케이스)
                받는 물통에 보내려는 물통 값 더하기
                보내려는 물통 값 0으로 업데이트
                if (받는 물통 넘치면)
                    넘치는 만큼 보내는 물통에 다시 넣고, 받는 물통은 물통 용량 최댓값으로
                현재 노드의 연결 노드 중 방문하지 않은 노드로
                큐에 데이터 삽입하고, 방문 체크
                if (A가 비어 있을 때)
                    C 양을 answer에 기록
         */
        while (!queue.isEmpty()) {
            AB node = queue.poll();
            int A = node.A;
            int B = node.B;
            int C = volume[2] - A - B;

            for (int i = 0; i < 6; i++) {
                int[] next = {A, B, C};
                int from = sender[i];
                int to = receiver[i];

                next[to] += next[from];
                next[from] = 0;

                if (next[to] > volume[to]) { //받는 물통 넘치면
                    //초과하는 만큼 이전 물통에
                    next[from] = next[to] - volume[to];
                    next[to] = volume[to];
                }

                if (!visited[next[0]][next[1]]) { //A, B 이용해 방문 체크
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));

                    //A가 비어있으면 C 저장
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

    //AB 클래스: A, B만 알면 C는 유추 가능
    static class AB {
        int A;
        int B;

        public AB(int a, int b) {
            A = a;
            B = b;
        }
    }
}
