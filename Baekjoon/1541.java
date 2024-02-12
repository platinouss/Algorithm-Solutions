/**
 * [Baekjoon] 1541. 잃어버린 괄호
 * https://www.acmicpc.net/problem/1541
 *
 * 접근 방식
 * 1) 최솟값을 구하기 위해서는 -부호에 영향받는 수의 크기가 커야하므로 -를 기준으로 split한다.
 * 2) 문제에서 주어진 문자열 첫 번째 문자는 숫자라고 했으므로, split된 배열의 첫번째 원소는 무조건 total에 더해주고,
 *    나머지 원소들은 -에 영향받는 값이므로 해당 원소에 해당하는 모든 숫자를 더해준 후 total 값에 뺀다.
 * 3) total을 반환한다.
 */

import java.io.*;

class Main {

    static String[] arr;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().split("-");
    }

    public static void main (String[] args) throws IOException {
        input();
        int total = 0;
        boolean check = false;
        for (String str : arr) {
            int sum = 0, value = 0, index = 0;
            while (index < str.length()) {
                if (str.charAt(index) == '+') {
                    sum += value;
                    value = 0;
                } else {
                    value = (value * 10) + (str.charAt(index) - '0');
                }
                index++;
            }
            sum += value;
            if (!check) {
                check = true;
                total = sum;
            } else {
                total -= sum;
            }
        }
        System.out.println(total);
    }
}


