/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 네트워크 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43162
 */

class Solution {

    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i=0; i<n; i++) {
            if (visited[i]) {
                continue;
            }
            answer++;
            dfs(i, n, computers);
        }
        return answer;
    }

    private static void dfs(int index, int n, int[][] computers) {
        if (visited[index]) {
            return;
        }
        visited[index] = true;
        for (int i=0; i<n; i++) {
            if (visited[i]) {
                continue;
            }
            if (computers[index][i] == 1) {
                dfs(i, n, computers);
            }
        }
    }
}