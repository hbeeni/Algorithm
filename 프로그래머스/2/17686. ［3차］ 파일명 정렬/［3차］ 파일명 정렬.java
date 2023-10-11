import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public String[] solution(String[] files) {
        PriorityQueue<FileName> queue = new PriorityQueue<>(Comparator.comparing(FileName::getHead)
                .thenComparingInt(FileName::getNumber)
                .thenComparingInt(FileName::getIndex));

        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            int index = 0;

            while (index < file.length() && !(file.charAt(index) >= '0' && file.charAt(index) <= '9')) {
                head.append(file.charAt(index));
                index++;
            }
            while (index < file.length() && file.charAt(index) >= '0' && file.charAt(index) <= '9') {
                number.append(file.charAt(index));
                index++;
            }

            queue.add(new FileName(i, head.toString().toLowerCase(), Integer.parseInt(number.toString())));
        }

        System.out.println(queue);
        String[] answer = new String[files.length];
        int i = 0;
        while (!queue.isEmpty()) {
            answer[i++] = files[queue.poll().index];
        }
        return answer;
    }

    static class FileName {

        int index;
        String head;
        int number;

        public FileName(int index, String head, int number) {
            this.index = index;
            this.head = head;
            this.number = number;
        }

        public int getIndex() {
            return index;
        }

        public String getHead() {
            return head;
        }

        public int getNumber() {
            return number;
        }
    }
}