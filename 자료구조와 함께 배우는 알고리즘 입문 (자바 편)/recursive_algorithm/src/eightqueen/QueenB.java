//각 열에 퀸 1개를 배치하는 모든 조합을 나열

package eightqueen;

public class QueenB {

    static int[] pos = new int[8]; //각 열에 있는 퀸의 위치: pos[열] = 행

    //각 열에 있는 퀸의 위치를 출력
    static void print() {
        for (int i = 0; i < 8; i++) {
            System.out.printf("%2d", pos[i]);
        }

        System.out.println();
    }

    //i열에 퀸을 배치
    static void set(int i) { //i: 열
        for (int j = 0; j < 8; j++) { //j: 행
            pos[i] = j;

            if (i == 7) {
                print();
            } else {
                set(i + 1);
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}
