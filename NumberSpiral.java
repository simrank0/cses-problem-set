import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberSpiral {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int t = in.nextInt();
        while (t-- > 0) {
            long x = in.nextLong();
            long y = in.nextLong();
            long ans;
            if (x < y) {
                if (y % 2 == 0) ans = (y - 1) * (y - 1) + x;
                else ans = y * y - x + 1;
            } else {
                if (x % 2 == 0) ans = x * x - y + 1;
                else ans = (x - 1) * (x - 1) + y;
            }
            System.out.println(ans);
        }
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
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
