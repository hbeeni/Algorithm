class Solution {
    public int[] solution(int n) {
        int[][] a = new int[n + 1][];
        for (int i = 1; i <= n; i++) {
            a[i] = new int[i + 1];
        }

        int x = 1, y = 1, tmp = n, num = 1;
        while (tmp > 0) {
            num = drawTriangle(a, x, y, tmp, num);
            x += 2;
            y++;
            tmp -= 3;
        }

        int[] answer = new int[num - 1];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < a[i].length; j++) {
                answer[index++] = a[i][j];
            }
        }
        return answer;
    }

    public int drawTriangle(int[][] a, int x, int y, int n, int num) {
        for (int i = 1; i < n; i++) {
            a[x++][y] = num++;
        }
        for (int i = 1; i <= n; i++) {
            a[x][y++] = num++;
        }
        x--;
        y -= 2;
        for (int i = 1; i < n - 1; i++) {
            a[x--][y--] = num++;
        }

        return num;
    }
}