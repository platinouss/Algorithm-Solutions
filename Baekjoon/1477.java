import java.util.*;
import java.io.*;

class Main {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int count = Integer.parseInt(st.nextToken());
        int condition = Integer.parseInt(st.nextToken());
        int maxLength = Integer.parseInt(st.nextToken());

        list.add(0);
        list.add(maxLength);
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<count; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int index1 = 1;
        int index2 = maxLength;
        while (index1 <= index2) {
            int mid = (index1 + index2) / 2;
            if (isCorrect(mid, condition)) {
                index2 = mid - 1;
            } else{
                index1 = mid + 1;
            }
        }
        System.out.println(index1);
    }

    public static boolean isCorrect(int mid, int condition) {
        int cnt = 0;
        for (int i=1; i<list.size(); i++) {
            cnt += (list.get(i) - list.get(i-1) - 1) / mid;
        }
        return cnt <= condition;
    }
}