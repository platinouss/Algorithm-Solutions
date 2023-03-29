/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 연속 펄스 부분 수열의 합 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/161988
 */

class Solution {

    static long[] plusSum;
    static long[] minusSum;
    static long result = 0;

    public long solution(int[] sequence) {
        int N = sequence.length;
        plusSum = new long[N + 1];
        minusSum = new long[N + 1];

        int mul = 1;
        for (int i=0; i<N; i++) {
            plusSum[i + 1] = plusSum[i] + (sequence[i] * mul);
            mul *= -1;
            minusSum[i + 1] = minusSum[i] + (sequence[i] * mul);
        }

        twoPointer(N, plusSum);
        twoPointer(N, minusSum);
        return result;
    }

    private static void twoPointer(int N, long[] sumArr) {
        int sIndex = 0;
        int eIndex = 1;
        while (eIndex <= N) {
            long sum = sumArr[eIndex] - sumArr[sIndex];
            if (sum >= 0) {
                result = Math.max(result, sum);
                eIndex++;
            } else {
                sIndex = eIndex;
                eIndex++;
            }
        }
    }
}