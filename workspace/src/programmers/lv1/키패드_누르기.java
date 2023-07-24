package programmers.lv1;

public class 키패드_누르기 {

    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        int left = 10;
        int right = 12;

        for (int n : numbers) {
            if (n == 1 || n == 4 || n == 7) {
                left = n;
                sb.append("L");
            } else if (n == 3 || n == 6 || n == 9) {
                right = n;
                sb.append("R");
            } else {
                if (n == 0) {
                    n = 11;
                }

                //위아래: /3, 좌우: %3
                int leftDiff = (Math.abs(n - left) / 3) + (Math.abs(n - left) % 3);
                int rightDiff = (Math.abs(n - right) / 3) + (Math.abs(n - right) % 3);

                if (leftDiff == rightDiff) {
                    if (hand.equals("right")) {
                        right = n;
                        sb.append("R");
                    } else {
                        left = n;
                        sb.append("L");
                    }
                } else if (leftDiff > rightDiff) {
                    right = n;
                    sb.append("R");
                } else {
                    left = n;
                    sb.append("L");
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }
}
