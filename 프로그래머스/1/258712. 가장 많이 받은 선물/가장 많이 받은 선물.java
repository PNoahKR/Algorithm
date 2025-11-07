import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        // 친구들 수
        int friendSize = friends.length;
        // 주고받은 선물 횟수
        int giftSize = gifts.length;

        //a가 b에게 준 선물 횟수
        int[][] giveGiftCount = new int[friendSize][friendSize];
        // 선물지수
        int[] giftValues = new int[friendSize];

        // a와 b간의 선물횟수를 간단하게 정리하기 위해서 이름을 인덱스로 변환해 매핑하도록 한다.
        Map<String, Integer> mapping = new HashMap<>();
        for (int i = 0; i < friendSize; i++) {
            mapping.put(friends[i], i);
        }

        // 선물횟수와 선물지수를 계산하기 위한 과정을 진행한다.
        StringTokenizer st;
        for (int i = 0; i < giftSize; i++) {
            st = new StringTokenizer(gifts[i]);
            int a = mapping.get(st.nextToken());
            int b = mapping.get(st.nextToken());
            // a가 b에게 준 선물 횟수 올리기
            giveGiftCount[a][b]++;
            // 선물지수 계산
            giftValues[a]++;
            giftValues[b]--;
        }

        // 모든 친구들의 서로 주고받은 선물횟수와 선물지수를 비교해 다음달 선물 개수를 계산하자!
        int[] nextMonthGifts = new int[friendSize];

        for (int i = 0; i < friendSize; i++) {
            for (int j = i+1; j < friendSize; j++) {
                // a와 b간의 주고 받은 선물 수
                int iToj = giveGiftCount[i][j];
                int jToi = giveGiftCount[j][i];

                //1. 교환한 선물 수를 비교한다.
                if(iToj > jToi) {
                    nextMonthGifts[i]++;
                } else if (jToi > iToj) {
                    nextMonthGifts[j]++;
                }
                // 교환한 수의 선물이 같을 경우 선물지수를 비교한다.
                else {
                    if(giftValues[i] > giftValues[j]) {
                        nextMonthGifts[i]++;
                    } else if (giftValues[j] > giftValues[i]) {
                        nextMonthGifts[j]++;
                    }
                    // 선물지수까지 같다면 굳이 다음달은 선물안줘도됨
                }

            }
        }

        // 최대 선물수 찾기
        for (int i = 0; i < friendSize; i++) {
            answer = Math.max(answer, nextMonthGifts[i]);
        }

        return answer;
    }
}