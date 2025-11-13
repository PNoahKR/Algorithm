import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 즉 백준이가 외치는 정수는 1~100,000까지 이다. 만약 이걸 리스트에 넣어서
        // 매번 sort하게 된다면 시간제한 0.1초 안에 절대 통과 못한다.
        // 그렇다면 가장 효율적인 방법은 중앙값을 이미 알고 있고, 그보다 큰수, 혹은 작은 수는 알아서
        // 나눠 관리하고 중앙값도 그에 따라 갱신되면 될것같다.
        // 우선순위 큐 2개를 준비해 하나는 오름차순 하나는 내림차순으로 해 그 peek()값을 중앙값으로 생각하면 어떨까

        // 우선 N의 크기를 입력받는다
        int N = Integer.parseInt(br.readLine());

        // peek했을때 중앙값을 얻으러면 내림차순으로 정렬해 그중 가장 높은 값을 가져야한다.
        PriorityQueue<Integer> pre = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> post = new PriorityQueue<>();

        // 이제 두 큐의 사이즈를 항상 맞춰주면 좋겠지만 홀수일 경우 어디가 먼저 값이 올라야하는가..
        // 당연히 앞쪽이다. 두 큐의 사이즈는 항상 앞이 1개 더 많거나 같아야한다.

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            // 사이즈가 같으면 앞에
            if(pre.size() == post.size()){
                pre.add(num);
            }
            // 다르면 앞이 많다는 의미로 뒤에!
            else {
                post.add(num);
            }

            if (!pre.isEmpty() && !post.isEmpty() && pre.peek() > post.peek()) {
                // 두 값을 뽑아서
                int maxVal = pre.poll();
                int minVal = post.poll();

                // 서로 바꿔서 다시 넣습니다.
                pre.add(minVal);
                post.add(maxVal);
            }
            System.out.println(pre.peek());
        }
    }
}
