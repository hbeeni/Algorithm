import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int total = 0, answer = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                if (str.charAt(i + 1) == ')') {
                    answer += total;
                    i++;
                } else {
                    total++;
                }
            } else {
                answer++;
                total--;
            }
        }

        System.out.println(answer);
    }
}