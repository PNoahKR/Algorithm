import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            // 입력
            // Command수 N
            int N = Integer.parseInt(br.readLine());

            // 로직
            int speed = 0;
            int length = 0;

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());

                if (cmd == 0){
                    length += speed;
                    continue;
                }

                int ms = Integer.parseInt(st.nextToken());

                if (cmd == 1){
                    speed += ms;
                    length += speed;
                    continue;
                } else {
                    if(speed < ms){
                        speed = 0;
                        continue;
                    } else {
                        speed -= ms;
                        length += speed;
                    }
                }
            }

            // 출력
            System.out.println("#" + test_case + " " + length);

        } // tc반복문
    }
}
