package analysis;

import java.util.Stack;

public class RecurX2 {

    //재귀 제거
    static void recur(int n) {
        Stack<Integer> s = new Stack<>();

        while (true) {
            if (n > 0) {
                s.push(n);
                n--;
                continue;
            }
            if (!s.empty()) {
                n = s.pop();
                System.out.print(n);
                n -= 2;
                continue;
            }

            break;
        }
    }

    public static void main(String[] args) {
        recur(4);
    }
}
