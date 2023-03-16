/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : [3차] 방금그곡 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17683
 */

import java.util.*;

class Solution {

    static List<Music> list = new ArrayList<>();

    public String solution(String m, String[] musicinfos) {
        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            Music music = getPlayTime(info[0], info[1], info[2]);

            String newM = makeSharp(m);
            String newMusic = makeSharp(info[3]);

            int v = newMusic.length();
            StringBuilder sb = new StringBuilder();
            if (music.playTime < v) {
                sb.append(newMusic.substring(0, music.playTime + 1));
            } else if (music.playTime > v) {
                int depth = music.playTime / v;
                while (depth-- > 0) {
                    sb.append(newMusic);
                }
                sb.append(newMusic.substring(0, music.playTime % v));
            } else {
                sb.append(newMusic);
            }

            if (sb.toString().contains(newM)) {
                list.add(music);
            }
        }

        if (list.size() == 0) {
            return "(None)";
        }

        Collections.sort(list);

        return list.get(0).title;
    }

    private static int sToInt(String s) {
        return Integer.parseInt(s);
    }

    private static Music getPlayTime(String t1, String t2, String title) {
        String[] time1 = t1.split(":");
        String[] time2 = t2.split(":");

        int d = calculateTime(sToInt(time1[0]), sToInt(time1[1]), sToInt(time2[0]), sToInt(time2[1]));
        return new Music(d, title);
    }

    private static int calculateTime(int h1, int m1, int h2, int m2) {
        return ((h2 * 60) + m2) - ((h1 * 60) + m1);
    }

    private static String makeSharp(String s) {
        StringBuilder music = new StringBuilder(s);
        for (int i=0; i<music.length(); i++) {
            if (music.charAt(i) == '#') {
                music.setCharAt(i-1, Character.toLowerCase(music.charAt(i-1)));
                music.deleteCharAt(i);
            }
        }
        return music.toString();
    }
}

class Music implements Comparable<Music> {
    int playTime;
    String title;

    public Music(int playTime, String title) {
        this.playTime = playTime;
        this.title = title;
    }

    @Override
    public int compareTo(Music m) {
        return m.playTime - this.playTime;
    }
}