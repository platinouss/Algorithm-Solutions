/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 가장 큰 정사각형 찾기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12905
 */

import java.util.*;

class Solution {

    static int max = 0;

    public int solution(int[][] board) {
        int N = board.length;
        int M = board[0].length;
        if (N == 1 && M == 1) {
            if (board[0][0] == 1) {
                return 1;
            }
        }

        for (int i=1; i<N; i++) {
            for (int j=1; j<M; j++) {
                if (board[i][j] == 1) {
                    int min = Math.min(board[i-1][j], Math.min(board[i][j-1], board[i-1][j-1]));
                    board[i][j] = min + 1;
                    max = Math.max(max, board[i][j]);
                }
            }
        }

        return max * max;
    }
}