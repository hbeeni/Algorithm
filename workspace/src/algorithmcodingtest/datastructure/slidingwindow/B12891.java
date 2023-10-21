//못 품

package algorithmcodingtest.datastructure.slidingwindow;

import java.util.Scanner;

public class B12891 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt(); //문자열 길이
        int s = sc.nextInt(); //부분 문자열 길이
        String src = sc.next(); //문자열

        //A C G T
        int[] n = new int[4];

        for (int i = 0; i < 4; i++) {
            n[i] = sc.nextInt();
        }

        int count = 0;
        int start = 0;
        int end = start + s;

        int[] a = new int[4];
        String pw = src.substring(start, end);

        for (int i = 0; i < pw.length(); i++) {
            char tmp = pw.charAt(i);

            if (tmp == 'A') {
                a[0]++;
            } else if (tmp == 'C') {
                a[1]++;
            } else if (tmp == 'G') {
                a[2]++;
            } else {
                a[3]++;
            }
        }

        while (end <= p) {

            start++;
            end++;
        }

        System.out.println(count);
    }
}