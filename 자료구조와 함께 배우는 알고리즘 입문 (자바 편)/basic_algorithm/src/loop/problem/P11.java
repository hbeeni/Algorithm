// 구구단 표를 출력(곱하는 수를 출력)

package loop.problem;

public class P11 {
    public static void main(String[] args) {
        int n = 9;

        System.out.print("  |");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        System.out.print("---+");
        for (int i = 0; i < n; i++) {
            System.out.printf("---");
        }
        System.out.println();

        for (int i = 1; i <= n; i++) {
            System.out.printf("%d |", i);

            for (int j = 1; j <= 9; j++) {
                System.out.printf("%3d", i * j);
            }

            System.out.println();
        }
    }
}
