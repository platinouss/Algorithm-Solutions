/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 단어 변환 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43163
 */


import java.util.*;

class Solution {

    static Map<String, Integer> map = new HashMap<>();

    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }

    private static int bfs(String begin, String target, String[] words) {
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        map.put(begin, 0);

        int result = 0;
        while (!q.isEmpty()) {
            String before = q.remove();
            if (target.equals(before)) {
                result = map.get(before);
                break;
            }
            for (int i=0; i<words.length; i++) {
                if (isDifferentOne(before, words[i]) && !map.containsKey(words[i])) {
                    q.add(words[i]);
                    map.put(words[i], map.get(before) + 1);
                }
            }
        }
        return result;
    }

    private static boolean isDifferentOne (String s1, String s2) {
        int count = 0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        if (count > 1 || count == 0) {
            return false;
        }
        return true;
    }
}