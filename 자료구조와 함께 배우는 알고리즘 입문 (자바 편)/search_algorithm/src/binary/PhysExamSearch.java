package binary;

import java.util.Arrays;
import java.util.Comparator;

public class PhysExamSearch {

    static class PhyscData {
        private String name;
        private int height;
        private double vision;

        public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public String toString() {
            return name + ", " + height + ", " + vision;
        }

        private static class HeightOrderComparator implements Comparator<PhyscData> {
            @Override
            public int compare(PhyscData o1, PhyscData o2) {
                return o1.height - o2.height;
            }
        }
    }

    public static void main(String[] args) {
        PhyscData[] x = {
                new PhyscData("강민하", 162, 0.3),
                new PhyscData("이수연", 168, 0.4),
                new PhyscData("황지안", 169, 0.8),
                new PhyscData("유서범", 171, 1.5),
                new PhyscData("김찬우", 173, 0.7),
                new PhyscData("장경오", 174, 1.2),
                new PhyscData("박준서", 175, 2.0),
        };

        int height = 174;
        int idx = Arrays.binarySearch(
                x,
                new PhyscData("", height, 0.0), // 키가 height인 요소를
                PhyscData.HEIGHT_ORDER // HEIGHT_ORDER에 의해 검색
        );

        if (idx < 0) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터: " + x[idx]);
        }
    }
}
