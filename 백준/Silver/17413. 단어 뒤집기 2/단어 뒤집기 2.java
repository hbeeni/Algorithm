import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String str = sc.nextLine();

        Deque<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ' ' || ch == '<') {
                while (!q.isEmpty()) {
                    sb.append(q.pollLast());
                }
                sb.append(ch);

                if (ch == '<') {
                    while (true) {
                        ch = str.charAt(++i);
                        sb.append(ch);

                        if (ch == '>') break;
                    }
                }
            } else {
                q.offer(ch);
            }
        }

        while (!q.isEmpty()) {
            sb.append(q.pollLast());
        }
        System.out.println(sb);
    }
}