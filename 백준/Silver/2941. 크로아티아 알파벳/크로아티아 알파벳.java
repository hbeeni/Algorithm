import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        List<String> cro = List.of(
                "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");
        int result = 0;

        int i = 0;
        int l = word.length();
        while (i < word.length()) {
            if (i + 3 <= l && cro.contains(word.substring(i, i + 3))) {
                i += 3;
            } else if (i + 2 <= l && cro.contains(word.substring(i, i + 2))) {
                i += 2;
            } else {
                i++;
            }

            result++;
        }

        System.out.println(result);
    }
}