import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        boolean[][] visited = new boolean[n][m];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == n - 1 && node.y == m - 1) {
                return maps[node.x][node.y];
            }

            for (int i = 0; i < 4; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];

                if (x >= 0 && x < n && y >= 0 && y < m && maps[x][y] != 0) {
                    if (!visited[x][y] && maps[x][y] == 1) {
                        maps[x][y] = maps[node.x][node.y] + 1;
                        queue.add(new Node(x, y));
                        visited[x][y] = true;
                    }
                }
            }
        }

        return -1;
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}