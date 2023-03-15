/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 행렬 테두리 회전하기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/77485
 */

class Solution {

    static int N;
    static int M;
    static int[][] arr;
    static int[] answer;

    public int[] solution(int rows, int columns, int[][] queries) {
        N = rows;
        M = columns;

        int v = 1;
        arr = new int[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                arr[i][j] = v++;
            }
        }

        answer = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            startGame(i, queries[i]);
        }

        return answer;
    }

    private static void startGame(int index, int[] query) {
        int min = N * M;
        int i1 = query[0] - 1;
        int j1 = query[1] - 1;
        int i2 = query[2] - 1;
        int j2 = query[3] - 1;
        int len = ((i2 - i1 + 1) * 2 + (j2 - j1 - 1) * 2);

        int idx = 0;
        int[] tmp = new int[len];
        for (int j=j1; j<=j2; j++) {
            tmp[idx++] = arr[i1][j];
        }
        for (int i=i1+1; i<i2; i++) {
            tmp[idx++] = arr[i][j2];
        }
        for (int j=j2; j>=j1; j--) {
            tmp[idx++] = arr[i2][j];
        }
        for (int i=i2-1; i>i1; i--) {
            tmp[idx++] = arr[i][j1];
        }

        idx = 0;
        for (int j=j1+1; j<j2; j++) {
            arr[i1][j] = tmp[idx++];
        }
        for (int i=i1; i<=i2; i++) {
            arr[i][j2] = tmp[idx++];
        }
        for (int j=j2-1; j>j1; j--) {
            arr[i2][j] = tmp[idx++];
        }
        for (int i=i2; i>=i1; i--) {
            arr[i][j1] = tmp[idx++];
        }

        for (int i=0; i<tmp.length; i++) {
            min = Math.min(min, tmp[i]);
        }

        answer[index] = min;
    }
}