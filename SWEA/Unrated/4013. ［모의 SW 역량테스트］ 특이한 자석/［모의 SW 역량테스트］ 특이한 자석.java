import java.util.*;
import java.io.FileInputStream;

class Solution
{
    // 자석을 회전 시키는 메서드
    public static void turning(List<Integer> magnet, int i) {
        if (i == 1) {
            int temp = magnet.remove(7);
            magnet.add(0, temp);
        } else if (i == -1) {
            int temp = magnet.remove(0);
            magnet.add(temp);
        }
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            // 입력
            // K : 회전수
            int K = sc.nextInt();

            // 자석 1
            List<Integer> magnet1 = new ArrayList<>();
            // 자석 2
            List<Integer> magnet2 = new ArrayList<>();
            // 자석 3
            List<Integer> magnet3 = new ArrayList<>();
            // 자석 4
            List<Integer> magnet4 = new ArrayList<>();

            // 자성 입력
            for (int j = 0; j < 8; j++) {
                magnet1.add(sc.nextInt());
            }
            for (int j = 0; j < 8; j++) {
                magnet2.add(sc.nextInt());
            }
            for (int j = 0; j < 8; j++) {
                magnet3.add(sc.nextInt());
            }
            for (int j = 0; j < 8; j++) {
                magnet4.add(sc.nextInt());
            }

            // 로직
            // K번 만큼 회전
            for (int i = 0; i < K; i++) {
                int magnetNum = sc.nextInt();
                int turn = sc.nextInt();

                // 1번 자석) 2번 자석의 관계
                boolean oneTwo = false;
                if (!magnet1.get(2).equals(magnet2.get(6))) {
                    oneTwo = true;
                }
                // 2번 자석과 3번 자석의 관계
                boolean twoThree = false;
                if (!magnet2.get(2).equals(magnet3.get(6))) {
                    twoThree = true;
                }
                // 3번 자석과 4번 자석의 관계
                boolean threeFour = false;
                if (!magnet3.get(2).equals(magnet4.get(6))) {
                    threeFour = true;
                }
                // 1번 자석일 경우
                if(magnetNum == 1) {
                    turning(magnet1, turn);
                    if(oneTwo) {
                        turning(magnet2, -turn);
                        if (twoThree) {
                            turning(magnet3, turn);
                            if (threeFour) {
                                turning(magnet4, -turn);
                            }
                        }
                    }
                }
                // 2번 자석일 경우
                else if(magnetNum == 2) {
                    turning(magnet2, turn);
                    if(oneTwo) {
                        turning(magnet1, -turn);
                    }
                    if(twoThree) {
                        turning(magnet3, -turn);
                        if(threeFour) {
                            turning(magnet4, turn);
                        }
                    }
                }
                // 3번 자석일 경우
                else if(magnetNum == 3) {
                    turning(magnet3, turn);
                    if(twoThree) {
                        turning(magnet2, -turn);
                        if(oneTwo) {
                            turning(magnet1, turn);
                        }
                    }
                    if(threeFour) {
                        turning(magnet4, -turn);
                    }
                }
                // 4번 자석일 경우
                else if(magnetNum == 4) {
                    turning(magnet4, turn);
                    if(threeFour) {
                        turning(magnet3, -turn);
                        if(twoThree) {
                            turning(magnet2, turn);
                            if(oneTwo) {
                                turning(magnet1, -turn);
                            }
                        }
                    }
                }
            }

            int sum = magnet1.get(0) + magnet2.get(0) * 2 + magnet3.get(0) * 4 + magnet4.get(0) * 8;
            // 출력
            System.out.println("#" + test_case + " " + sum);
		}
	}
}