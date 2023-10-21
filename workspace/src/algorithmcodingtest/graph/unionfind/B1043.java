//오답 - 테스트 케이스는 다 통과

package algorithmcodingtest.graph.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1043 {

    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int peopleNum = Integer.parseInt(st.nextToken());
        int partiesNum = Integer.parseInt(st.nextToken());

        a = new int[peopleNum + 1];
        boolean[] knowTruth = new boolean[peopleNum + 1];
        ArrayList<Integer>[] parties = new ArrayList[partiesNum + 1];

        for (int i = 1; i <= peopleNum; i++) {
            a[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int truth = Integer.parseInt(st.nextToken());
        for (int i = 0; i < truth; i++) {
            knowTruth[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 1; i <= partiesNum; i++) {
            parties[i] = new ArrayList<>();
        }

        for (int i = 1; i <= partiesNum; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                parties[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= partiesNum; i++) {
            if (parties[i].size() > 1) {
                int x = parties[i].get(0);

                for (int j = 1; j < parties[i].size(); j++) {
                    int y = parties[i].get(j);

                    if (knowTruth[x]) {
                        union(x, y);
                    } else if (knowTruth[y]) {
                        union(y, x);
                    } else {
                        union(x, y);
                    }

                    x = y;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= partiesNum; i++) {
            boolean possible = true;

            for (int j = 0; j < parties[i].size(); j++) {
                int person = find(parties[i].get(j));

                if (knowTruth[person]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                count++;
            }
        }

        System.out.println(count);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            a[y] = x;
        }
    }

    static int find(int x) {
        if (a[x] == x) {
            return x;
        }
        return a[x] = find(a[x]);
    }
}
