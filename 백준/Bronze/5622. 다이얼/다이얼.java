import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'A': case 'B': case 'C':
                    result += 2;
                    break;
                case 'D': case 'E': case 'F':
                    result += 3;
                    break;
                case 'G': case 'H': case 'I':
                    result += 4;
                    break;
                case 'J': case 'K': case 'L':
                    result += 5;
                    break;
                case 'M': case 'N': case 'O':
                    result += 6;
                    break;
                case 'P': case 'Q': case 'R': case 'S':
                    result += 7;
                    break;
                case 'T': case 'U': case 'V':
                    result += 8;
                    break;
                case 'W': case 'X': case 'Y': case 'Z':
                    result += 9;
                    break;
            }
        }

        result += str.length();
        System.out.println(result);
    }
}