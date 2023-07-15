package baekjoon_step.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class B1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] a = new String[n];

        for (int i = 0; i < n; i++) {
            a[i] = br.readLine();
        }

        //Arrays.sort로 정렬 후 append 할 때 중복 제거
//        Arrays.sort(a, Comparator.comparing(String::length)
//                .thenComparing(String::compareTo));
//
//        sb.append(a[0]).append("\n");
//        for (int i = 1; i < n; i++) {
//            if (!a[i].equals(a[i - 1])) {
//                sb.append(a[i]).append("\n");
//            }
//        }

        List<String> list = Arrays.stream(a)
                            .distinct()
                            .sorted(Comparator.comparing(String::length)
                                    .thenComparing(String::compareTo))
                            .collect(Collectors.toList());

        list.forEach(s -> sb.append(s).append("\n"));
        System.out.println(sb);
    }
}