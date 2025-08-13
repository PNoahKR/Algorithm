import java.util.ArrayDeque;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    // 후위 순회
	public static String postOrder(int r, int[] left, int[] right, String[] data) {
		if(r != 0) {
			return postOrder(left[r], left, right, data) +
			postOrder(right[r], left, right, data) +
			data[r] +
			" ";
		}
		return "";
	}
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			// 입력
			// 정점의 개수
			int N = Integer.parseInt(sc.nextLine());
			
			// 자식 노드 배열
			int[] left = new int[N + 1];
			int[] right = new int[N + 1];
			// 부모 노드 배열
			int[] parent = new int[N + 1];
			// 데이터 배열
			String[] data = new String[N + 1];
			
			// 정점의 수 만큼 반복문
			for (int i = 0; i < N; i++) {
				String line = sc.nextLine();
				String[] lines = line.split(" ");
				
				// 현재 노드 정점
				int p = Integer.parseInt(lines[0]);
				// 정점의 들어갈 데이터
				String word = lines[1];
				
				if(lines.length >= 4) {
					// 오른쪽 자식!
					int cr = Integer.parseInt(lines[3]);
					
					// 오른쪽 자식 배열 : 부모노드 인덱스에 자식노드 정점 넣기!
					right[p] = cr;
					// 부모 노드 배열 : 오른쪽자식 인덱스에 부모노드 정점 넣기!
					parent[cr] = p;
				}
				if(lines.length >= 3) {
					// 왼쪽 자식!
					int cl = Integer.parseInt(lines[2]);
					
					// 왼쪽 자식 배열 : 부모노드 인덱스에 자식노드 정점 넣기!
					left[p] = cl;
					// 부모 노드 배열 : 왼쪽자식 인덱스에 부모노드 정점 넣기!
					parent[cl] = p;
				}
				// 데이터배열 : 부모노드 인덱스에 데이터 넣기
				data[p] = word;
				
			}
			
			
			// 로직
			// 루트 찾기!
			int root = 1;
			while(parent[root] != 0){
				root = parent[root];
			}
			
			// 후위 연산자로 만들어서 스택 연산 진행하기!
			// 후위 연산자 배열에 넣기  -> 후위 순회해서!
			String[] postfix = postOrder(root, left, right, data).split(" ");
			
			// 스택 생성 후 스택연산 진행(이거 모르면 쬐금 아쉬울지도~?)
			ArrayDeque<Integer> stack = new ArrayDeque<>();
			for (int i = 0; i < postfix.length; i++) {
				String tmp = postfix[i];
				if(tmp.equals("+")) {
					int b = stack.pop();
					int a = stack.pop();
					stack.push(a + b);
				} else if (tmp.equals("-")) {
					int b = stack.pop();
					int a = stack.pop();
					stack.push(a - b);
				} else if (tmp.equals("*")) {
					int b = stack.pop();
					int a = stack.pop();
					stack.push(a * b);
				} else if (tmp.equals("/")) {
					int b = stack.pop();
					int a = stack.pop();
					stack.push(a / b);
				} else {
					stack.push(Integer.parseInt(tmp));
				}
			}

			// 출력
			System.out.println("#" + test_case + " " + stack.pop());
		}
	}
}