import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 점의 개수 N
        int N = Integer.parseInt(br.readLine());

        int[][] points = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points, (i1, i2) -> {
            if (i1[1] == i2[1]) {
                return i1[0] - i2[0];
            }
            else {
                return i1[1] - i2[1];
            }
        });

        for (int i = 0; i < N; i++){
            System.out.println(points[i][0] + " " + points[i][1]);
        }
    }
}
