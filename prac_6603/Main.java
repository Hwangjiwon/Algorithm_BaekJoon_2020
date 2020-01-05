package prac_6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int[] s;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			s = new int[k];
			visited = new boolean[k];

			if (k == 0)
				break;

			for (int i = 0; i < k; i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(s);
			dfs(0, 0, "");
			System.out.println();
		}

		br.close();
	}

	public static void dfs(int idx, int len, String str) {
		if (len == 6) {
			System.out.println(str);
			return;
		}
		for (int i = 0; i < k; i++) {
			if (s[i] > idx)
				dfs(s[i], len + 1, str + s[i] + " ");
		}
	}
}
