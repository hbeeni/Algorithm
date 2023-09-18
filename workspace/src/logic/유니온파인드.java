package logic;

public class 유니온파인드 {

    static int[] arr = new int[5];

    static int find(int i) {
        if (arr[i] == i) {
            return i;
        }

        return arr[i] = find(arr[i]);
    }

    static void union(int i, int j) {
        i = find(i);
        j = find(j);

        if (i != j) {
            arr[j] = i;
        }
    }
}
