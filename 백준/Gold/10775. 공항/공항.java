import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static int[] parent; // 유니온 파인드

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine()); // 게이트 수
        int P = Integer.parseInt(br.readLine()); // 비행기 수

        // 0번은 '도킹 실패'로 사용하기 위해 G+1
        parent = new int[G + 1];
        
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }

        int count = 0;

        for (int i = 0; i < P; i++) {
            int gate = Integer.parseInt(br.readLine());

            // 도킹 가능한 가장 큰 게이트 찾기
            int availableGate = find(gate);

            // 게이트가 0번이면 더 이상 자리가 없다
            if (availableGate == 0) {
                break;
            }

            // 성공
            count++;
            
            // 도킹한 게이트와 그 바로 앞 게이트를 합침
            union(availableGate, availableGate - 1);
        }

        System.out.println(count);
    }

    // Find
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        // 경로 압축
        return parent[x] = find(parent[x]);
    }

    // Union
    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootX] = rootY; // x의 부모를 y로 설정
        }
    }
}