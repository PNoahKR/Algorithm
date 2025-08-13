import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int nodes;
    
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 입력
            // 정점(노드) 개수
            int V = sc.nextInt();
            // 간선의 개수
            int E = sc.nextInt();
            // 임의의 두 정점
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            // 자식 배열
            int[] c1 = new int[V + 1];
            int[] c2 = new int[V + 1];
            // 부모 배열
            int[] parent = new int[V + 1];

            // 로직
            // 간선의 개수 만큼 반복물 돌려~!
            for (int i = 0; i < E; i++) {
                // 부모 노드!
                int p = sc.nextInt();
                // 자식 노드!
                int c = sc.nextInt();

                parent[c] = p;

                if (c1[p] == 0) {
                    c1[p] = c;
                } else {
                    c2[p] = c;
                }
            }

            // 첫번째 임의의 정점의 족보 받아보기
            List<Integer> node1Parent = new ArrayList<>();
            while (parent[node1] != 0) {
                node1Parent.add(parent[node1]);
                node1 = parent[node1];
            }

            // 첫번째 임의 정점의 조상 리스트와 두번째 임의 정점 조상 비교!
            int ancestor = 0;
            while (parent[node2] != 0) {
                // 두번째 조상님을 가까운 순서대로 차례로 꺼내 첫번째 조상님 리스트에 있는 지 비교 후 있으면 탈출!
                if (node1Parent.contains(parent[node2])) {
                    ancestor = parent[node2];
                    break;
                }
                node2 = parent[node2];
            }

            // 조상님의 서브 트리 노드 수 찾기!
            // 조상님 서브트리 노드 개수 초기화!
            nodes = 0;
            inOrder(ancestor, c1, c2);


            // 출력
            System.out.println("#" + test_case + " " + ancestor + " " + nodes);
		}
	}
    
    // 중위 순회
    public static void inOrder(int ancestor, int[] c1, int[] c2) {
        if (ancestor != 0) {
            inOrder(c1[ancestor], c1, c2);
            nodes++;
            inOrder(c2[ancestor], c1, c2);
        }
    }
    
}