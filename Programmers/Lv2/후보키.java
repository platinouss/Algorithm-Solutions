/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 후보키 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42890
 */

import java.util.*;

class Solution {

    static int N;
    static int M;
    static int count = 0;
    static int[] arr;
    static List<String> list = new ArrayList<>();

    public int solution(String[][] relation) {
        N = relation.length;
        M = relation[0].length;
        for (int k=1; k<=M; k++) {
            arr = new int[k];
            combination(0, 0, k, relation);
        }
        return count;
    }

    private static void combination(int depth, int index, int len, String[][] relation) {
        if (depth == len) {
            isCandidate(len, relation);
            return;
        }
        for (int i=index; i<M; i++) {
            arr[depth] = i;
            combination(depth + 1, i + 1, len, relation);
        }
    }

    private static boolean isCandidate(int len, String[][] relation) {
        String fieldIndex = "";
        for (int index : arr) {
            fieldIndex += String.valueOf(index);
        }
        for (String index : list) {
            int cnt = 0;
            for (char c : index.toCharArray()) {
                if (fieldIndex.contains(String.valueOf(c))) {
                    cnt++;
                }
            }
            if (cnt == index.length()) {
                return false;
            }
        }

        Set<String> set = new HashSet<>();
        for (int i=0; i<N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<len; j++) {
                sb.append(relation[i][arr[j]]).append(" ");
            }
            set.add(sb.toString());
        }
        if (set.size() < N) {
            return false;
        }
        count++;
        list.add(fieldIndex);
        return true;
    }
}