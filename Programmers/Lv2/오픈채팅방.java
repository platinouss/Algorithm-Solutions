/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 오픈채팅방 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42888
 */

import java.util.*;

class Solution {

    static Map<String, String> users = new HashMap<>();

    public String[] solution(String[] record) {
        for (String str : record) {
            String[] arr = str.split(" ");
            if (!arr[0].equals("Leave")) {
                users.put(arr[1], arr[2]);
            }
        }

        List<String> list = new ArrayList<>();
        for (int i=0; i<record.length; i++) {
            String[] arr = record[i].split(" ");
            if (arr[0].equals("Leave")) {
                list.add(outChattingRoom(arr[1]));
            } else if (arr[0].equals("Enter")) {
                list.add(inChattingRoom(arr[1]));
            }
        }

        return list.stream().toArray(array -> new String[list.size()]);
    }

    private String inChattingRoom(String id) {
        return users.get(id) + "님이 들어왔습니다.";
    }

    private String outChattingRoom(String id) {
        return users.get(id) + "님이 나갔습니다.";
    }
}