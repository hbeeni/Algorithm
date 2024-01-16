package logic.정렬;

import java.util.Arrays;

//https://www.acmicpc.net/problem/11004
//핵심: pivot 사용
public class 퀵정렬 {

	public static void main(String[] args) {
		int[] a = {4, 1, 2, 3, 5, 8, 7, 0};
		int k = 6; //k번째 수 구하기 = k - 1번 인덱스 구하기

		quickSort(a, 0, a.length - 1, k - 1);
		System.out.println(a[k - 1]);
		System.out.println(Arrays.toString(a));
	}

	/*
	1. 데이터를 분할하는 pivot을 설정한다.
	2. pivot을 기준으로 다음 a~e 과정을 거쳐 데이터를 2개의 집합으로 분리한다.
		a. start가 가리키는 데이터가 pivot이 가리키는 데이터보다 작으면 start를 오른쪽으로 1칸 이동한다.
		b. end가 가리키는 데이터가 pivot이 가리키는 데이터보다 크면 end를 왼쪽으로 1칸 이동한다.
		c. start가 가리키는 데이터가  pivot이 가리키는 데이터보다 크고, end가 가리키는 데이터가 pivot이 가리키는 데이터보다 작으면
		   start, end가 가리키는 데이터를 swap하고 start는 오른쪽, end는 왼쪽으로 1칸씩 이동한다.
		d. start와 end가 만날 때까지 a~c를 반복한다.
		e. start와 end가 만나면 만난 지점에서 가리키는 데이터와 pivot이 가리키는 데이터를 비교하여
		   pivot이 가리키는 데이터가 크면 만난 지점의 오른쪽에, 작으면 만난 지점의 왼쪽에 pivot이 가리키는 데이터를 삽입한다.
	3. 분리 집합에서 각각 다시 pivot을 설정한다.
	4. 분리 집합이 1개 이하가 될 때까지 1~3을 반복한다.
	 */
	static void quickSort(int[] a, int s, int e, int k) {
		System.out.println("quick sort!");
		if (s < e) {
			int pivot = partition(a, s, e);
			if (pivot == k) {
				return; //k번째 수가 pivot이면 더 이상 구할 필요 없음
			}

			if (k < pivot) { //k가 pivot보다 작으면 왼쪽 그룹만 정렬 수행
				quickSort(a, s, pivot - 1, k);
			} else { //k가 pivot보다 크면 오른쪽 그룹만 정렬 수행
				quickSort(a, pivot + 1, e, k);
			}
		}
	}

	static int partition(int[] a, int s, int e) {
		if (s + 1 == e) {
			if (a[s] > a[e]) {
				swap(a, s, e);
			}
			return e;
		}

		int m = (s + e) / 2; //중앙값을 pivot으로 선정
		swap(a, s, m); //i, j 이동을 편하게 하기 위해 pivot을 맨 앞으로 옮김

		int pivot = a[s];
		int i = s + 1;
		int j = e;

		while (i <= j) {
			while (i < a.length - 1 && pivot > a[i]) { //pivot보다 큰 수가 나올 때까지 i++
				i++;
			}

			while (j > 0 && pivot < a[j]) { //pivot보다 작은 수가 나올 때까지 j--
				j--;
			}

			if (i <= j) {
				swap(a, i++, j--);
			}
		}

		//i == j pivot의 값을 양쪽으로 분리한 가운데에 오도록 설정
		a[s] = a[j];
		a[j] = pivot;
		return j;
	}

	static void swap(int[] a, int i, int j) {
		System.out.println(i + ", " + j + " swap");
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
