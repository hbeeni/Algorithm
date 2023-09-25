//Set 사용하는 게 훨씬 빠름

package trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14425_s {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node root = new Node();

        //트라이 자료 구조 구축
        while (n > 0) {
            String text = br.readLine();
            Node now = root;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                //26개 알파벳의 위치를 배열 index로 나타냄
                if (now.next[c - 'a'] == null) { //c에 해당하는 다음 노드가 없으면 신규 노드 생성
                    now.next[c - 'a'] = new Node();
                }
                now = now.next[c - 'a']; //현재 노드를 c 변수 노드로 변경
                if (i == text.length() - 1) { //문자열의 마지막이면 isEnd를 true로 설정
                    now.isEnd = true;
                }
            }
            n--;
        }

        int count = 0;
        while (m > 0) {
            String text = br.readLine();
            Node now = root;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (now.next[c - 'a'] == null) { //공백 노드라면 이 문자열을 포함하지 않음
                    break;
                }
                now = now.next[c - 'a'];
                if (i == text.length() - 1 && now.isEnd) { //문자열의 끝이고, 현재까지 모두 일치하면 집합에 포함되는 문자열
                    count++;
                }
            }
            m--;
        }

        System.out.println(count);
    }

    //트라이 자료 구조를 위한 Node 클래스
    static class Node {
        Node[] next = new Node[26]; //알파벳 26개
        boolean isEnd; //문자열의 마지막 유무 표시
    }
}
