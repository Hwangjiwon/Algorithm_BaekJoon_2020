package prac_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int l; // r
	static int c; // n
	static String[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new String[c];
		visited = new boolean[c];
		String str = br.readLine();
		for (int i = 0; i < c; i++) {
			arr[i] = String.valueOf(str.charAt(i * 2));
		}

		Arrays.sort(arr);

		dfs(0, 0, "");
		br.close();
	}

	public static void dfs(int n, int r, String str) {
		if (r == l) {
			System.out.println(str);
			return;
		}

		for (int i = 0; i < c; i++) {
			if (arr[i].compareTo(arr[r]) < 0)
				continue;
			if (!visited[i]) {
				visited[i] = true;
				dfs(n + 1, r + 1, str + arr[i]);
				visited[i] = false;
			}
		}
	}

}
