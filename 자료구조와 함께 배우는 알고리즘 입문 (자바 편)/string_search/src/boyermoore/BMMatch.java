package boyermoore;

public class BMMatch {

    static int bmMatch(String txt, String pattern) {
        int txtPointer;
        int patPointer;
        int txtLen = txt.length();
        int patLen = pattern.length();
        int[] skip = new int[Character.MAX_VALUE + 1];

        //건너뛰기 표 만들기
        for (txtPointer = 0; txtPointer <= Character.MAX_VALUE; txtPointer++) {
            skip[txtPointer] = patLen;
        }
        for (txtPointer = 0; txtPointer < patLen - 1; txtPointer++) {
            skip[pattern.charAt(txtPointer)] = patLen - txtPointer - 1;
        }

        //검색
        while (txtPointer < txtLen) {
            patPointer = patLen - 1; //pattern의 마지막 문자에 주목

            while (txt.charAt(txtPointer) == pattern.charAt(patPointer)) {
                if (patPointer == 0) {
                    return txtPointer; //검색 성공
                }
                patPointer--;
                txtPointer--;
            }

            txtPointer += (skip[txt.charAt(txtPointer)] > patLen - patPointer)
                    ? skip[txt.charAt(txtPointer)] : patLen - patPointer;
        }

        return -1; //검색 실패
    }

    public static void main(String[] args) {
        String txt = "ABAABACABAACCABACABACABAACABACABAAC";
        String pattern = "ABACABAACD";
        System.out.println(bmMatch(txt, pattern));
    }
}
