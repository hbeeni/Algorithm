import java.util.TreeSet;

class Solution {
    public int solution(String word) {
        String[] words = {"", "A", "E", "I", "O", "U"};

        TreeSet<String> set = new TreeSet<>();
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    for (int l = 0; l < 6; l++) {
                        for (int m = 0; m < 6; m++) {
                            String str = words[i] + words[j] + words[k] + words[l] + words[m];
                            set.add(str);
                        }
                    }
                }
            }
        }

        return set.headSet(word).size() + 1;
    }
}