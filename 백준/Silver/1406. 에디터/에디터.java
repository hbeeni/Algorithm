import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    static Deque<Character> left = new LinkedList<>();
    static Deque<Character> right = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < src.length(); i++) {
            left.offer(src.charAt(i));
        }

        for (int i = 0; i < m; i++) {
            String input = br.readLine();

            switch (input) {
                case "L":
                    cursorToLeft();
                    break;
                case "D":
                    cursorToRight();
                    break;
                case "B":
                    deleteLeftOne();
                    break;
                default:
                    insertLeft(input.split(" ")[1]);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) {
            sb.append(left.pollFirst());
        }
        while (!right.isEmpty()) {
            sb.append(right.pollLast());
        }

        System.out.println(sb);
    }

    private static void cursorToLeft() {
        if (!left.isEmpty()) {
            right.offer(left.pollLast());
        }
    }

    private static void cursorToRight() {
        if (!right.isEmpty()) {
            left.offer(right.pollLast());
        }
    }

    private static void deleteLeftOne() {
        if (!left.isEmpty()) {
            left.pollLast();
        }
    }

    private static void insertLeft(String str) {
        left.offer(str.charAt(0));
    }
}