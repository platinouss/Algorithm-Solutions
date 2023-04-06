/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 혼자서 하는 틱택토 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/160585
 */

import java.util.*;

class Solution {

    static boolean finishO = false;
    static boolean finishX = false;
    static char[][] arr = new char[3][3];

    public int solution(String[] board) {
        for (int i=0; i<3; i++) {
            arr[i] = board[i].toCharArray();
        }
        int answer = (isCorrect()) ? 1 : 0;
        return answer;
    }

    private static boolean isCorrect() {
        int oCount = counting('O');
        int xCount = counting('X');
        checkFinish();
        if (oCount < xCount || (oCount - xCount) > 1) {
            return false;
        }
        if (finishO && finishX) {
            return false;
        }
        if (finishO && oCount != xCount + 1) {
            return false;
        }
        if (finishX && oCount != xCount) {
            return false;
        }
        return true;
    }

    private static void checkFinish() {
        if (arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2]) {
            setFinish(0, 0);
        }
        if (arr[0][2] == arr[1][1] && arr[0][2] == arr[2][0]) {
            setFinish(0, 2);
        }
        for (int i=0; i<3; i++) {
            if (arr[i][0] == arr[i][1] && arr[i][0] == arr[i][2]) {
                setFinish(i, 0);
            }
        }
        for (int j=0; j<3; j++) {
            if (arr[0][j] == arr[1][j] && arr[0][j] == arr[2][j]) {
                setFinish(0, j);
            }
        }
    }

    private static void setFinish(int a, int b) {
        if (arr[a][b] == 'O') { finishO = true; }
        else if (arr[a][b] == 'X') { finishX = true; }
    }

    private static int counting(char c) {
        int count = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (arr[i][j] == c) { count++; }
            }
        }
        return count;
    }
}
