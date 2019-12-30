package prac_15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		n = Integer.parseInt(tok.nextToken());
		m = Integer.parseInt(tok.nextToken());
		visited = new boolean[n + 1];
		
		dfs(0, "");

		br.close();
	}

	public static void dfs(int len, String str) {
		if (m == len) {
			System.out.println(str);
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(len + 1, str + i + " ");
				visited[i] = false;
			}
		}
	}
}
