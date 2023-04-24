/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 리틀 프렌즈 사천성 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/1836
 */

import java.util.*;

class Solution {
    static int N, M;
    static char[][] arr;
    static LinkedList<Character> list;
    static Map<Character, int[][]> map;

    public String solution(int m, int n, String[] board) {
        init(m, n);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                char c = board[i].charAt(j);
                arr[i][j] = c;
                if (c != '.' && c != '*'){
                    if (!list.contains(c)){
                        list.add(c);
                        map.put(c, new int[2][2]);
                        map.get(c)[0][0] = i;
                        map.get(c)[0][1] = j;
                    } else {
                        map.get(c)[1][0] = i;
                        map.get(c)[1][1] = j;
                    }
                }
            }
        }
        Collections.sort(list);

        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (list.size() != 0){
            if (canDeleteBlock(list.get(index))) {
                char alphabet = list.remove(index);
                sb.append(alphabet);
                delete(alphabet);
                index = 0;
            } else {
                index++;
                if (index == list.size()) {
                    return "IMPOSSIBLE";
                }
            }
        }
        return sb.toString();
    }

    private boolean canDeleteBlock(char c) {
        int i1 = map.get(c)[0][0], j1 = map.get(c)[0][1];
        int i2 = map.get(c)[1][0], j2 = map.get(c)[1][1];
        if (j1 < j2) {
            if (checkCol(j1, j2, i1, c) && checkRow(i1, i2, j2, c)) {
                return true;
            }
            if (checkRow(i1, i2, j1, c) && checkCol(j1, j2, i2, c)) {
                return true;
            }
        } else {
            if (checkRow(i1, i2, j2, c) && checkCol(j2, j1, i1, c)) {
                return true;
            }
            if (checkCol(j2, j1, i2, c) && checkRow(i1, i2, j1, c)) {
                return true;
            }
        }
        return false;
    }

    private void delete(char c) {
        arr[map.get(c)[0][0]][map.get(c)[0][1]] = '.';
        arr[map.get(c)[1][0]][map.get(c)[1][1]] = '.';
    }

    private boolean checkRow(int i1, int i2, int j, char c) {
        for(int i = i1; i <= i2; i++) {
            if(arr[i][j] != '.' && arr[i][j] != c)
                return false;
        }
        return true;
    }

    private boolean checkCol(int j1, int j2, int i, char c) {
        for (int j = j1; j <= j2; j++){
            if (arr[i][j] != '.' && arr[i][j] != c)
                return false;
        }
        return true;
    }

    private static void init(int m, int n) {
        N = m;
        M = n;
        arr = new char[N][M];
        map = new HashMap<>();
        list = new LinkedList<>();
    }
}