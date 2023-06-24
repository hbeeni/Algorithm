package eightqueen.problem;

public class P10 {

    static int[] pos = new int[8];
    static boolean[] flag_a = new boolean[8]; //각 행에 퀸을 배치했는지
    static boolean[] flag_b = new boolean[15]; //／ 대각선 방향으로 퀸을 배치했는지 (위 -> 아래)
    static boolean[] flag_c = new boolean[15]; //＼ 대각선 방향으로 퀸을 배치했는지 (위 -> 아래)
    static int count = 0; //경우의 수

    static void print() {
        count++;
        for (int i = 0; i < 8; i++) {
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }

    static void set(int i) {
        int j;
        int[] stack = new int[8];

        Start:
        while (true) {
            j = 0;

            while (true) {
                while (j < 8) {
                    if (!flag_a[j] && !flag_b[i + j] && !flag_c[i - j + 7]) {
                        pos[i] = j;

                        if (i == 7) { // 모든 열에 배치종료
                            print();
                        } else {
                            flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
                            stack[i++] = j; // i열의 행을 Push
                            continue Start;
                        }
                    }

                    j++;
                }

                if (--i == -1) {
                    return;
                }

                j = stack[i]; // i열의 행을 Pop
                flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}
