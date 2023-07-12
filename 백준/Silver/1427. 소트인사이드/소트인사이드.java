import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] nums = sc.nextLine().toCharArray();
		int n = nums.length;
		
		for (int i = 0; i < n; i++) {
			int maxIdx = i;
			
			for (int j = i + 1; j < n; j++) {
				if (nums[j] > nums[maxIdx]) maxIdx = j;
			}
			
			if (i != maxIdx) {
				char temp = nums[i];
				nums[i] = nums[maxIdx];
				nums[maxIdx] = temp;
			}
		}
		
		System.out.println(nums);
	}
}
