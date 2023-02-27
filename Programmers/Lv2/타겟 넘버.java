/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 타겟 넘버 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */

class Solution {

    static int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }

    private static void dfs(int index, int value, int[] numbers, int target) {
        if (index == numbers.length) {
            if (value == target) {
                answer++;
            }
            return;
        }
        dfs(index + 1, value + numbers[index], numbers, target);
        dfs(index + 1, value - numbers[index], numbers, target);
    }
}