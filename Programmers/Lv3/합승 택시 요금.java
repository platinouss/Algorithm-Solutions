/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 합승 택시 요금 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/72413
 */


import java.util.*;

class Solution {

    static final int MAX_VALUE = 20_000_001;

    static int[][] arr;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        arr = new int[n + 1][n + 1];
        for (int i=0; i<=n; i++) {
            Arrays.fill(arr[i], MAX_VALUE);
            arr[i][i] = 0;
        }

        for (int[] fare : fares) {
            arr[fare[0]][fare[1]] = fare[2];
            arr[fare[1]][fare[0]] = fare[2];
        }

        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int total = arr[s][a] + arr[s][b];
        for (int i=1; i<=n; i++) {
            total = Math.min(total, arr[s][i] + arr[i][a] + arr[i][b]);
        }

        return total;
    }
}