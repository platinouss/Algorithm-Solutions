import java.util.*;
import java.io.*;

class Main {

    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardSize = Integer.parseInt(br.readLine());
        cards = new int[cardSize];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<cardSize; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<count; i++) {
            if (hasNumber(Integer.parseInt(st.nextToken()))) { sb.append("1 "); }
            else { sb.append("0 "); }
        }

        System.out.println(sb.toString());
    }

    public static boolean hasNumber(int value) {
        int sIndex = 0;
        int eIndex = cards.length - 1;

        while (sIndex <= eIndex) {
            int mid = (sIndex + eIndex) / 2;
            if (cards[mid] > value) {
                eIndex = mid - 1;
            }

            if (cards[mid] < value) {
                sIndex = mid + 1;
            }

            if (cards[mid] == value) {
                return true;
            }
        }

        return false;
    }
}