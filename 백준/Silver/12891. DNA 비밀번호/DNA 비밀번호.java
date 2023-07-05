import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] cd = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int P = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		String dna = br.readLine();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			cd[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = S - 1;
		int count = 0;
		
		int a = 0, c = 0, g = 0, t = 0;

		for (int i = 0; i < S; i++) {
			switch (dna.charAt(i)) {
			case 'A':
				a++;
				break;
			case 'C':
				c++;
				break;
			case 'G':
				g++;
				break;
			case 'T':
				t++;
				break;
			}
		}
		
		while (end < P) {
			if (a >= cd[0] && c >= cd[1] && g >= cd[2] && t >= cd[3])
				count++;

			start++;
			end++;
			
			switch (dna.charAt(start - 1)) {
			case 'A':
				a--;
				break;
			case 'C':
				c--;
				break;
			case 'G':
				g--;
				break;
			case 'T':
				t--;
				break;
			}
			
			if (end < P) {
				switch (dna.charAt(end)) {
				case 'A':
					a++;
					break;
				case 'C':
					c++;
					break;
				case 'G':
					g++;
					break;
				case 'T':
					t++;
					break;
				}
			}
		}
		
		System.out.println(count);
	}
}