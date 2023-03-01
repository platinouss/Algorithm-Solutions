/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 피로도 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */

class Solution {

    static int N;
    static int answer = 0;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        visited = new boolean[N];
        dfs(0, 0, k, dungeons);

        return answer;
    }

    private static void dfs(int depth, int index, int k, int[][] dungeons) {
        answer = Math.max(answer, depth);

        for (int i=0; i<N; i++) {
            if (visited[i] || dungeons[i][0] > k) {
                continue;
            }
            visited[i] = true;
            dfs(depth + 1, i+1, k - dungeons[i][1], dungeons);
            visited[i] = false;
        }
    }
}