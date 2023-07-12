import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> coorX = new ArrayList<>();
        List<Integer> coorY = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coorX.add(Integer.parseInt(st.nextToken()));
            coorY.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(coorX);
        Collections.sort(coorY);

        int x, y;
        if (coorX.get(0).equals(coorX.get(1))) {
            x = coorX.get(2);
        } else {
            x = coorX.get(0);
        }

        if (coorY.get(0).equals(coorY.get(1))) {
            y = coorY.get(2);
        } else {
            y = coorY.get(0);
        }

        System.out.println(x + " " + y);
    }
}