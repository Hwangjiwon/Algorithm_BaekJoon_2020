package prac_15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dfs(0, 0, "");

		br.close();
	}

	public static void dfs(int idx, int len, String str) {
		if (len == m) {
			System.out.println(str);
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (i >= idx)
				dfs(i, len + 1, str + i + " ");
		}
	}
}
