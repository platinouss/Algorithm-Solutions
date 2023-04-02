/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 숫자 블록 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12923
 */

class Solution {

    static int[] answer;

    public int[] solution(long begin, long end) {
        int d = (int) (end - begin);
        answer = new int[d + 1];

        int index = 0;
        if (begin == 1) {
            answer[index++] = 0;
        }
        for (int i=index; i<=d; i++) {
            answer[i] = (int) isPrime(begin + i);
            if (answer[i] == -1) {
                answer[i] = 1;
            }
        }

        return answer;
    }

    private static int isPrime(long v) {
        long answer = 0;
        for (long i=2L; i<=Math.sqrt(v); i++) {
            if (v % i == 0) {
                long result = v / i;
                if (result > 10_000_000L) {
                    answer = Math.max(answer, i);
                    continue;
                }
                answer = Math.max(answer, result);
            }
        }
        if (answer == 0) {
            answer = -1L;
        }
        return (int) answer;
    }
}