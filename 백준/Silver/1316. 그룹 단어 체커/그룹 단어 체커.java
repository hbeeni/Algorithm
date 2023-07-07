import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = n;

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean['z' - 'a' + 1];
            String word = br.readLine();

            for (int j = 0; j < word.length(); j++) {
                int idx = word.charAt(j) - 'a';

                if (visited[idx]) {
                    if (word.charAt(j) != word.charAt(j - 1)) {
                        result--;
                        break;
                    }
                } else {
                    visited[idx] = true;
                }
            }
        }

        System.out.println(result);
    }
}