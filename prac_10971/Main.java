package prac_10971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] w;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE; // Integer의 최대값을 min으로 세팅
	static int start = 0; 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		w = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			start = i;
			solve(i, i, 0, 0);
		}
		System.out.println(min);

		br.close();
	}

	private static void solve(int x, int y, int len, int sum) {
		if (len == n && start == y) {
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			// y->i로 갈 수 없는 경우 0값을 가지고있다.
			// 따라서 y==i 일 경우만 체크해주면 틀린 값을 얻게된다.
			if (w[y][i] == 0)
				continue;
			if (sum + w[y][i] > min)
				continue;
			visited[i] = true;
			solve(y, i, len + 1, sum + w[y][i]);
			visited[i] = false;
		}
	}

}
