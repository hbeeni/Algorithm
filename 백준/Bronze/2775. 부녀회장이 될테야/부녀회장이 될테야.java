import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int test = 0; test < t; test++) {
            int floor = sc.nextInt();
            int unit = sc.nextInt();

            int[][] apartment = new int[floor + 1][unit + 1];
            for (int i = 1; i <= floor; i++) {
                apartment[i][1] = 1;
            }
            for (int i = 1; i <= unit; i++) {
                apartment[0][i] = i;
            }

            for (int i = 1; i <= floor; i++) {
                for (int j = 1; j <= unit; j++) {
                    apartment[i][j] = apartment[i][j - 1] + apartment[i - 1][j];
                }
            }

            System.out.println(apartment[floor][unit]);
        }
    }
}
