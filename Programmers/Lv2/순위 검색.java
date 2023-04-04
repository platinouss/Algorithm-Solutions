/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 순위 검색 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/72412
 */

import java.util.*;

class Solution {

    static Map<String, List<Integer>> infos = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        for (String in : info) {
            String[] tmp = in.split(" ");
            int score = Integer.parseInt(tmp[4]);
            for (int i=0; i<(1 << 4); i++) {
                StringBuilder sb = new StringBuilder();
                for (int j=0; j<4; j++) {
                    if ((i & (1 << j)) > 0) { sb.append(tmp[j]); }
                }
                if (!infos.containsKey(sb.toString())) {
                    infos.put(sb.toString(), new ArrayList<>());
                }
                infos.get(sb.toString()).add(score);
            }
        }
        for (String key : infos.keySet()) {
            Collections.sort(infos.get(key));
        }
        List<Integer> tmp = new ArrayList<>();
        int[] answer = new int[query.length];
        for (int i=0; i<query.length; i++) {
            String[] tmp1 = query[i].replaceAll("-", "").split(" and ");
            String[] tmp2 = tmp1[3].split(" ");
            String key = String.join("", tmp1[0], tmp1[1], tmp1[2], tmp2[0]);
            int score = Integer.parseInt(tmp2[1]);

            List<Integer> list = infos.getOrDefault(key, tmp);
            int sIndex = 0, eIndex = list.size();
            while (sIndex < eIndex) {
                int mid = (sIndex + eIndex) / 2;
                if (list.get(mid) < score) {
                    sIndex = mid + 1;
                } else {
                    eIndex = mid;
                }
            }
            answer[i] = list.size() - sIndex;
        }

        return answer;
    }
}