import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PalindromeReorder {

    public static void main(String[] args) {

        FastReader in = new FastReader();

        String s = in.next();

        int[] ch = new int[26];

        for (char c : s.toCharArray()) ch[c - 'A']++;

        int odd = 0;
        for (int i : ch) {
            odd += i % 2 == 1 ? 1 : 0;
        }

        if (odd > 1) {
            System.out.println("NO SOLUTION");
            System.exit(0);
        }

        Deque<Character> dq = new ArrayDeque<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 26; i++) {
            if (ch[i] % 2 == 1) {
                for(int x = 0; x<ch[i]; x++) dq.addFirst((char) (65 + i));
            } else {
                for(int x = 0; x<ch[i]/2; x++) {
                    dq.addLast((char) (65 + i));
                    if(x==0) q.add(i);
                }
            }
        }

        for (Integer integer : q) {
            int a = integer;
            for (int j = 0; j < ch[a] / 2; j++) {
                dq.addFirst((char) (a + 65));
            }
        }

        StringBuilder ans = new StringBuilder();

        dq.forEach(ans::append);

        System.out.println(ans);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
