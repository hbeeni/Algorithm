import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            char[] a = br.readLine().toCharArray();
            boolean input = false;
            
            for (int j = 0; j < a.length; j++) {
                if (a[j] == '(') {
                    stack.push(a[j]);
                } else {
                    if (stack.isEmpty()) {
                        sb.append("NO");
                        input = true;
                        break;
                    }

                    stack.pop();
                }
            }

            if (!input) {
                if (!stack.isEmpty()) {
                    sb.append("NO");
                } else {
                    sb.append("YES");
                }
            }
            
            sb.append("\n");
        }

        System.out.println(sb);
    }
}