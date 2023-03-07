/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 덧칠하기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/161989
 */

class Solution {

    static boolean[] visited;

    public int solution(int n, int m, int[] section) {
        visited = new boolean[n + 1];
        int count = 0;
        for (int v : section) {
            if (!visited[v]) {
                for (int i=v; i<v+m; i++) {
                    if (i > n) {
                        continue;
                    }
                    visited[i] = true;
                }
                count++;
            }
        }

        return count;
    }
}