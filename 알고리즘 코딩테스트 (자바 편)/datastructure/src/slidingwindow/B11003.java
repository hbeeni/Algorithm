//시간초과

package slidingwindow;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < l; i++) {
            q.add(a[i]);
            pq.add(a[i]);
            bw.write(pq.peek() + " ");
        }

        for (int i = l; i < n; i++) {
            q.add(a[i]);
            pq.add(a[i]);

            pq.remove(q.poll());
            bw.write(pq.peek() + " ");
            /*int poll = q.poll();

            if (poll != min) { //poll이 최솟값이 아니면 최솟값을 저장하고 poll 제거
                result[i] = min;
                pq.remove(poll);
            } else { //poll이 최솟값이면
                pq.poll(); //첫번째 값(최솟값) 꺼내기
                min = pq.peek(); //새로운 최솟값 설정

                if (poll == pq.peek()) { //poll과
                    result[i] = poll;
                } else {
                    result[i] = min;
                }

                pq.poll();
            }*/
        }

        bw.flush();
    }
}
