import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int[] temp = new int[1000000];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		int[] A = new int[1000000];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		// 로직
		// 퀵 정렬을 통한 정렬
		quickSort(A, 0, 999999);

		// 출력
		System.out.println(A[500000]);

	}

	public static void quickSort(int[] A, int left, int right) {
		// 왼쪽 값이 오른쪽 보다 작을때!
		if(left < right) {
			// 피벗 만들기! (Hoare 파티션)
			int pivot = partition(A, left, right);
			// 만들어진 피벗을 중앙으로 두고 두 배열로 분할해서 정렬!
			quickSort(A, left, pivot - 1);
			quickSort(A, pivot + 1, right);
		}
	}

	public static int partition(int[] A, int left, int right) {
		// 피벗 값을 가장 왼쪽(앞) 인덱스 값으로 초기화
		int pivot = A[left];
		// L값은 피벗 다음값부터
		int L = left + 1;
		int R = right;
		
		//L값이 R값을 넘어가지 않을때 까지
		while(L <= R) {
			// L값이 R보다 앞에 있으면서 A[L]의 값이 피벗보다 작다면 L을 오른쪽으로 이동!
			while(L <= R && A[L] <= pivot) {
				L++;
			}
			// A[R] 값이 피벗보다 크다면 R값을 왼쪽으로 이동!
			while(A[R] > pivot) {
				R--;
			}
			// L인덱스 값이 R보다 작다면 스왑
			if(L < R) {
				int temp = A[L];
				A[L] = A[R];
				A[R] = temp;
			}
		}
		
		int temp = A[left];
		A[left] = A[R];
		A[R] = temp;
		
		return R;	
	}
}
