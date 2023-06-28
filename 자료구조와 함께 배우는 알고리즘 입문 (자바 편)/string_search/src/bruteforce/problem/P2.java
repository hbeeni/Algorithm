//브루트-포스법에 의한 문자열검색(맨끝쪽부터 검색)

package bruteforce.problem;

public class P2 {

    static int bfMatchLast(String txt, String pattern) {
        int txtPointer = txt.length() - 1;
        int patPointer = pattern.length() - 1;

        while (txtPointer >= 0 && patPointer >= 0) {
            if (txt.charAt(txtPointer) == pattern.charAt(patPointer)) {
                txtPointer--;
                patPointer--;
            } else {
                txtPointer = txtPointer + pattern.length() - patPointer - 2;
                patPointer = pattern.length() - 1;
            }
        }

        if (patPointer == -1) {
            return txtPointer + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        String txt = "aaabbbcbbcb";
        String pattern = "bb";
        System.out.println(bfMatchLast(txt, pattern));
    }
}
