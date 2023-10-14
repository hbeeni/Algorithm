//https://taehoung0102.tistory.com/157


package programmers.lv2;

public class 프렌즈4블록 {
    public int solution(int m, int n, String[] board) {
        char[][] table = new char[m][n];
        for (int i = 0; i < m; i++) {
            table[i] = board[i].toCharArray();
        }

        int answer = 0;
        while (true) {
            System.out.println("[ BOARD ]");
            for (char[] chars : table) {
                System.out.println(chars);
            }

            boolean notRemoved = true;
            boolean[][] check = new boolean[m][n];

            //블록 체크
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (table[i][j] == ' ') {
                        continue;
                    }

                    char ch = table[i][j];
                    if (table[i][j + 1] == ch && table[i + 1][j] == ch && table[i + 1][j + 1] == ch) {
                        check[i][j] = true;
                        check[i][j + 1] = true;
                        check[i + 1][j] = true;
                        check[i + 1][j + 1] = true;
                        notRemoved = false;
                    }
                }
            }

            //체크된 블록이 없으면 반복문 종료
            if (notRemoved) {
                break;
            }
            System.out.println("[ CHECK ]");
            for (boolean[] booleans : check) {
                for (boolean b : booleans) {
                    if (b) {
                        System.out.print("T");
                    } else {
                        System.out.print("F");
                    }
                }
                System.out.println();
            }

            //체크된 블록 삭제
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j]) {
                        table[i][j] = ' ';
                        answer++;
                    }
                }
            }

            //블록 내리기
            for (int j = 0; j < n; j++) {
                int space = 0;
                for (int i = m - 1; i >= 0; i--) {
                    if (table[i][j] == ' ') {
                        space++;
                    } else if (table[i][j] != ' ' && space > 0) {
                        table[i + space][j] = table[i][j];
                        table[i][j] = ' ';
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        프렌즈4블록 s = new 프렌즈4블록();
        System.out.println(s.solution(4, 5, new String[]{
                "CCBDE",
                "AAADE",
                "AAABF",
                "CCBBF"
        })); //14
        System.out.println(s.solution(6, 6, new String[]{
                "TTTANT",
                "RRFACC",
                "RRRFCC",
                "TRRRAA",
                "TTMMMF",
                "TMMTTJ"
        })); //15
    }
}
