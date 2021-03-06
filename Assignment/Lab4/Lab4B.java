//  Achievement: 0%
//  Weight Center of a Tree

import java.util.*;
import java.io.*;

public class Lab4B {
    public static void main(String[] args) {
        int num = sk.nextInt();
        int[] w = new int[num+1];
        int[] s = new int[num+1];
        boolean[] traversed = new boolean[num+1];
        for (int i = 1; i <= num; i++) {
            w[i] = sk.nextInt();
        }
        LinkedList[] graph = new LinkedList[num+1];
        for (int i = 1; i <= num; i++) {
            graph[i] = new LinkedList<Integer>();
        }
        for (int i = 1; i < num; i++) {
            int tmp1 = sk.nextInt();
            int tmp2 = sk.nextInt();
            graph[tmp1].add(tmp2);
            graph[tmp2].add(tmp1);
        }
        
        Stack stack = new Stack<Integer>();
        stack.push(1);
        traversed[1] = true;
        while(!stack.empty()) {
            int cur = (int)stack.pop();
            if (!traversed[cur]) {
                traversed[cur] = true;
                for (Iterator iter = graph[cur].iterator(); iter.hasNext();) {
                    s[cur] += s[(int)iter.next()];
                }
                s[cur] += w[cur];
            }
            for (Iterator iter = graph[cur].iterator(); iter.hasNext();) {
                int tmp = (int)iter.next();
                if (!traversed[tmp]) {
                    traversed[tmp] = true;
                    stack.push(tmp);
                }
            }
        }

        Arrays.sort(s);
    }

    private static QuickReader sk = new QuickReader(System.in);

    private static class QuickReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public QuickReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }
}