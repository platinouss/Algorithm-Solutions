/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 소수 찾기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42839
 */

import java.util.*;

class Solution {

    static int N;
    static int answer = 0;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        N = numbers.length();
        visited = new boolean[N];
        for (int i=0; i<N; i++) {
            visited[i] = true;
            dfs(1, String.valueOf(numbers.charAt(i)), numbers);
            visited[i] = false;
        }

        return answer;
    }

    private static void dfs(int depth, String value, String numbers) {
        if (depth == numbers.length()) {
            int number = Integer.parseInt(value);
            if (!set.contains(number) && isPrime(number)) {
                set.add(number);
                answer++;
            }
            return;
        }
        int number = Integer.parseInt(value);
        if (!set.contains(number) && isPrime(number)) {
            set.add(number);
            answer++;
        }
        for (int i=0; i<N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(depth + 1, value + numbers.charAt(i), numbers);
            visited[i] = false;
        }
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i=2; i<=Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}