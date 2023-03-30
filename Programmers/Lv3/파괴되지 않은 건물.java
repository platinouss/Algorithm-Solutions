/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 파괴되지 않은 건물 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/92344
 */

import java.util.*;

class Solution {

    static int N;
    static int M;
    static int[][] arr;

    public int solution(int[][] board, int[][] skill) {
        N = board.length;
        M = board[0].length;
        arr = new int[N + 1][M + 1];
        for (int[] s : skill) {
            if (s[0] == 1) {
                arr[s[1]][s[2]] -= s[5];
                arr[s[1]][s[4] + 1] += s[5];
                arr[s[3] + 1][s[2]] += s[5];
                arr[s[3] + 1][s[4] + 1] -= s[5];
            } else {
                arr[s[1]][s[2]] += s[5];
                arr[s[1]][s[4] + 1] -= s[5];
                arr[s[3] + 1][s[2]] -= s[5];
                arr[s[3] + 1][s[4] + 1] += s[5];
            }
        }

        for (int i=0; i<=N; i++) {
            for (int j=0; j<M; j++) {
                arr[i][j+1] += arr[i][j];
            }
        }
        for (int j=0; j<=M; j++) {
            for (int i=0; i<N; i++) {
                arr[i+1][j] += arr[i][j];
            }
        }
        int count = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                board[i][j] += arr[i][j];
                if (board[i][j] > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}