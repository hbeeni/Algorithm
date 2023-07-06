import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();

        if (str.isBlank()) {
            System.out.println(0);
        } else {
            System.out.println(str.split(" ").length);
        }
    }
}