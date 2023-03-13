/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 메뉴 리뉴얼 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/72411
 */

import java.util.*;

class Solution {

    static Map<String, Integer> map;
    static List<String> result = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {
        orderString(orders);
        for (int len : course) {
            map = new HashMap<>();
            for (String order : orders) {
                makeVoca(0, 0, "", len, order);
            }
            selectVoca();
        }

        Collections.sort(result);

        String[] answer = new String[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    private static void orderString(String[] orders) {
        for (int i=0; i<orders.length; i++) {
            String voca = orders[i];
            char[] alphabets = voca.toCharArray();

            Arrays.sort(alphabets);

            orders[i] = new String(alphabets);
        }
    }

    private static void makeVoca(int depth, int index, String voca, int len, String order) {
        if (depth == len) {
            map.put(voca, map.getOrDefault(voca, 0) + 1);
            return;
        }
        for (int i=index; i<order.length(); i++) {
            makeVoca(depth + 1, i + 1, voca + order.charAt(i), len, order);
        }
    }

    private static void selectVoca() {
        if (map.size() == 0) {
            return;
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> {
            return map.get(o2) - map.get(o1);
        });
        int max = map.get(list.get(0));
        if (max < 2) {
            return;
        }
        for (String voca : list) {
            if (map.get(voca) < max) {
                break;
            }
            result.add(voca);
        }
    }
}