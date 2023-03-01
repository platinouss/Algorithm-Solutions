/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 압축 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17684
 */

import java.util.*;

class Solution {

    static List<Integer> list = new ArrayList<>();
    static Map<String, Integer> indexes = new HashMap<>();

    public int[] solution(String msg) {
        int count = 1;
        for (char c='A'; c<='Z'; c++) {
            indexes.put(String.valueOf(c), count++);
        }
        for (int i=0; i<msg.length(); i++) {
            String str = String.valueOf(msg.charAt(i));
            for (int j=i+1; j<msg.length(); j++) {
                String tmp = str + msg.charAt(j);
                if (indexes.containsKey(tmp)) {
                    str += msg.charAt(j);
                    if (j == msg.length() - 1) {
                        i = j;
                    }
                    continue;
                }
                indexes.put(tmp, count++);
                i = j-1;
                break;
            }
            list.add(indexes.get(str));
        }

        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}