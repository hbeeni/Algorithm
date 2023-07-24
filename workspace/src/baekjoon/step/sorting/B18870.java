//https://st-lab.tistory.com/279

package baekjoon.step.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] origin = new int[n]; //원본 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] sorted = Arrays.stream(origin)
                .distinct()
                .sorted()
                .boxed()
                .toArray(Integer[]::new);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < sorted.length; i++) {
            map.put(sorted[i], i);
        }

        for (int num : origin) {
            bw.write(map.get(num) + " ");
        }

        bw.flush();
        bw.close();
    }
}
