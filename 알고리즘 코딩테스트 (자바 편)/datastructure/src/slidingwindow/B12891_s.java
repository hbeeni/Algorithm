package slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891_s {
    static int[] n; //비밀번호 최소 개수 배열
    static int[] check; //현재 상태 체크 배열
    static int count; //몇 개의 문자와 관련된 개수를 충족했는지 판단

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int result = 0;
        n = new int[4];
        check = new int[4];
        count = 0;

        char[] dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            n[i] = Integer.parseInt(st.nextToken());

            if (n[i] == 0) {
                count++;
            }
        }

        for (int i = 0; i < p; i++) {
            add(dna[i]);
        }
        if (count == 4) {
            result++;
        }

        //슬라이딩 윈도우 처리
        for (int end = p; end < s; end++) {
            int start = end - p;
            remove(dna[start]);
            add(dna[end]);

            if (count == 4) {
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }

    private static void add(char c) { //새로 들어온 문자 처리
        switch (c) {
            case 'A':
                check[0]++;
                if (n[0] == check[0]) {
                    count++;
                }
                break;
            case 'C':
                check[1]++;
                if (n[1] == check[1]) {
                    count++;
                }
                break;
            case 'G':
                check[2]++;
                if (n[2] == check[2]) {
                    count++;
                }
                break;
            case 'T':
                check[3]++;
                if (n[3] == check[3]) {
                    count++;
                }
                break;
        }
    }

    private static void remove(char c) { //제거되는 문자 처리
        switch (c) {
            case 'A':
                if (n[0] == check[0]) {
                    count--;
                }
                check[0]--;
                break;
            case 'C':
                if (n[1] == check[1]) {
                    count--;
                }
                check[1]--;
                break;
            case 'G':
                if (n[2] == check[2]) {
                    count--;
                }
                check[2]--;
                break;
            case 'T':
                if (n[3] == check[3]) {
                    count--;
                }
                check[3]--;
                break;
        }
    }
}