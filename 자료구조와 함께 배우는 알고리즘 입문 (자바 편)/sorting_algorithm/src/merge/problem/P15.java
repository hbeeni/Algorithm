//PhyscData 시력 내림차순 정렬

package merge.problem;

import merge.PhyscData;

import java.util.Arrays;

public class P15 {
    public static void main(String[] args) {
        PhyscData[] x = {
                new PhyscData("강민하", 162, 0.3),
                new PhyscData("김찬우", 173, 0.7),
                new PhyscData("박준서", 175, 2.0),
                new PhyscData("유서범", 171, 1.5),
                new PhyscData("이수연", 168, 0.4),
                new PhyscData("장경오", 174, 1.2),
                new PhyscData("황지안", 169, 0.8),
        };

        Arrays.sort(x, PhyscData.VISION_ORDER);
        for (PhyscData physcData : x) {
            System.out.println(physcData);
        }
    }
}
