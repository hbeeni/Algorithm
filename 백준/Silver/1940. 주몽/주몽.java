import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, Integer> list = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (list.containsKey(num)) {
                Integer count = list.get(num);
                list.put(num, count + 1);
            } else {
                list.put(num, 1);
            }
        }

        long result = 0;

        for (Integer num : list.keySet()) {
            if (2 * num != m && list.containsKey(m - num)) {
                Integer count1 = list.get(num);
                Integer count2 = list.get(m - num);
                result += count1 * count2;
                list.put(num, 0);
                list.put(m - num, 0);
            }
        }

        System.out.println(result);
    }
}
