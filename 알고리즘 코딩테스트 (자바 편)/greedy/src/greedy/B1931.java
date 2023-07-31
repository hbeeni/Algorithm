//오답

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map.put(start, Math.min(map.getOrDefault(start, Integer.MAX_VALUE), end));
        }

        int end = map.get(map.firstKey());
        int count = 1;
        map.remove(map.firstKey());

        for (int key : map.keySet()) {
            int currentStart = key;
            int currentEnd = map.get(key);

            if (currentEnd < end) {
                end = currentEnd;
            } else if (currentStart > end) {
                count++;
                end = currentEnd;
            }
        }

        System.out.println(count);
    }
}
