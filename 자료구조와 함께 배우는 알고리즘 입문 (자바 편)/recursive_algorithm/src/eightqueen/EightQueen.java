package eightqueen;

public class EightQueen {
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

    //i열의 알맞은 위치에 퀸을 배치
    static void set(int i) {
        for (int j = 0; j < 8; j++) {
            if (!flag_a[j] && //행에 배치 x
                !flag_b[i + j] && //／ 대각선 방향 배치 x
                !flag_c[7 - i + j]) { //＼ 대각선 방향 배치 x

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
        System.out.println("count = " + count);
    }
}
