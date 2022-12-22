/**
 * 백준 2457번 (골드 3)
 * 문제 이름 : 공주님의 정원
 * 알고리즘 분류 : 그리디
 * 링크 : https://www.acmicpc.net/problem/2457
 */

import java.io.*;
import java.util.*;

public class Main {

    static class Data implements Comparable<Data> {
        int start, end;

        public Data(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Data d) {
            if (this.start == d.start) {
                return this.end - d.end;
            }
            return this.start - d.start;
        }
    }

    static final int START_DAY = 301;
    static final int END_DAY = 1201;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Data> list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            int[] date = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            list.add(new Data(date[0]*100 + date[1], date[2]*100 + date[3]));
        }

        Collections.sort(list);

        int sDay = START_DAY;
        int index = 0, tmpDay = 0, count = 0;
        while (sDay < END_DAY) {
            boolean isInclude = false;
            for (int i = index; i < N; i++) {
                if (list.get(i).start > sDay) {
                    break;
                }
                if (list.get(i).start <= sDay && tmpDay < list.get(i).end) {
                    tmpDay = list.get(i).end;
                    index = i + 1;
                    isInclude = true;
                }
            }
            if (isInclude) {
                sDay = tmpDay;
                count++;
            } else {
                break;
            }
        }

        if (tmpDay < END_DAY) {
            count = 0;
        }
        System.out.println(count);
    }
}