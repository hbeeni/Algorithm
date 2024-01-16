package logic.정렬;

import java.util.Arrays;

//https://www.acmicpc.net/problem/2751 : n의 최대 범위가 1,000,000 -> O(nlogn)
//핵심: 분할정복 방식을 사용해 데이터를 분할하고, 두 그룹을 정렬하며 합침
public class 병합정렬 {

	static int[] a = {5, 4, 3, 2, 1};
	static int[] temp = new int[5];

	public static void main(String[] args) {
		mergeSort(0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	static void mergeSort(int s, int e) {
		System.out.println("mergeSort(" + s + ", " + e + ")");
		if (e - s < 1) {
			return;
		}
		int m = (s + e) / 2;
		mergeSort(s, m);
		mergeSort(m + 1, e);

		// for (int i = s; i <= e; i++) {
		// 	temp[i] = a[i];
		// }
		//두 그룹 병합 전 temp 배열에 저장 (원본 배열에 두 그룹을 정렬한 결과를 저장하기 때문)
		System.arraycopy(a, s, temp, s, e - s + 1);
		System.out.println(Arrays.toString(temp));

		int k = s;
		int index1 = s;
		int index2 = m + 1;

		//두 그룹 병합
		while (index1 <= m && index2 <= e) {
			//양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고,
			//선택된 데이터의 index 값을 오른쪽으로 한 칸 이동
			if (temp[index1] > temp[index2]) {
				a[k] = temp[index2];
				k++;
				index2++;
			} else {
				a[k] = temp[index1];
				k++;
				index1++;
			}
		}

		//한 쪽 그룹이 모두 선택된 후 남아 있는 값 정리
		while (index1 <= m) {
			a[k] = temp[index1];
			k++;
			index1++;
		}
		while (index2 <= e) {
			a[k] = temp[index2];
			k++;
			index2++;
		}
	}
}
