import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
         
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            // 입력
            // 전등 개수
            int N = sc.nextInt();
            // 1번부터 N번까지 전등이 있으니 +1 해 인덱스를 보기 편하게
            int[] arr = new int[N+1];
            //초기 전등 상태 설정
            for (int i = 1; i <= N; i++) {
                arr[i] = sc.nextInt();
            }
             
            // 목표 전등 상태 값 받기
            int[] goal = new int[arr.length];
            for (int i = 1; i <= N; i++) {
                goal[i] = sc.nextInt();
            }
             
            // 로직
            // 전등 조작 횟수
            int count = 0;
             
            // 전등을 조작하면 뒤의 상태 '값'을 전부 바꿔줘야 할까?
            // 전등을 한번 조작 했다면 전등의 상태가 일치하지 않을 때 통과가 되야한다.
            // boolean 값으로 상태값이 같아야 통과하는지 달라야 통과하는지 체크해주자
            boolean reverse = true;
             
            // i번째 전등을 조작할 경우 i~N번까지의 전등이 같이 조작됨
            // 왼쪽 부터 오른쪽으로 목표와 상태를 비교한다.
            // reverse = true -> 상태값이 같을때 통과 / 다를때 count++ & reverse = false
            // reverse = false -> 상태값이 같을때 count++ & reverse = true / 다를때 통과
            for(int i = 1; i <= N; i++) {
                if(reverse) {
                    if(goal[i] != arr[i]) {
                        count++;
                        reverse = false;
                    }
                    continue;
                } else {
                    if(goal[i] == arr[i]) {
                        count++;
                        reverse = true;
                    }
                }
            }
             
            // 출력
            System.out.println("#" + test_case + " " + count);
        }
    }
}