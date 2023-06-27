package merge;

import java.util.Comparator;

public class PhyscData {

    String name;
    int height;
    double vision; //시력

    public PhyscData(String name, int height, double vision) {
        this.name = name;
        this.height = height;
        this.vision = vision;
    }

    @Override
    public String toString() {
        return name + " " + height + " " + vision;
    }

    public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
    public static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();

    private static class HeightOrderComparator implements Comparator<PhyscData> {

        @Override
        public int compare(PhyscData o1, PhyscData o2) {
            return o1.height - o2.height;
        }
    }

    private static class VisionOrderComparator implements Comparator<PhyscData> {

        @Override
        public int compare(PhyscData o1, PhyscData o2) {
            return (o2.vision > o1.vision) ? 1 : (o2.vision == o1.vision) ? 0 : -1;
//            return Double.compare(o2.vision, o1.vision);
        }
    }
}
