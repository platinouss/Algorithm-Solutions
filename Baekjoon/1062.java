/**
 * 백준 1062번 (골드 4)
 * 문제 이름 : 가르침
 * 알고리즘 분류 : 비트마스킹, 백트래킹
 * 링크 : https://www.acmicpc.net/problem/1062
 */

import java.io.*;
import java.util.*;

public class Main {

    static int answer;
    static int studyCount;
    static String[] arr;

    static final int ALPHABET_LEN = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        studyCount = Integer.parseInt(st.nextToken());

        arr = new String[count];
        for (int i=0; i<count; i++) {
            String tmp = br.readLine();
            arr[i] = tmp.substring(4, tmp.length() - 4);
        }

        if (studyCount == 26) { System.out.println(count); return; }
        studyCount -= 5;
        if (studyCount < 0) { System.out.println(0); return; }

        int bitmask = 0;
        bitmask |= (1 << 'a' - 'a') | (1 << 'c' - 'a') | (1 << 'i' - 'a') |
                (1 << 'n' - 'a') | (1 << 't' - 'a');

        answer = 0;
        dfs(0, 0, bitmask);

        System.out.println(answer);
    }

    private static void dfs(int count, int index, int bitmask) {
        if (count == studyCount) {
            int result = 0;
            for (String voca : arr) {
                if(isReadVoca(voca, bitmask)) { result++; }
            }
            answer = Math.max(answer, result);

            return;
        }

        for (int k=index; k<ALPHABET_LEN; k++) {
            if ((bitmask & (1 << k)) != 0) { continue; }
            dfs(count + 1, k + 1, bitmask | (1 << k));
        }
    }

    private static boolean isReadVoca(String voca, int bitmask) {
        for (int k=0; k<voca.length(); k++) {
            if ((bitmask & (1 << voca.charAt(k) - 'a')) == 0) { return false; }
        }

        return true;
    }
}