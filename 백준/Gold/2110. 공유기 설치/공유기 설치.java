import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int left = 1;
        int right = houses[N - 1] - houses[0];
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            int installedCount = 1;
            int lastInstalled = houses[0];

            for (int i = 1; i < N; i++) {
                int distance = houses[i] - lastInstalled;

                if (distance >= mid) {
                    installedCount++;
                    lastInstalled = houses[i];
                }
            }

            if (installedCount >= C) {
                answer = mid;
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}