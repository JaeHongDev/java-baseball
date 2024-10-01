package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();


        while(true) {
            int exitval = 0;
            String num;
            String con;

            while (computer.size() < 3) {
                int ranValue = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(ranValue)) {
                    computer.add(ranValue);
                }
            }
//
            //System.out.println("computer:"+ computer);

            System.out.println("숫자 야구 게임을 시작합니다. ");

            System.out.println("숫자를 입력해주세요 : ");

            num = Console.readLine();
            if (num.length() != 3 || !num.matches("[1-9]{3}") || hasDuplicateDigits(num)) {
                throw new IllegalArgumentException();
            }
            // 첫 번째 자리수
            int tmpNum = Integer.parseInt(num);
            int one = (tmpNum / 100);

//                System.out.println("one:"+one);
            // 두 번째 자리수
            int two = ((tmpNum % 100) / 10);

//                System.out.println("two:"+two);
            // 세 번째 자리수
            int thr = (tmpNum % 10);
//                System.out.println("thr:"+thr);

            // 100의 자리 수가 같은 경우
            int checkS = 0;
            int checkB = 0;

            // 리스트를 계속 사용하고 싶다면:
            // 만약 리스트를 사용하고 싶다면, 리스트에 맞는 방식으로 처리하도록 코드를 수정해야 한다.
            // 예를 들어, 리스트의 요소에 접근하려면 배열이 아닌 리스트의 메서드(get() 등)를 사용해야 한다.
            if (one == computer.get(0)) {
                checkS += 1;
            } else {
                if (one == computer.get(1) || one == computer.get(2)) {
                    checkB += 1;
                }
            }

            //System.out.println("checkS"+ checkS+ "checkB"+ checkB);

            if (two == computer.get(1)) {
                checkS += 1;
            } else {
                if (two == computer.get(0) || two == computer.get(2)) {
                    checkB += 1;
                }
            }
            //System.out.println("checkS"+ checkS+ "checkB"+ checkB);

            if (thr == computer.get(2)) {
                checkS += 1;
            } else {
                if (thr == computer.get(0) || thr == computer.get(1)) {
                    checkB += 1;
                }
            }

            int t3check = 0;
            if (checkS == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                con = Console.readLine();
                int tmpCon = Integer.parseInt(con);
                if (tmpCon == 2) {
                    //System.out.println("그만?");
                    exitval = 1;
                    break;
                }
                computer = new ArrayList<>();
                checkS = 0;
                t3check = 1;
            }

            if (checkS >= 1 && checkB >= 1) {
                System.out.println(checkB + "볼 " + checkS + "스트라이크");
            }

            if (checkS >= 1 && checkB == 0) {
                System.out.println(checkS + "스트라이크");
            }

            if (checkB >= 1 && checkS == 0) {
                System.out.println(checkS + "볼");
            }


            if (checkS == 0 && checkB == 0) {
                if (t3check != 1) {
                    System.out.println("낫싱");
                }
            }
            t3check = 0;


            if (exitval == 1) {
                break;
            }

        }

    }

    // 입력값의 숫자에 중복이 있는지 확인하는 메서드
    private static boolean hasDuplicateDigits(String input) {
        char[] chars = input.toCharArray();
        return chars[0] == chars[1] || chars[0] == chars[2] || chars[1] == chars[2];
    }
}
