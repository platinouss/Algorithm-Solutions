/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 거리두기 확인하기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/81302
 */

import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int index = 0;
        int[] answer = new int[places.length];
        for (String[] place : places) {
            List<Node> persons = new ArrayList<>();
            char[][] arr = new char[place.length][place[0].length()];
            for (int i=0; i<place.length; i++) {
                for (int j=0; j<place[0].length(); j++) {
                    arr[i][j] = place[i].charAt(j);
                    if (arr[i][j] == 'P') {
                        persons.add(new Node(i, j));
                    }
                }
            }
            if (isCorrect(arr, persons)) {
                answer[index] = 1;
            } else {
                answer[index] = 0;
            }
            index++;
        }
        return answer;
    }

    private static boolean isCorrect(char[][] arr, List<Node> persons) {
        for (int i=0; i<persons.size()-1; i++) {
            for (int j=i+1; j<persons.size(); j++) {
                Node n1 = persons.get(i);
                Node n2 = persons.get(j);
                int distance = Math.abs(n1.i - n2.i) + Math.abs(n1.j - n2.j);
                if (distance > 2) {
                    continue;
                } else if (distance == 1) {
                    return false;
                } else {
                    if (n1.i == n2.i) {
                        boolean check = false;
                        for (int b=n1.j+1; b<n2.j; b++) {
                            if (arr[n1.i][b] == 'X') {
                                check = true;
                            }
                        }
                        if (!check) {
                            return false;
                        }
                    } else if (n1.j == n2.j) {
                        boolean check = false;
                        for (int a=n1.i+1; a<n2.i; a++) {
                            if (arr[a][n1.j] == 'X') {
                                check = true;
                            }
                        }
                        if (!check) {
                            return false;
                        }
                    } else {
                        if (arr[n1.i][n2.j] != 'X' || arr[n2.i][n1.j] != 'X') {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}

class Node {
    int i, j;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}