package programmers.lv2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class 전화번호_목록 {

    //https://coding-grandpa.tistory.com/77
    public static boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();

        Collections.addAll(set, phone_book);

        for (String phoneNumber : phone_book) {
            for (int j = 0; j < phoneNumber.length(); j++) {
                if (set.contains(phoneNumber.substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }

    //https://bellog.tistory.com/167
    public static boolean solutionV2(String[] phone_book) {
        Set<String> set = new HashSet<>();
        Set<Integer> lengths = new TreeSet<>();

        for (String phoneNumber : phone_book) {
            set.add(phoneNumber);
            lengths.add(phoneNumber.length());
        }

        for (String phoneNumber : phone_book) {
            for (int length : lengths) {
                if (length >= phoneNumber.length()) {
                    break;
                }
                if (set.contains(phoneNumber.substring(0, length))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"})); //false
        System.out.println(solution(new String[]{"123", "456", "789"})); //true
        System.out.println(solution(new String[]{"12", "123", "1235", "567", "88"})); //false

        System.out.println(solutionV2(new String[]{"119", "97674223", "1195524421"})); //false
        System.out.println(solutionV2(new String[]{"123", "456", "789"})); //true
        System.out.println(solutionV2(new String[]{"12", "123", "1235", "567", "88"})); //false
    }
}
