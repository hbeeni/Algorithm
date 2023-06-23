package analysis.problem;

public class RecurCount {

    static int count;

    static void recur(int n) {
        count++;

        if (n > 0) {
            recur(n - 1);
            System.out.print(n);
            recur(n - 2);
        }
    }

    public static void main(String[] args) {
        recur(10);
        System.out.println();
        System.out.println("count = " + count);
    }
}
