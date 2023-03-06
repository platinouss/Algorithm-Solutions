/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : [3차] 파일명 정렬 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17686
 */

import java.util.*;

class Solution {

    static class Node implements Comparable<Node> {
        public int index;
        public String name;

        public Node (int index, String name) {
            this.index = index;
            this.name = name;
        }

        @Override
        public int compareTo(Node n2) {
            String n1Head = getHead(this.name);
            String n2Head = getHead(n2.name);
            int n1Number = getNumber(this.name);
            int n2Number = getNumber(n2.name);

            if (n1Head.equals(n2Head)) {
                if (n1Number == n2Number) {
                    return this.index - n2.index;
                }
                return n1Number - n2Number;
            }
            if (!n1Head.equals(n2Head)) {
                return n1Head.compareTo(n2Head);
            }
            return 0;
        }
    }

    static List<Node> fileList = new ArrayList<>();

    public static String getHead(String name) {
        int sIndex = 0;
        for (sIndex=0; sIndex<name.length(); sIndex++) {
            char c = name.charAt(sIndex);
            if (Character.isDigit(c)) {
                break;
            }
        }
        return name.substring(0, sIndex);
    }

    public static int getNumber(String name) {
        int sIndex = 0;
        int eIndex = 0;
        for (eIndex =0; eIndex<name.length(); eIndex++) {
            char c = name.charAt(eIndex);
            if (sIndex == 0 && Character.isDigit(c)) {
                sIndex = eIndex;
            }
            if (sIndex != 0 && !Character.isDigit(c)) {
                break;
            }
        }
        return Integer.parseInt(name.substring(sIndex, eIndex));
    }

    public String[] solution(String[] files) {
        for (int i=0; i<files.length; i++) {
            fileList.add(new Node(i, files[i].toLowerCase()));
        }
        Collections.sort(fileList);

        String[] answer = new String[fileList.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = files[fileList.get(i).index];
        }
        return answer;
    }
}

