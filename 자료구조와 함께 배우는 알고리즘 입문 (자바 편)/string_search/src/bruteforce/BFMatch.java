package bruteforce;

public class BFMatch {

    static int bfMatch(String txt, String pattern) {
        int txtPointer = 0; //txt pointer
        int patPointer = 0; //pattern pointer
        int count = 0;

        while (txtPointer != txt.length() && patPointer != pattern.length()) {
            count++;

            if (txt.charAt(txtPointer) == pattern.charAt(patPointer)) {
                txtPointer++;
                patPointer++;
            } else {
                txtPointer = txtPointer - patPointer + 1;
                patPointer = 0;
            }
        }

        System.out.println("count = " + count);

        if (patPointer == pattern.length()) { //검색 성공
            return txtPointer - patPointer;
        }

        return -1; //검색 실패
    }

    //내가 작성
    static int bfMatchV2(String txt, String pattern) {
        int txtPointer = 0; //txt pointer
        int patPointer = 0; //pattern pointer
        int startPointer = 0; //검색 시작 포인터

        while (txtPointer != txt.length() && patPointer != pattern.length()) {
            if (txt.charAt(txtPointer) == pattern.charAt(patPointer)) {
                txtPointer++;
                patPointer++;
            } else {
                txtPointer = ++startPointer;
                patPointer = 0;
            }
        }

        if (patPointer == pattern.length()) { //검색 성공
            return txtPointer - patPointer;
        }

        return -1; //검색 실패
    }

    public static void main(String[] args) {
        String txt = "이지즈ABC이지스DEF";
        String pattern = "이지스";
        System.out.println(bfMatch(txt, pattern));

        txt = "ABABCDEFGHA";
        pattern = "ABC";
        System.out.println(bfMatch(txt, pattern));
    }
}
