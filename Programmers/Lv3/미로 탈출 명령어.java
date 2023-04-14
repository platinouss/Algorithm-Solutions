/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 미로 탈출 명령어 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/150365
 */

class Solution {

    static int N, M;
    static Node exit;
    static String answer = null;
    static int[] di = {1, 0, 0, -1};
    static int[] dj = {0, -1, 1, 0};
    static String[] arr = {"d", "l", "r", "u"};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        exit = new Node(r-1, c-1, 0);
        int diff = Math.abs((x-1) - (r-1)) + Math.abs((y-1) - (c-1));
        dfs(k, x-1, y-1, diff, "");
        if (answer == null) {
            return "impossible";
        }
        return answer;
    }

    private static boolean dfs(int K, int a, int b, int diff, String str) {
        if (K == 0 && diff == 0) {
            answer = str;
            return true;
        }
        for (int k=0; k<4; k++) {
            int ii = a + di[k];
            int jj = b + dj[k];
            if (isOutOfRange(ii, jj) || diff > K) {
                continue;
            }
            if ((diff % 2 == 0 && K % 2 == 0) || ((diff % 2 == 1) && K % 2 == 1)) {
                int newDiff = Math.abs(exit.i - ii) + Math.abs(exit.j - jj);
                if (dfs(K - 1, ii, jj, newDiff, str + arr[k])) {
                    return true;
                }
            }

        }
        return false;
    }

    private static boolean isOutOfRange(int i, int j) {
        return i < 0 || i >= N || j < 0 || j >= M;
    }
}

class Node {
    int i, j, count;

    public Node(int i, int j, int count) {
        this.i = i;
        this.j = j;
        this.count = count;
    }
}