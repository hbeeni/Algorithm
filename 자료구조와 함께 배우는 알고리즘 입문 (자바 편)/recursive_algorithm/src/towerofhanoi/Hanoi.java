package towerofhanoi;

public class Hanoi {

    //no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
    static void move(int no, int x, int y) {
        if (no > 1) {
            move(no - 1, x, 6 - x - y); //12번 원반을 1->2번 기둥으로 옮김
        }

        System.out.printf("원반[%d]를 %d번 기둥에서 %d번 기둥으로 옮김\n", no, x, y); //3번 원반을 1->3번 기둥으로 옮김

        if (no > 1) {
            move(no - 1, 6 - x - y, y); //12번 원반을 2->3번 기둥으로 옮김
        }
    }

    public static void main(String[] args) {
        move(3, 1, 3);
    }
}
