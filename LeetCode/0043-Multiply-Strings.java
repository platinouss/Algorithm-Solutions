/**
 * [LeetCode] 43. Multiply Strings
 * https://leetcode.com/problems/multiply-strings/description/
 *
 * 접근 방식
 * 1) 곱셈 결과를 담기 위한 배열을 생성하고, 하나하나씩 곱셈을 진행한다.
 *  1-1) 곱셈 결과와 그 자리에 있는 수를 더한다. 10으로 나눈 몫은 그 윗자리 수에 더해주고 mod 10 값은 해당 자리에 추가한다.
 * 2) 배열의 각 원소를 문자열로 만들어 반환한다.
 */

class Solution {
    public String multiply(String num1, String num2) {
        int N = num1.length();
        int M = num2.length();
        int[] arr = new int[N + M];
        for (int i=N-1; i>=0; i--) {
            for (int j=M-1; j>=0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = arr[i + j + 1] + mul;
                arr[i + j] += sum / 10;
                arr[i + j + 1] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            if (sb.length() == 0 && num == 0) {
                continue;
            }
            sb.append(num);
        }
        return (sb.length() == 0) ? "0" : sb.toString();
    }
}
