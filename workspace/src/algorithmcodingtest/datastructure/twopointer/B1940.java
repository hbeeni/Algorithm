package algorithmcodingtest.datastructure.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        Map<Integer, Integer> list = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.put(num, list.getOrDefault(num, 0) + 1);
        }

        int result = 0;

        for (Integer num : list.keySet()) {
            if (2 * num != m && list.containsKey(m - num)) {
                result += list.get(num) * list.get(m - num);
                list.put(num, 0);
                list.put(m - num, 0);
            }
        }

        System.out.println(result);
    }
}
