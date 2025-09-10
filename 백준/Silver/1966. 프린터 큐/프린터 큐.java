import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테케 수 입력 받기
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // N : 문서 개수, M : 확인한 문서가 있는 프린터의 순서
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 프린터 큐
            Queue<int[]> q = new LinkedList<>();
            // 중요도를 담을 리스트
            // why? : 중요도가 여러개 중복될 수 있으니 중요도를 입력 받을 때 마다 리스트에 저장 후
            // 내림차순 정렬해 순서대로 중요도 판단할 수 있게끔 하자
            LinkedList<Integer> list = new LinkedList<>();


            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                // 중요도
                int x = Integer.parseInt(st.nextToken());
                // 프린터 큐 안에 순서, 중요도
                q.offer(new int[]{j, x});
                // 중요도 넣기
                list.add(x);
            }
            // 중요도 내림차순 정렬
            list.sort(Comparator.reverseOrder());

            // 출력 순서
            int result = 0;

            // 먼저 뽑을 중요도를 나타낼 변수 imp
            int imp = list.getFirst();
            list.removeFirst();

            while (!q.isEmpty()) {
                // 현재 출력 대기중인 문서!
                int[] cur = q.poll();
                // 중요도도 자신의 문서 차례이고 원하던 순번의 문서라면!
                if(cur[1] == imp && cur[0] == M) {
                    // 출력!
                    result++;
                    break;
                }
                // 현재 문서가 원하던 문서는 아닌데 중요도가 뽑아야 할 문서네?
                else if (cur[1] == imp) {
                    // 출력!
                    result++;
                    imp = list.getFirst();
                    list.removeFirst();
                }
                // 중요하지도 않고 원하지도 않아 다시 줄서!
                else {
                    q.offer(cur);
                }
            }
            System.out.println(result);
        }
    }
}