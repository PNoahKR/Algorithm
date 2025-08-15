import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // 입력
        int N = sc.nextInt();

        // 로직
        // 1~N 까지의 숫자를 확인해서 '3' '6' '9' 가 들어가면 '-'가 출력되도록 반복문을 만드렉ㅆ다
        for (int i = 1; i <= N; i++) {
            // 입력받은 숫자를 문자열로 치환
            String str = String.valueOf(i);
            // 문자열에 3 6 9 가 없으면 그래도 출력
            if(!str.contains("3") && !str.contains("6") && !str.contains("9")){
                System.out.print(i + " ");
                continue;
            }
            // 그렇지 않다면 문자열에 들어있는 3 6 9 만큼 "-" 출력
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
                    System.out.print("-");
                }
            }
            System.out.print(" ");
        }
    }
}