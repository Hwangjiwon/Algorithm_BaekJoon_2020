package prac_14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, r;
	static int[] arr;
	static boolean[] visited;
	static int[][] s;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		r = n / 2;
		s = new int[n][n];
		visited = new boolean[n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, "");
		System.out.println(min);
		br.close();
	}

	public static void dfs(int len, int idx, String str) {
		if (len == r) {
			//System.out.println(str);
			min = Math.min(min, getAbilityDifference());
			return;
		}

		for (int i = 0; i < n; i++) {
			if (i < idx)
				continue;
			if (!visited[i]) {
				visited[i] = true;
				dfs(len + 1, i, str + i);
				visited[i] = false;
			}
		}
	}

	public static int getAbilityDifference() {
		int sumStart = 0;
		int sumLink = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// true ¸é ½ºÅ¸Æ®ÆÀ
				if (visited[i] && visited[j])
					sumStart += s[i][j];

				// false ¸é ¸µÅ©ÆÀ
				if (visited[i] != true && visited[j] != true)
					sumLink += s[i][j];
			}
		}

		return Math.abs(sumStart - sumLink);
	}

}
