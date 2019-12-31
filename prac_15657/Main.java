package prac_15657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		dfs(0, 0, "");

		br.close();
	}

	public static void dfs(int idx, int len, String str) {
		if (len == m) {
			System.out.println(str);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (idx <= arr[i])
				dfs(arr[i], len + 1, str + arr[i] + " ");
		}
	}

}
