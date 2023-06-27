package quick;

import utils.SortUtils;

public class Partition {

    //배열을 나눔
    static void partition(int[] a, int n) {
        int pl = 0; //왼쪽 커서
        int pr = n - 1; //오른쪽 커서
        int x = a[n / 2]; //피벗(가운데)

       do {
           while (a[pl] < x) { //pivot 기준 크거나 같을 때 멈춤
               pl++;
           }
           while (a[pr] > x) { //pivot 기준 작거나 같을 때 멈춤
               pr--;
           }

           if (pl <= pr) {
               SortUtils.swap(a, pl++, pr--);
           }
       } while (pl <= pr);

        System.out.println("pivot = " + x);
        System.out.println("피벗 이하 그룹");
        for (int i = 0; i <= pl - 1; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        if (pl > pr + 1) {
            System.out.println("피벗 일치 그룹");

            for (int i = pr + 1; i <= pl - 1; i++) {
                System.out.print(a[i] + " ");
            }

            System.out.println();
        }

        System.out.println("피벗 이상 그룹");
        for (int i = pr + 1; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {1, 8, 7, 4, 5, 2, 6, 3, 9};
        int[] b = {1, 8, 7, 4, 5, 2, 6, 3, 9, 2, 2};
        partition(a, a.length);
        partition(b, b.length);
    }
}
