import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] ans = new int[n];

        String[] str = br.readLine().split(" ");
        
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(str[i]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0); //최초 스택 초기화
        
        for (int i = 1; i < n; i++) {
            while (!stack.empty() && a[stack.peek()] < a[i]) {
                ans[stack.pop()] = a[i];
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            ans[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }
        
        bw.flush();
    }
}
