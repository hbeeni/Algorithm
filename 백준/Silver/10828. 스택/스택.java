import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            if (s.startsWith("push")) {
                stack.push(Integer.parseInt(s.split(" ")[1]));
            } else {
                if (s.equals("pop")) {
                    if (stack.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(stack.pop());
                    }
                } else if (s.equals("size")) {
                    sb.append(stack.size());
                } else if (s.equals("empty")) {
                    sb.append(stack.isEmpty() ? 1 : 0);
                } else {
                    if (stack.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(stack.peek());
                    }
                }

                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}