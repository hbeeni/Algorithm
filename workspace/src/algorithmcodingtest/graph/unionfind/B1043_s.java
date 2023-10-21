package algorithmcodingtest.graph.unionfind;

import java.util.ArrayList;
import java.util.Scanner;

public class B1043_s {

    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();

        //진실을 아는 사람 저장
        int[] knowTruth = new int[t];
        for (int i = 0; i < t; i++) {
            knowTruth[i] = sc.nextInt();
        }

        //파티 데이터 저장
        ArrayList<Integer>[] party = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
            int partySize = sc.nextInt();

            for (int j = 0; j < partySize; j++) {
                party[i].add(sc.nextInt());
            }
        }

        //대표 노드를 자기 자신으로 초기화
        a = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = i;
        }

        //각 파티에 참여한 사람들을 1개의 그룹으로 만들기
        for (int i = 0; i < m; i++) {
            int firstPeople = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(firstPeople, party[i].get(j));
            }
        }

        //각 파티의 대표 노드와 진실을 아는 사람들의 대표 노드가 같다면 과장 X
        int result = 0;
        for (int i = 0; i < m; i++) {
            boolean isPossible = true;
            int x = party[i].get(0);

            for (int k : knowTruth) {
                if (find(x) == find(k)) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                result++;
            }
        }

        System.out.println(result);
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
        } else {
            return a[x] = find(a[x]);
        }
    }
}
