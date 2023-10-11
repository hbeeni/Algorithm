package segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11505_s {

    static long[] tree;
    static int mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        int length = n;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }

        int size = (int) Math.pow(2, treeHeight + 1);
        int leftNodeStartIndex = size / 2 - 1;
        tree = new long[size + 1];

        Arrays.fill(tree, 1);
        for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + n; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }
        setTree(size - 1);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (a == 1) {
                changeVal(leftNodeStartIndex + s, e);
            } else {
                s += leftNodeStartIndex;
                e += leftNodeStartIndex;
                System.out.println(getMul(s, e));
            }
        }

        br.close();
    }

    private static long getMul(int s, int e) {
        long answer = 1;
        while (s <= e) {
            if (s % 2 == 1) {
                answer = answer * tree[s] % mod;
                s++;
            }
            if (e % 2 == 0) {
                answer = answer * tree[e] % mod;
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return answer;
    }

    private static void changeVal(int index, int value) {
        tree[index] = value;
        while (index > 1) {
            index /= 2;
            tree[index] = (tree[2 * index] * tree[2 * index + 1]) % mod;
        }
    }

    private static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] = tree[i / 2] * tree[i] % mod;
            i--;
        }
    }
}
