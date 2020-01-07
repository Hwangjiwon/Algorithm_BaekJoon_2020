package prac_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int l; // r
	static int c; // n
	static char[] arr;
	static boolean[] visited;
	static int mo = 0;
	static int ja = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[c];
		visited = new boolean[c];
		String str = br.readLine();
		for (int i = 0; i < c; i++) {
			arr[i] = str.charAt(i * 2);
		}

		Arrays.sort(arr);

		dfs(0, 0, 0, "");
		br.close();
	}

	public static void dfs(int idx, int n, int r, String str) {
		if (r == l) {
			if (check(str) == true)
				System.out.println(str);
			return;
		}

		for (int i = 0; i < c; i++) {
			if(visited[i])
				continue;
			if (arr[i] >= arr[idx]) {
				visited[i] = true;
				dfs(i, n + 1, r + 1, str + arr[i]);
				visited[i] = false;
			}
		}
	}

	public static boolean check(String str) {
		ja = 0;
		mo = 0;
		for (int i = 0; i < l; i++) {
			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
					|| str.charAt(i) == 'u') // 모음 1개
				ja++;
			else // 자음 2개이상
				mo++;
		}

		if (ja >= 1 && mo >= 2)
			return true;
		else
			return false;
	}

}
