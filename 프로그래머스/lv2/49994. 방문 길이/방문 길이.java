import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        int x1 = 0, y1 = 0;
        int x2 = 0, y2 = 0;

        Set<Path> set = new HashSet<>();
        for (int i = 0; i < dirs.length(); i++) {
            switch (dirs.charAt(i)) {
                case 'U':
                    x2 = x1;
                    y2 = y1 + 1;
                    break;
                case 'D':
                    x2 = x1;
                    y2 = y1 - 1;
                    break;
                case 'R':
                    x2 = x1 + 1;
                    y2 = y1;
                    break;
                case 'L':
                    x2 = x1 - 1;
                    y2 = y1;
            }

            if (x2 > 5 || x2 < -5 || y2 > 5 || y2 < -5) {
                continue;
            }
            if (!set.contains(new Path(x2, y2, x1, y1))) {
                set.add(new Path(x1, y1, x2, y2));
            }
            x1 = x2;
            y1 = y2;
        }

        return set.size();
    }

    static class Path {
        int x1;
        int y1;
        int x2;
        int y2;

        public Path(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Path)) return false;
            Path path = (Path) o;
            return x1 == path.x1 && y1 == path.y1 && x2 == path.x2 && y2 == path.y2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2);
        }
    }
}
