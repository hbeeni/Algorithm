//Do it! 코딩 테스트 - 자바 편 173p

package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_s {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //상하좌우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int[][] maze = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == '1') {
                    maze[i][j] = 1;
                }
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = currentNode.x + dx[i];
                int y = currentNode.y + dy[i];

                if (x >= 0 && y >= 0 && x < n && y < m) { //좌표 유효성 검사
                    if (!visited[x][y] && maze[x][y] != 0) { //갈 수 있는 칸인지 검사
                        visited[x][y] = true;
                        maze[x][y] = maze[currentNode.x][currentNode.y] + 1; //깊이 업데이트
                        queue.offer(new Node(x, y));
                    }
                }
            }
        }

        System.out.println(maze[n - 1][m - 1]);
    }
}
