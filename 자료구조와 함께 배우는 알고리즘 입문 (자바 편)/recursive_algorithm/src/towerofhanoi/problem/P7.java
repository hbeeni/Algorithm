// 하노이의 탑(기둥 이름을 문자열로 출력)

package towerofhanoi.problem;

public class P7 {

    static String[] a = {"A 기둥", "B 기둥", "C 기둥"};

    static void move(int no, int x, int y) {
        if (no > 1) {
            move(no - 1, x, 6 - x - y); //12번 원반을 1->2번 기둥으로 옮김
        }

        System.out.printf("원반[%d]를 %s에서 %s으로 옮김\n", no, a[x - 1], a[y - 1]); //3번 원반을 3번 기둥으로 옮김

        if (no > 1) {
            move(no - 1, 6 - x - y, y); //12번 원반을 2->3번 기둥으로 옮김
        }
    }

    public static void main(String[] args) {
        move(3, 1, 3);
    }
}
