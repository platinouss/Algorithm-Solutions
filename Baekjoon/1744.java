/**
 * [Baekjoon] 1744. 수 묶기
 * https://www.acmicpc.net/problem/1744
 *
 * 접근 방식
 * 1) 양수, 음수, 0을 모두 정렬하여 저장해둔다.
 * 2) 양수 list는 큰 수부터, 음수 list는 작은 수부터 짝 지어서 곱한 후 sum에 더한다.
 * 3) sum에 더해지지 않은 숫자 개수는 1~3개 중 하나가 될 것이다.
 *    3-1) 더해지지 않은 숫자가 1개일 때는 해당 숫자를 sum에 더한다.
 *    3-2) 더해지지 않은 숫자가 2개일 때는 해당 숫자를 더한 것과 곱한 것 중 큰 수를 sum에 더한다.
 *    3-3) 더해지지 않은 숫자가 3개일 때는 음수, 0, 양수 각각 1개 씩 있다는 뜻이므로 양수만 sum에 더한다.
 * 4) sum을 반환한다.
 */

import java.util.*;
import java.io.*;

class Main {

    static int sum;
    static boolean hasZero;
    static List<Integer> tmp;
    static List<Integer> positiveNumbers;
    static List<Integer> negativeNumbers;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int N = Integer.parseInt(br.readLine());
        tmp = new ArrayList<>();
        positiveNumbers = new ArrayList<>();
        negativeNumbers = new ArrayList<>();
        hasZero = false;
        while (N-- > 0) {
            int number = Integer.parseInt(br.readLine());
            if (number > 0) {
                positiveNumbers.add(number);
            } else if (number == 0) {
                hasZero = true;
            } else {
                negativeNumbers.add(number);
            }
        }
        Collections.sort(positiveNumbers, (o1, o2) -> o2 - o1);
        Collections.sort(negativeNumbers);
    }

    private static void sumNumber(List<Integer> numbers) {
        for (int i=0; i<numbers.size(); i+=2) {
            if (i + 1 >= numbers.size()) {
                tmp.add(numbers.get(i));
                break;
            }
            sum += Math.max(numbers.get(i) + numbers.get(i + 1), numbers.get(i) * numbers.get(i + 1));
        }
    }

    public static void main (String[] args) throws IOException {
        input();
        sumNumber(negativeNumbers);
        if (hasZero) {
            tmp.add(0);
        }
        sumNumber(positiveNumbers);
        if (tmp.size() == 1) {
            sum += tmp.get(0);
        } else if (tmp.size() == 2) {
            sum += Math.max(tmp.get(0) + tmp.get(1), tmp.get(0) * tmp.get(1));
        } else if (tmp.size() == 3) {
            sum += tmp.get(0) * tmp.get(1) + tmp.get(2);
        }
        System.out.println(sum);
    }
}
