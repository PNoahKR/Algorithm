import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 가로수들이 모두 같은 간격이 되도록 가로수를 추가로 심는 사업을 추진중?
// 기준으로 부터 심어져있는 가로수의 위치가 주어짐
// 모든 가로수가 같은 간격이 되는 새로 심는 최소 가로수 수...
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 기존 가로수 N개
        int N = Integer.parseInt(br.readLine());

        // 주어지는 가로수의 위치는 가까운 순서대로 나오니까 정렬할 필욘없을듯 하고
        // 모든 가로수가 같은 간격이 되는 조건은 기존 가로수들 간의 거리 차이의 최대공약수로 구하면 되지 않을까?
        // 그 간격을 기준으로 새로운 간격의 가로수를 심으면 될듯?

        // 일단 기존 가로수를 받아
        int[] trees = new int[N];
        // 혹시 모르니 시작과 끝 값을 받아가볼까?
        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
            if(i == 0) start = trees[i];
            if(i == N - 1) end = trees[i];
        }

        // 일단 각 가로수 간의 거리 구하기
        int[] dist = new int[N-1];
        for (int i = 0; i < N-1; i++) {
            dist[i] = trees[i+1] - trees[i];
        }

        // 유클리드 호제법으로 최대공약수 구하기
        // 반복적으로 유.호 하는 방법!
        int resultGcd = dist[0];

        for (int i = 1; i < N-1; i++) {
            resultGcd = getGcd(resultGcd, dist[i]);
        }

        // 이제 최소한의 나무 개수를 구해야하는데 간격이 주어졌으니 start부터 end까지
        // 최소 간격으로 전부 놓고 현재 놓여져있는 나무 개수만 빼면 되는 것!(시작 지점은 카운트 하지 않은다고 생각)
        int totalTree = (end - start) / resultGcd;
        int result = totalTree - (N-1);
        System.out.println(result);



    }

    private static int getGcd(int a, int b) {
        if(b == 0) return a;
        return getGcd(b, a % b);
    }
}
