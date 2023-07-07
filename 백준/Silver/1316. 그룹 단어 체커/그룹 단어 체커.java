import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int['z' - 'a' + 1];
        int result = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            boolean isGroupWord = true;

            for (int j = 0; j < a.length; j++) {
                a[j] = -1;
            }

            for (int j = 0; j < word.length(); j++) {
                //마지막 인덱스가 내 바로 앞이거나 -1이면
                int idx = word.charAt(j) - 'a';

                if (a[idx] == -1 || j - 1 == a[idx]) {
                    a[idx] = j;
                    continue;
                } else {
                    isGroupWord = false;
                    break;
                }
            }

            if (isGroupWord) {
                result++;
            }
        }

        System.out.println(result);
    }
}