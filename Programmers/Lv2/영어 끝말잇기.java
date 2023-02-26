/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 짝지어 제거하기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12981
 */

import java.util.*;

class Solution {

    static Set<String> set = new HashSet<>();

    public int[] solution(int n, String[] words) {
        set.add(words[0]);

        int number = 0;
        int order = 0;
        for (int count=1; count<words.length; count++) {
            String beforeWord = words[count - 1];
            String nowWord = words[count];
            char beforeLast = beforeWord.charAt(beforeWord.length() - 1);
            char nowFirst = nowWord.charAt(0);
            if (beforeLast != nowFirst || set.contains(nowWord)) {
                number = count % n + 1;
                order = count / n + 1;
                break;
            }
            set.add(nowWord);
        }

        int[] answer = {number, order};
        return answer;
    }
}