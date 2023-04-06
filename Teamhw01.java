package week02;

import java.io.*;
import java.util.*;

class Teamhw01
{
    public static void main(String[] args) throws IOException {
        int com[] = new int[3];
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            com[i] = r.nextInt(9) + 1;
            if (i == 1) {
                if (com[i] == com[i - 1])
                    i--;
            }

            if (i == 2) {
                if (com[i] == com[i - 1] || com[i] == com[i - 2])
                    i--;
            }
        }


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int user[] = new int[3];
        int strike ,ball;
        String num;
        int gameCnt = 0;
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        a : while (true) {
            strike = 0;
            ball = 0;



                System.out.print((gameCnt + 1) + "번째 시도 : ");
                num = br.readLine();
                gameCnt++;
                user[0] = Integer.parseInt(num) / 100;
                user[1] = Integer.parseInt(num) % 100 / 10;
                user[2] = Integer.parseInt(num) % 10;
                if (num.length() != 3) {
                    System.out.println("0~9 사이의 숫자 3자리를 입력해 주세요.");
                    continue a;
                } else if (num.charAt(0) == '0') {
                    System.out.println("첫번째 자리에는 0이 올 수 없습니다. 다시 입력해 주세요.");
                    continue a;
                } else if (user[0] == user[1] || user[1] == user[2] || user[0] == user[2]) {
                    System.out.println("중복된 숫자가 존재합니다. 다시 입력해 주세요.");
                    continue a;
                }
                for (int i = 0; i < 3; i++) {
                    if (com[i] == user[i])
                        strike++;
                }
                if (com[0] == user[1] || com[0] == user[2])
                    ball++;
                if (com[1] == user[0] || com[1] == user[2])
                    ball++;
                if (com[2] == user[0] || com[2] == user[1])
                    ball++;
                if (strike == 3) {
                    System.out.println("3S");
                    System.out.println(gameCnt + "번만에 맞히셨습니다.");
                    System.out.println("게임을 종료합니다.");
                    break;
                } else if (strike == 0 && ball == 0) {
                    System.out.println("0B0S");
                } else {
                    System.out.println(ball + "B" + strike + "S");
                }


            }

        }

    }
