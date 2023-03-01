/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 튜플 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/64065
 */

import java.util.*;

class Solution {

    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public int[] solution(String s) {
        sb.append(s);
        sb = sb.delete(0, 2);
        sb = sb.delete(sb.length()-2, sb.length());

        String[] sets = sb.toString().replace("},{", "-").split("-");
        int[] answer = new int[sets.length];

        Arrays.sort(sets, (o1, o2) -> {
            return o1.length() - o2.length();
        });

        int index = 0;
        for (String str : sets) {
            String[] strings = str.split(",");
            for (String string : strings) {
                int v = Integer.parseInt(string);
                if (!set.contains(v)) {
                    answer[index++] = v;
                    set.add(v);
                    break;
                }
            }
        }

        return answer;
    }
}