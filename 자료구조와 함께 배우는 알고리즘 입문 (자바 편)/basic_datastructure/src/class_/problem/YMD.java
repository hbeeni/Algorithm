// 날짜 클래스

package class_.problem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class YMD {
    int y;
    int m;
    int d;

    public YMD(int y, int m, int d) {
        this.y = y;
        this.m = m;
        this.d = d;
    }

    YMD after(int n) {
        long ms = dateToLong();
        ms += (n + 1) * 24L * 3600 * 1000;

        return longToYMD(ms);
    }

    YMD before(int n) {
        long ms = dateToLong();
        ms -= (n - 1) * 24L * 3600 * 1000;

        return longToYMD(ms);
    }

    private long dateToLong() {
        long ms = 0;
        String strDate = String.format("%d-%d-%d", y, m, d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = sdf.parse(strDate);
            ms = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ms;
    }

    private YMD longToYMD(long ms) {
        Date date = new Date(ms);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

        String strDate = sdf.format(date);
        int y = Integer.parseInt(strDate.substring(0, 4));
        int m = Integer.parseInt(strDate.substring(5, 7));
        int d = Integer.parseInt(strDate.substring(8));

        return new YMD(y, m, d);
    }

    @Override
    public String toString() {
        return String.format("%d년 %d월 %d일", y, m, d);
    }

    public static void main(String[] args) {
        YMD date = new YMD(2023, 6, 1);
        int after = 11;
        int before = 1;

        System.out.println(date);
        System.out.printf("%d일 후의 날짜는 %s입니다.\n", after, date.after(after));
        System.out.printf("%d일 전의 날짜는 %s입니다.\n", before, date.before(before));
    }

    /* 책 풀이

    //--- 각 월의 일수 ---//
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},		// 평년
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},		// 윤년
    };

    //--- year 년은 윤년인가?(윤년 : 1/평년 : 0) ---//
    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    //--- n일 후의 날짜를 반환 ---//
    YMD after(int n) {
        YMD temp = new YMD(this.y, this.m, this.d);
        if (n < 0)
            return before(-n);

        temp.d += n;

        while (temp.d > mdays[isLeap(temp.y)][temp.m - 1]) {
            temp.d -= mdays[isLeap(temp.y)][temp.m - 1];
            if (++temp.m > 12) {
                temp.y++;
                temp.m = 1;
            }
        }
        return temp;
    }

    //--- n일 전의 날짜를 반환 ---//
    YMD before(int n) {
        YMD temp = new YMD(this.y, this.m, this.d);
        if (n < 0)
            return after(-n);

        temp.d -= n;

        while (temp.d < 1) {
            if (--temp.m < 1) {
                temp.y--;
                temp.m = 12;
            }
            temp.d += mdays[isLeap(temp.y)][temp.m - 1];
        }
        return temp;
    }
    */
}
