import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        Arrays.sort(arr);

        int max = Collections.max(map.values());

        List<Integer> modes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (map.get(arr[i]) == max) {
                if (modes.contains(arr[i])) {
                    continue;
                } else {
                    modes.add(arr[i]);
                }
            }
        }

        int mode = 0;
        if (modes.size() > 1) {
            Collections.sort(modes);
            mode = modes.get(1);
        } else {
            mode = modes.get(0);
        }

        System.out.println((int) Math.round((double) sum / N));
        System.out.println(arr[N / 2]);
        System.out.println(mode);
        System.out.println(arr[N - 1] - arr[0]);
    }
}