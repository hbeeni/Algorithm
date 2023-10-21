package algorithmcodingtest.tree.segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10868_s {

    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int treeHeight = 0;
        int length = n;

        while (length != 0) {
            length /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leftNodeStartIndex = treeSize / 2 - 1;

        //트리 초기화하기
        tree = new long[treeSize + 1];
        Arrays.fill(tree, Integer.MAX_VALUE);

        //데이터 입력받기
        for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize - 1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            s += leftNodeStartIndex;
            e += leftNodeStartIndex;
            System.out.println(getMin(s, e));
        }

        br.close();
    }

    //범위의 최솟값 구하기
    private static long getMin(int s, int e) {
        long min = Long.MAX_VALUE;
        while (s <= e) {
            if (s % 2 == 1) {
                min = Math.min(min, tree[s]);
                s++;
            }
            s /= 2;

            if (e % 2 == 0) {
                min = Math.min(min, tree[e]);
                e--;
            }
            e /= 2;
        }

        return min;
    }

    //초기 트리 생성
    private static void setTree(int i) {
        while (i != 1) {
            if (tree[i / 2] > tree[i]) {
                tree[i / 2] = tree[i];
            }
            i--;
        }
    }
}
