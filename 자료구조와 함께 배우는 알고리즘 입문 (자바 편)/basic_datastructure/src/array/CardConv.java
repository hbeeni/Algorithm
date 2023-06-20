package array;

public class CardConv {

    //정숫값 x를 r진수로 변환하여 배열 d에 아랫자리부터 넣어 두고 자릿수를 변환
    static int cardConv(int x, int r, char[] d) {
        int digits = 0; //변환 후의 자릿수
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRUTUVWXYZ";

        do {
            d[digits++] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);

        //배열 d의 요소를 역순으로 정렬
        for (int i = 0; i < digits / 2; i++) {
            char tmp = d[i];
            d[i] = d[digits - 1 - i];
            d[digits - 1 - i] = tmp;
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
