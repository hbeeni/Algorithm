import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String src = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int n = sc.nextInt();
        int b = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % b);
            n /= b;
        }

        String result = "";
        for (int i = 0; i < list.size(); i++) {
            result += src.charAt(list.get(list.size() - 1 - i));
        }

        System.out.println(result);
    }
}