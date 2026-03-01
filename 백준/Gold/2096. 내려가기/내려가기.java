import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] max = new int[3];
        int[] min = new int[3];

        StringTokenizer st;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (i == 0) {
                max[0] = x;
                max[1] = y;
                max[2] = z;
                min[0] = x;
                min[1] = y;
                min[2] = z;
            } else {
                int tmpMaxX = max[0];
                int tmpMaxY = max[1];
                int tmpMaxZ = max[2];
                int tmpMinX = min[0];
                int tmpMinY = min[1];
                int tmpMinZ = min[2];

                max[0] = Math.max(tmpMaxX, tmpMaxY) + x;
                max[1] = Math.max(tmpMaxX, Math.max(tmpMaxY, tmpMaxZ)) + y;
                max[2] = Math.max(tmpMaxY, tmpMaxZ) + z;

                min[0] = Math.min(tmpMinX, tmpMinY) + x;
                min[1] = Math.min(tmpMinX, Math.min(tmpMinY, tmpMinZ)) + y;
                min[2] = Math.min(tmpMinY, tmpMinZ) + z;
            }
        }

        int maxResult = Math.max(max[0], Math.max(max[1], max[2]));
        int minResult = Math.min(min[0], Math.min(min[1], min[2]));

        System.out.println(maxResult + " " + minResult);

    }
}