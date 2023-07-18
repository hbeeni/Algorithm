//https://dev-coco.tistory.com/157

package baekjoon_algorithmbasic;

import java.io.*;
import java.util.Stack;

public class B9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            char[] words = (br.readLine() + " ").toCharArray();

            for (char word : words) {
                if (word == ' ') {
                    while (!stack.isEmpty()) {
                        bw.write(stack.pop());
                    }

                    bw.write(word);
                } else {
                    stack.push(word);
                }
            }

            bw.newLine();
        }

        bw.flush();
    }
}
