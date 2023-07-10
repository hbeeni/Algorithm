import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (Math.abs(o1) - Math.abs(o2)) != 0 ?
                        Math.abs(o1) - Math.abs(o2) : o1 - o2;
            }
        });

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                queue.add(num);
            } else {
                if (queue.size() == 0) {
                    System.out.println(0);
                    continue;
                }
                
                System.out.println(queue.poll());
            }
        }
    }
}
