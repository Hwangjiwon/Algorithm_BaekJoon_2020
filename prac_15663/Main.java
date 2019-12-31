package prac_15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] a;
	static HashSet<String> h = new HashSet<String>();
	static int visited[] = new int[10001];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			visited[a[i]]++;
		}

		Arrays.sort(a);

		dfs(0, "");

		br.close();
	}

	public static void dfs(int len, String str) {
		if (len == m) {
			if (!h.contains(str)) {
				h.add(str);
				System.out.println(str);
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[a[i]] > 0) {
				visited[a[i]]--;
				dfs(len + 1, str + a[i] + " ");
				visited[a[i]]++;
			}
		}
	}

}
