import java.io.*;
import java.util.*;

public class Main {

    static int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken());
        int startM = Integer.parseInt(st.nextToken());
        int startD = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int endY = Integer.parseInt(st.nextToken());
        int endM = Integer.parseInt(st.nextToken());
        int endD = Integer.parseInt(st.nextToken());

        if (endY - startY > 1000 || 
           (endY - startY == 1000 && (endM > startM || (endM == startM && endD >= startD)))) {
            System.out.println("gg");
            return;
        }
        
        int totalDayStart = calcTotalDays(startY, startM, startD);
        int totalDayEnd = calcTotalDays(endY, endM, endD);
        
        System.out.println("D-" + (totalDayEnd - totalDayStart));
    }

    static int calcTotalDays(int y, int m, int d) {
        int days = 0;
        
        // 365일 * 연도수 + (4년마다 윤년 추가) - (100년마다 윤년 취소) + (400년마다 윤년 추가)
        days += (y - 1) * 365 + (y - 1) / 4 - (y - 1) / 100 + (y - 1) / 400;
        
        for (int i = 1; i < m; i++) {
            days += daysInMonth[i];
        }
        
        // 윤년이고, 구하려는 날짜가 2월을 지났다면 1일 추가
        if (isLeapYear(y) && m > 2) {
            days++;
        }
        
        days += d;
        
        return days;
    }

    static boolean isLeapYear(int y) {
        return y % 400 == 0 || (y % 4 == 0 && y % 100 != 0);
    }
}