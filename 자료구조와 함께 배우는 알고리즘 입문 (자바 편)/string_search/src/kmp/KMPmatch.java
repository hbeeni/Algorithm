package kmp;

public class KMPmatch {

    static int kmpMatch(String txt, String pattern) {
        int txtPoiter = 1;
        int patPointer = 0;
        int[] skip = new int[pattern.length() + 1];

        //건너뛰기 표 만들기
        while (txtPoiter != pattern.length()) {
            if (pattern.charAt(txtPoiter) == pattern.charAt(patPointer)) {
                skip[++txtPoiter] = ++patPointer;
            } else if (patPointer == 0) {
                skip[++txtPoiter] = patPointer;
            } else {
                patPointer = skip[patPointer];
            }
        }

        //검색
        txtPoiter = patPointer = 0;
        while (txtPoiter != txt.length() && patPointer != pattern.length()) {
            if (txt.charAt(txtPoiter) == pattern.charAt(patPointer)) {
                txtPoiter++;
                patPointer++;
            } else if (patPointer == 0) {
                txtPoiter++;
            } else {
                patPointer = skip[patPointer];
            }
        }

        if (patPointer == pattern.length()) {
            return txtPoiter - patPointer;
        }
        return -1;
    }

    public static void main(String[] args) {
        String txt = "ABAABACABAACCABACABACABAACABACABAAC";
        String pattern = "ABACABAAC";
        System.out.println(kmpMatch(txt, pattern));
    }
}
