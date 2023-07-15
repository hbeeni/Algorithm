import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] a = new String[n];

        for (int i = 0; i < n; i++) {
            a[i] = br.readLine();
        }

        List<String> list = Arrays.stream(a)
                            .distinct()
                            .sorted(Comparator.comparing(String::length)
                                    .thenComparing(String::compareTo))
                            .collect(Collectors.toList());
        
        list.forEach(s -> sb.append(s).append("\n"));
        System.out.println(sb);
    }
}