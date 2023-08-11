package programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class 햄버거_만들기 {
    public int solution(int[] ingredient) {
        //빵(1) 야채(2) 고기(3)
        List<Integer> list = new ArrayList<>();
        int answer = 0;

        for (int i : ingredient) {
            list.add(i);
            int size = list.size();

            if (size >= 4) {
                if (list.get(size - 1) == 1 &&
                        list.get(size - 2) == 3 &&
                        list.get(size - 3) == 2 &&
                        list.get(size - 4) == 1) {
                    answer++;

                    list.remove(size - 1);
                    list.remove(size - 2);
                    list.remove(size - 3);
                    list.remove(size - 4);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        햄버거_만들기 hb = new 햄버거_만들기();
        System.out.println(hb.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
        System.out.println(hb.solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
    }
}
