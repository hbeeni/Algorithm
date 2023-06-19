// 4 개의 직각삼각형을 출력

package loop.problem;

public class P14 {

    static void triangleLB(int n) { // 왼쪽 아래가 직각인 이등변삼각형
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleLU(int n) { // 왼쪽 위가 직각인 이등변삼각형
        for (int i = n; i > 0; i--) {
            System.out.println("*".repeat(i));
        }
    }

    static void triangleRB(int n) { // 오른쪽 아래가 직각인 이등변삼각형
        for (int i = 0; i < n; i++) {
            System.out.print(" ".repeat(n - i - 1));
            System.out.println("*".repeat(i + 1));
        }
    }

    static void triangleRU(int n) { // 오른쪽 위가 직각인 이등변삼각형
        for (int i = n; i > 0; i--) {
            System.out.print(" ".repeat(n - i));
            System.out.println("*".repeat(i));
        }
    }

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("직각이등변삼각형 출력");
        do {
            System.out.print("몇 단 삼각형입니까?: ");
            n = sc.nextInt();
        } while (n <= 0);*/

        int n = 4;

        System.out.println("== 왼쪽 아래가 직각 ==");
        triangleLB(n);
        System.out.println("== 왼쪽 위가 직각 ==");
        triangleLU(n);
        System.out.println("== 오른쪽 아래가 직각 ==");
        triangleRB(n);
        System.out.println("== 오른쪽 위가 직각 ==");
        triangleRU(n);
    }
}
