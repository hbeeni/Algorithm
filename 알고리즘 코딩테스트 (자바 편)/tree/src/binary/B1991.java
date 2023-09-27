//풀다가 포기

package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node root = new Node("A");
        Map<String, Node> map = new HashMap<>();
        map.put(root.value, root);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String value = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            Node currentNode;
            if (map.containsKey(value)) {
                currentNode = map.get(value);
            } else {
                currentNode = new Node(value);
                map.put(value, currentNode);
            }

            Node leftNode = null;
            Node rightNode = null;
            if (!left.equals(".")) {
                leftNode = new Node(left);
                leftNode.parent = currentNode;
                map.put(left, leftNode);
            }
            if (!right.equals(".")) {
                rightNode = new Node(right);
                rightNode.parent = currentNode;
                map.put(right, rightNode);
            }

            currentNode.left = leftNode;
            currentNode.right = rightNode;
        }
    }

    static class Node {
        String value;
        Node parent;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
        }
    }
}
