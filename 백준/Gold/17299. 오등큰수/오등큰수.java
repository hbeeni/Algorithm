import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        Map<Integer, Integer> countMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            countMap.put(a[i], countMap.getOrDefault(a[i], 0) + 1);
        }

        Stack<Node> stack = new Stack<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.empty() && countMap.get(stack.peek().value) < countMap.get(a[i])) {
                result[stack.pop().index] = a[i];
                }

            stack.push(new Node(i, a[i]));
        }

        while (!stack.empty()) {
            result[stack.pop().index] = -1;
        }

        for (int i : result) {
            bw.write(i + " ");
        }
        bw.flush();
    }
}