import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			// 입력
			// 원본 암호문의 길이
			int N = sc.nextInt();
			LinkedList<String> list = new LinkedList<>();
			// 암호문 입력
			for (int i = 0; i < N; i++) {
				list.add(sc.next());
			}
			// 명령어 개수
			int M = sc.nextInt();
			// 명령어 입력
			
			// 로직
			// 명령어 개수 만큼 반복문 실행
			for (int i = 0; i < M; i++) {
				// 'I' 입력받기
				sc.next();
				// x, y 입력받기
				int x = sc.nextInt(); // 앞에서 부터 x의 위치를 나타내는 인덱스
				int y = sc.nextInt(); // y개의 숫자를 x위치에 더 추가
				for (int j = 0; j < y; j++) {
					// 반복문을 진행 할 때마다 x의 위치에 숫자가 추가되니 j만큼 인덱스를 더 추가해 뒤로 숫자가 입력되도록
					// 인덱스 값을 x + j로 설정
					list.add(x + j, sc.next());
				}
			}
			
			
			// 출력
			StringBuilder sb = new StringBuilder();
			//앞에서 부터 10개를 StringBuilder에 입력 후 출력
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			System.out.println("#" + test_case + " " + sb);
		}
	}
}