package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1991_s {

    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new int[26][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            //자식 노드가 없을 때 -1 저장
            tree[node][0] = left == '.' ? -1 : left - 'A';
            tree[node][1] = right == '.' ? -1 : right - 'A';
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }

    private static void preOrder(int now) {
        if (now == -1) {
            return;
        }
        System.out.print((char) (now + 'A')); //1. 현재노드
        preOrder(tree[now][0]); //2. 왼쪽 담색
        preOrder(tree[now][1]); //3. 오른쪽 탐색
    }

    private static void inOrder(int now) {
        if (now == -1) {
            return;
        }
        inOrder(tree[now][0]); //1. 왼쪽 담색
        System.out.print((char) (now + 'A')); //2. 현재노드
        inOrder(tree[now][1]); //3. 오른쪽 탐색
    }

    private static void postOrder(int now) {
        if (now == -1) {
            return;
        }
        postOrder(tree[now][0]); //1. 왼쪽 담색
        postOrder(tree[now][1]); //2. 오른쪽 탐색
        System.out.print((char) (now + 'A')); //3. 현재노드
    }
}
