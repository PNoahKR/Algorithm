import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        int lastIndex = 0;
        int sum = 0;

        for(int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sum -= list.get(--lastIndex);
                list.remove(lastIndex);
            }
            else {
                list.add(num);
                sum += num;
                lastIndex++;
            }
        }

        System.out.println(sum);
    }
}
