import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        double totalSum = 0.0; 
        double totalCredit = 0.0;

        // 입력은 항상 20줄로 고정되어 있습니다.
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken(); 
            double credit = Double.parseDouble(st.nextToken()); // 학점
            String grade = st.nextToken(); // 등급

            // P(Pass) 등급은 계산에서 제외
            if (grade.equals("P")) {
                continue;
            }

            totalSum += credit * getScore(grade);
            totalCredit += credit;
        }

        // 결과 출력
        System.out.printf("%.6f", totalSum / totalCredit);
    }

    private static double getScore(String grade) {
        switch (grade) {
            case "A+": return 4.5;
            case "A0": return 4.0;
            case "B+": return 3.5;
            case "B0": return 3.0;
            case "C+": return 2.5;
            case "C0": return 2.0;
            case "D+": return 1.5;
            case "D0": return 1.0;
            case "F":  return 0.0;
            default:   return 0.0;
        }
    }
}