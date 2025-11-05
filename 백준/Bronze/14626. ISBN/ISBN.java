import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
문제의 핵심은 13자리의 숫자를 나타내는 ISBN의 규칙성을 알아내는것
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 13자리 숫자+* 입력받기
        char[] isbn = br.readLine().toCharArray();

        // 가중치를 곱한 값들을 더하자
        int sum = 0;
        // * 위치
        int idx = -1;
        for (int i = 0; i < isbn.length; i++) {
            // * 찾기
            if (isbn[i] == '*') {
                idx = i;
                continue;
            }

            int num = isbn[i] - '0';
            // 가중치 적용해서 합계 구하기!
            if (i % 2 == 0) {
                sum += num;
            } else {
                sum += num * 3;
            }
        }

        // idx에 들어갈 가중치 값 구하기
        int weight = 0;
        if (idx % 2 == 0) {
            weight = 1;
        } else {
            weight = 3;
        }

        // * 자리에 0~9까지 넣으면서 sum % 10 == 0일 될때 까지 반복
        for (int i = 0; i < 10; i++) {
            int resultSum = sum + (i * weight);
            if(resultSum % 10 == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
