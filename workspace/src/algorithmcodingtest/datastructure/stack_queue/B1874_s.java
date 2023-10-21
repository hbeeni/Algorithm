package algorithmcodingtest.datastructure.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();

        int num = 1; //현재 stack에 넣은 최대 자연수
        boolean result = true;

        for (int i = 0; i < a.length; i++) {
            if (a[i] >= num) {
                while (a[i] >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }

                stack.pop();
                bf.append("-\n");
            } else { //a[i] < num
                int pop = stack.pop();

                //스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열 출력 불가
                if (pop > a[i]) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }

        if (result) {
            System.out.println(bf);
        }
    }
}
