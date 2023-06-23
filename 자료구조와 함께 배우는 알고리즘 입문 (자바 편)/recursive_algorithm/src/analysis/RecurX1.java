package analysis;

public class RecurX1 {

    //꼬리재귀 제거
    static void recur(int n) {
        while (n > 0) {
            recur(n - 1);
            System.out.print(n);
            n = n - 2;
        }
    }

    public static void main(String[] args) {
        recur(4);
    }
}
