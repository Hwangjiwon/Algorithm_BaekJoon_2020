package prac_15661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[] visited;
	static int[][] s;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		StringTokenizer st;
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, "");

		br.close();
	}

	public static void dfs(int len, String str) {
		if (len == n) {
			System.out.println(str);
			return;
		}

		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(len + 1, str + i + "");
				visited[i] = false;
			}
		}
	}
}
