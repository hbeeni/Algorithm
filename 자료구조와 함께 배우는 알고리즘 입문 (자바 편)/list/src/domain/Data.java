package domain;

import java.util.Comparator;

//회원번호 + 이름
public class Data {

    private Integer no;
    private String name;

    public Data() {
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final Comparator<Data> NO_ORDER = new NoOrderComparator();
    public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();

    private static class NoOrderComparator implements Comparator<Data> {
        @Override
        public int compare(Data o1, Data o2) {
            return o1.no - o2.no;
        }
    }

    private static class NameOrderComparator implements Comparator<Data> {
        @Override
        public int compare(Data o1, Data o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    @Override
    public String toString() {
        return String.format("(%d)%s", no, name);
    }
}
