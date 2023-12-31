package eightqueen.problem;

public class P9 {
    static int[] pos = new int[8];
    static boolean[] flag_a = new boolean[8];
    static boolean[] flag_b = new boolean[15];
    static boolean[] flag_c = new boolean[15];

    static void print() {
        for (int i = 0; i < 8; i++) {
            System.out.print("□ ".repeat(pos[i]));
            System.out.print("■ ");
            System.out.println("□ ".repeat(7 - pos[i]));
        }
    }

    /* 책
    static void print() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                System.out.printf("%s", j == pos[i] ? "■" : "□");
            System.out.println();
        }
        System.out.println();
    }
    */

    static void set(int i) {
        for (int j = 0; j < 8; j++) {
            if (!flag_a[j] && !flag_b[i + j] && !flag_c[7 - i + j]) {
                pos[i] = j;

                if (i == 7) {
                    print();
                } else {
                    flag_a[j] = flag_b[i + j] = flag_c[7 - i + j] = true;
                    set(i + 1);
                    flag_a[j] = flag_b[i + j] = flag_c[7 - i + j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}
