/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 단체사진 찍기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/1835
 */

import java.util.*;

class Solution {

    static int count;
    static boolean[] visited;
    static Map<Character, Integer> map;
    static char[] persons = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

    public int solution(int n, String[] data) {
        count = 0;
        map = new HashMap<>();
        visited = new boolean[8];
        combination(0, data);
        return count;
    }

    private static boolean isCorrect(String[] data) {
        for (String str : data) {
            char c1 = str.charAt(0);
            char c2 = str.charAt(2);
            char oper = str.charAt(3);
            int num = str.charAt(4) - '0';

            int distance = Math.abs(map.get(c1) - map.get(c2)) - 1;
            if (oper == '=' && distance != num) {
                return false;
            }
            if (oper == '<' && distance >= num) {
                return false;
            }
            if (oper == '>' && distance <= num) {
                return false;
            }
        }
        return true;
    }

    private static void combination(int depth, String[] data) {
        if (depth == 8) {
            if (isCorrect(data)) {
                count++;
            }
            return;
        }
        for (int i=0; i<8; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            map.put(persons[i], depth);
            combination(depth + 1, data);
            visited[i] = false;
        }
    }
}