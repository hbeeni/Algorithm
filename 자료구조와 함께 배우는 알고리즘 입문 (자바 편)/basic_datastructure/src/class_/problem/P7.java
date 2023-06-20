// 신체 검사 데이터용 클래스 배열에서 평균 키와 시력의 분포를 구합니다(그래프출력)

package class_.problem;

public class P7 {
    static final int VMAX = 21; //시력 분포 (0.0 ~ 2.0: 0.1 단위로 21개)

    static class PhyscData {

        String name;
        int height;
        double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }
    }

    static double aveHeight(PhyscData[] data) {
        double sum = 0;

        for (PhyscData d : data) {
            sum += d.height;
        }

        return sum / data.length;
    }

    //시력 분포
    static void distVision(PhyscData[] data, int[] dist) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].vision >= 0.0 && data[i].vision <= (VMAX - 1) / 10.0) {
                dist[(int) (data[i].vision * 10)]++;
            }
        }
    }

    public static void main(String[] args) {
        PhyscData[] x = {
                new PhyscData("강민하", 162, 0.3),
                new PhyscData("김찬우", 173, 0.7),
                new PhyscData("박준서", 175, 2.0),
                new PhyscData("유서범", 171, 1.5),
                new PhyscData("이수연", 168, 0.7),
                new PhyscData("장경오", 174, 1.2),
                new PhyscData("황지안", 169, 0.8),
        };
        int[] vdist = new int[VMAX];

        System.out.println(" 이름    키   시력");
        System.out.println("--------------------");
        for (int i = 0; i < x.length; i++) {
            System.out.printf("%-6s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
        }

        System.out.printf("\n평균 키: %5.1fcm\n", aveHeight(x));

        System.out.println("\n시력 분포");
        distVision(x, vdist);
        for (int i = 0; i < VMAX; i++){
            System.out.printf("%3.1f～: %s\n", i / 10.0, "*".repeat(vdist[i]));
        }
    }
}
