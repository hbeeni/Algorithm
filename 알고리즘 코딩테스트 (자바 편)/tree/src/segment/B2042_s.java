//알고리즘 코딩테스트 자바편

package segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2042_s {

    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //수의 개수
        int m = Integer.parseInt(st.nextToken()); //수의 변경이 일어나는 횟수
        int k = Integer.parseInt(st.nextToken()); //구간의 합을 구하는 횟수

        int treeHeight = 0;
        int length = n;

        while (length != 0) {
            length /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leftNodeStartIndex = treeSize / 2 - 1;
        tree = new long[treeSize + 1];

        //데이터를 리프노드에 입력받기
        for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize - 1); //tree 만들기

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());

            String a = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            if (a.equals("1")) {
                changeValue(leftNodeStartIndex + s, e);
            } else {
                s += leftNodeStartIndex;
                e += leftNodeStartIndex;
                System.out.println(getSum(s, (int) e));
            }
        }
    }

    //구간 합
    private static long getSum(int s, int e) {
        long sum = 0;
        while (s <= e) {
            if (s % 2 == 1) {
                sum += tree[s];
                s++;
            }
            if (e % 2 == 0) {
                sum += tree[e];
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return sum;
    }

    //값 변경
    private static void changeValue(int index, long value) {
        long diff = value - tree[index];
        while (index > 0) {
            tree[index] += diff;
            index /= 2;
        }
    }

    //초기 트리 구성
    private static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] += tree[i]; //부모노드로 이동: index / 2
            i--;
        }
    }
}
