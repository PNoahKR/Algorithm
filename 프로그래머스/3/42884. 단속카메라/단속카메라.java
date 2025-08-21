import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 진출(out) 지점을 기준으로 오름차순 정렬
        // 진출 지점을 기준으로 다음 차량들의 진입(in) 시점이 진출 지점보다
        // 앞에 있다면 ok! 뒤에 있다면 단속안됨!
        // 이건 진출지점에 카메라를 설치했다고 생각하면 이해가 됨
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // 그렇다면 왜 진입 기준으로 정렬해서 진입 혹은 진출 경로에 카메라를
        // 설치하는 방법도 있지 않는가 생각이 들지 않나?(사실 내가 처음에 그랬음 ㅋㅋ)
        // 이렇게 하면... 만약 루트가 {-30000, 30000}인 차량이 있고
        // 그 뒤에 뚝 뚝 끊겨서 가게 된다면 사실 그 사이 차량들이 단속을 피해갈 수 있는 여지를 줌
        // 그래서 진출 시점을 기준으로 정렬해 이전 진출(카메라설치장소)보다
        // 다음 차량의 진입 시점이 더 뒤면 카메라를 다음 차량의 진출 시점에 설치!
        // 한다는 느낌으로 봐줘잉

        int count = 0;
        int lastEnd = -30001;

        for (int i = 0; i < routes.length; i++) {
            if(lastEnd < routes[i][0]) {
                count++;
                lastEnd = routes[i][1];
            }
        }
        return count;
    }
}