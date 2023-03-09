/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 베스트앨범 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42579
 */

import java.util.*;

class Solution {

    static Map<String, Integer> counts = new HashMap<>();
    static Map<String, List<Node>> musics = new HashMap<>();

    public int[] solution(String[] genres, int[] plays) {
        int N = genres.length;
        for (int i=0; i<N; i++) {
            String genre = genres[i];
            counts.put(genre, counts.getOrDefault(genre, 0) + plays[i]);
            if (!musics.containsKey(genre)) {
                musics.put(genre, new ArrayList<Node>());
            }
            musics.get(genre).add(new Node(i, plays[i]));
        }

        List<String> list = new ArrayList<>(counts.keySet());
        Collections.sort(list, (o1, o2) -> {
            return counts.get(o2) - counts.get(o1);
        });

        int index = 0;
        List<Integer> tmp = new ArrayList<>();
        for (String genre : list) {
            List<Node> music = musics.get(genre);
            Collections.sort(music, (o1, o2) -> {
                return o2.plays - o1.plays;
            });
            for (int i=0; i<Math.min(music.size() , 2); i++) {
                tmp.add(music.get(i).index);
            }
        }
        int[] answer = new int[tmp.size()];
        for (int i=0; i<tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }
        return answer;
    }
}

class Node {
    int index, plays;

    public Node(int i, int p) {
        this.index = i;
        this.plays = p;
    }
}