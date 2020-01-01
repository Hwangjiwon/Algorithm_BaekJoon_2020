package prac_15664;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n, m;
	static ArrayList<Integer> a;
	static int visited[] = new int[10001];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Set<Integer> s = new TreeSet<Integer>();
		for (int i = 0; i < n; i++) {
			int t = Integer.parseInt(st.nextToken());
			s.add(t);
			visited[t]++;
		}

		a = new ArrayList<Integer>(s);

		dfs(0, 0, "");

		br.close();
	}

	public static void dfs(int idx, int len, String str) {
		if (len == m) {
			System.out.println(str);
			return;
		}

		for (int i = 0; i < a.size(); i++) {
			if (visited[a.get(i)] > 0) {
				visited[a.get(i)]--;
				dfs(a.get(i), len + 1, str + a.get(i) + " ");
				visited[a.get(i)]++;
			}
		}
	}

}