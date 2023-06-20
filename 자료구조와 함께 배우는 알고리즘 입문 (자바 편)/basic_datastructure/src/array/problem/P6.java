// 입력 받은 10진 정수를 2진수 ~ 36진수로 기수 변환하여 출력(변환 과정을 출력)

package array.problem;

public class P6 {

    //--- 정숫값 x를 r 진수로 변환하여 배열 d에 아랫자리부터 저장하고 자릿수를 반환 ---//
    static int cardConv(int x, int r, char[] d) {
        int n = ((Integer) x).toString().length();        // 변환 전의 자릿수
        int digits = 0;                                // 변환 후의 자릿수
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.printf(String.format("%%2d | %%%dd\n", n), r, x);
        do {
            System.out.printf("   +");
            for (int i = 0; i < n + 2; i++)
                System.out.print('-');
            System.out.println();

            if (x / r != 0) {
                System.out.printf(String.format("%%2d | %%%dd    ... %%d\n", n), r, x / r, x % r);
            } else {
                System.out.printf(String.format("     %%%dd    ... %%d\n", n), x / r, x % r);
            }

            d[digits++] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);

        for (int i = 0; i < digits / 2; i++) {
            char temp = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = temp;
        }

        return digits;
    }

    public static void main(String[] args) {
        System.out.println("10진수 기수 변환");
        int no = 59; //변환하는 정수
        int cd = 2; //기수
        int dno; //변환 후의 자릿수
        char[] cno = new char[32];

        dno = cardConv(no, cd, cno);

        String result = "";
        for (int i = 0; i < dno; i++) {
            result += cno[i];
        }

        System.out.printf("%d진수로 %s\n", cd, result);
    }
}
