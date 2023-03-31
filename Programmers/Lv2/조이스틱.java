/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 조이스틱 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42860
 */

class Solution {

    static int N;
    static int total;
    static int moveCount;

    public int solution(String name) {
        total = 0;
        N = name.length();
        moveCount = N - 1;

        int index = 0;
        for (int i=0; i<N; i++) {
            total += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i + 1;
            while (index < N && name.charAt(index) == 'A') {
                index++;
            }
            moveCount = Math.min(moveCount, (i * 2) + (N - index));
            moveCount = Math.min(moveCount, (N - index) * 2 + i);
        }

        return total + moveCount;
    }
}