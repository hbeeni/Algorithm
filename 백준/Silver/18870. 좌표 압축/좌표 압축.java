import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> sortedMap = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(i, num);
            sortedMap.put(num, 0);
        }

        int count = 0;
        for (Integer i : sortedMap.keySet()) {
            sortedMap.put(i, count++);
        }

        for (int i = 0; i < n; i++) {
            bw.write(sortedMap.get(map.get(i)) + " ");
        }

        bw.flush();
        bw.close();
    }
}