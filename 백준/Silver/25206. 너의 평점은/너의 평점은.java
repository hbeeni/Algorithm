import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Float> scoreMap = new HashMap<>();

        char ch = 'A';
        for (int i = 0; i <= 'D' - 'A'; i++) {
            scoreMap.put(ch + "+", (float) (4 - i + 0.5));
            scoreMap.put(ch++ + "0", (float) (4 - i));
        }
        scoreMap.put("F", 0f);

        float totalScore = 0;
        float totalGrade = 0;
        for (int i = 0; i < 20; i++) {
            String[] tmp = br.readLine().split(" ");

            if (!tmp[2].equals("P")) {
                totalGrade += Float.parseFloat(tmp[1]);
                totalScore += scoreMap.get(tmp[2]) * Float.parseFloat(tmp[1]);
            }
        }

        System.out.println(totalScore / totalGrade);
    }
}