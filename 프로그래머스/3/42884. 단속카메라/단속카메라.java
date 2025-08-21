import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

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