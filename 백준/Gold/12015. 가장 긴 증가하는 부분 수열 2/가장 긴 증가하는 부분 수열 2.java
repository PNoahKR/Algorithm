import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1. 앞쪽에서 젤 작은수 뒤에서 젤 큰수를 찾은 다음 그 사이 값들을 찾아가면서 찾을수 있지 않을까?
-> 10, 50, 20, 30 이면 10 50 = 2 의 길이가 잡히는데 10 20 30 = 3이 답이니까 틀린 접근

2. 다른 방법으로 현재 위치의 숫자가 앞 숫자들 보다 크면 앞 숫자들의 연속되는 길이 중
가장 연속된 길이가 긴 것에 + 1 길이가 최대 연속수인것을 생각해서
i 가 현재 숫자인 경우 0 -> i 까지의 값들의 연속수를 가져와 그중 최대 수에대가 +1 한걸 i의 최대 연속수라고 지정한다
라고 생각했는데 그럼 2중 for문을 돌게된다

for (int i = 0; i < N; i++) {
    dp[i] = 1; // 자기자신이 앞 숫자들 보다 작다면 연속 수의 시작이되니...
    for(int j = 0; j < i; j++){
        if(arr[i] > arr[j]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }
}

이렇게 하믄... 될 줄 알았는데 역시나 N의 범위가 100만이니 100만의 제곱은 상상도 못할 시간이다 ^^

3. 아 그럼 어떡함? 주어진 배열을 한번만 싹 훑어도 100만인데...
B형 취득자 개발 경력 15년차 AI형님께 힌트를 달라고 했더니
페이션스 소팅(Patience Sorting)을 알려주셨다.

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 받기 야치!
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 페이션스 소팅은 현재 카드보다 "크거나 같은 숫자"가 "맨 위에 있는 더미 중 가장 왼쪽 더미 위"에 카드를 올리고
        // 올릴 곳이 없으면 "오른쪽"에 새로운 더미를 만듭니다.
        // 위 방법은 더 작은 카드를 위에 올려 더 촘촘한 증가수를 만드는 방법이다.
        // 이 리스트의 더미 수가 증가하는 부분 수열의 길이가 된다. (수열이 뭔지는 모름)

        // 카드라고 생각하고 카드더미를 올릴 테이블(배열 준비)
        int[] tmp = new int[N];
        int len = 0; // 카드더미의 길이

        for (int i = 0; i < N; i++) {
            int cur = arr[i]; // 현재 카드

            // 비어있거나, 더미 숫자중 젤 큰 수보다 더 크면 뒤에 붙임!
            if(len == 0 || tmp[len - 1] < cur) {
                tmp[len++] = cur;
            }
            // 아니면 앞에서서 들어갈 자리를 찾아 들어가야함
            else {
                int l = 0;
                int r = len;
                while (l < r) {
                    int m = (l + r) / 2;
                    if (tmp[m] >= cur) {
                        r = m;
                    } else {
                        l = m + 1;
                    }
                }
                tmp[r] = cur;
            }
        }

        System.out.println(len);
    }
}
