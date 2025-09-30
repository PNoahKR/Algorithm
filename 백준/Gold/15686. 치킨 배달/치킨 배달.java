import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, min;
//    static int[][] map;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static boolean[] selectedChickens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 우선 도시의 크기 N과 치킨집 개수 M을 입력받자
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 도시 배열 만들기 근데 얘도 1부터 시작이라 +1 해주기
        // 안해줘도 된다!!! 좌표 값만 있으면 거리계산은 충분하네!
//        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
                int type = Integer.parseInt(st.nextToken());
                // 1이면 집 리스트에 넣기
                if(type == 1) {
                    houses.add(new int[]{i, j});
                }
                // 2이면 치킨 리스트에 넣기
                else if(type == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }
        // 현재 있는 치킨집 만큼 만들어주자
        selectedChickens = new boolean[chickens.size()];

        // 가장 작은 치킨거리 담을 min
        min = Integer.MAX_VALUE;
        // M개의 치킨집 조합
        comb(0, 0);

        System.out.println(min);
    }

    private static void comb(int idx, int sidx) {
        // 종료 조건
        if(sidx == M) {
            cal(); // 거리 계산
            return;
        }

        // 모든 치킨집 탐색
        if(idx == chickens.size()) {
            return;
        }

        //1. 현재 치킨집 선택
        selectedChickens[idx] = true;
        comb(idx + 1, sidx + 1);

        //2. 현재 치킨집 폐업
        selectedChickens[idx] = false;
        comb(idx + 1, sidx);
    }

    private static void cal() {
        int dist = 0;

        for(int[] house: houses) {
            // 가장 가까운 치킨집 거리 저장할 배열
            int nearChickenDist = Integer.MAX_VALUE;

            // 현재 집과 모든 치킨집 거리 계산
            for (int i = 0; i < chickens.size(); i++) {
                if(selectedChickens[i]) {
                    int[] chicken = chickens.get(i);
                    // 치킨집과 집과의 거리
                    int HtoC = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                    nearChickenDist = Math.min(nearChickenDist, HtoC);
                }
            }
            dist += nearChickenDist; //거리 누적
        }

        min = Math.min(min, dist);
    }
}
