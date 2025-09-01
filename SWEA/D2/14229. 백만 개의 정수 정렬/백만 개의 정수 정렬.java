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
        // 병합 정렬을 통한 정렬
        mergeSort(A, 0, 999999);
 
        // 출력
        System.out.println(A[500000]);
 
    }
 
    public static void mergeSort(int[] A, int left, int right) {
        // left의 인덱스 값이 right와 교차되기 전까지
        if (left < right) {
            // 중앙 값 찾기
            int mid = (left + right) / 2;
            // 왼쪽부터 중앙 까지
            // 0/////////mid--------999999
            mergeSort(A, left, mid);
            // 중앙+1 부터 오른쪽 까지
            // 0--------mid/////////999999
            mergeSort(A, mid + 1, right);
            // 정렬 과정 진행
            merge(A, left, mid, right);
        }
 
    }
 
    public static void merge(int[] A, int left, int mid, int right) {
        // 주어진 left좌표는 분할된 1배열의 가장 왼쪽
        int L = left;
        // mid + 1은 분할된 2배열의 가장 왼쪽
        int R = mid + 1;
        // 임시 배열에 넣은 인덱스 위치!
        int idx = left;
 
        // 분할된 1배열의 왼쪽 인덱스가 중앙을 넘어가거나, 분할된 2배열의 오른쪽 인덱스가 끝 인덱스를 넘어가기 전까지
        while (L <= mid && R <= right) {
            // 1배열의 왼쪽과 2배열의 왼쪽을 비교해서 1배열이 작거나 같으면 1배열의 왼쪽 값을 임시 배열에 넣고 좌표를 오른쪽으로 옮긴다.(임시배열의
            // idx값도 올려준다.)
            if (A[L] <= A[R]) {
                temp[idx++] = A[L++];
            }
            // 1배열의 왼쪽과 2배열의 왼쪽을 비교해서 2배열이 작으면 2배열의 왼쪽 값을 임시 배열에 넣고 좌표를 오른쪽으로 옮긴다.(임시배열의
            // idx값도 올려준다.)
            // 위에서 1배열이 작거나 같을 때 옮기는거에 반해 아래의 2배열은 작을때만 옮기는데 먼저 나온 값을 앞으로 배치하는 안정정렬을 위함이다.
            else {
                temp[idx++] = A[R++];
            }
        } // 이과정을 다 거쳤다면, 어느 한쪽의 배열에 값들이 끝에 도달하지 못했다. 그럴 경우 전부다 털어내 준다.
 
        if (L <= mid) {
            for (int i = L; i <= mid; i++) {
                temp[idx++] = A[i];
            }
        } else {
            for (int i = R; i <= right; i++) {
                temp[idx++] = A[i];
            }
        }
 
        // 이제 임시 배열에 있는 값들을 전부 원 배열에 덮어 씌운다.
        for (int i = left; i <= right; i++) {
            A[i] = temp[i];
        }
    }
}