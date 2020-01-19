package prac_1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static int[] color; // color: 1, -1
	static boolean[] visited;
	static boolean chk;
	static int v, e;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			String[] str = br.readLine().split(" ");
			v = Integer.parseInt(str[0]); // 정점
			e = Integer.parseInt(str[1]); // 간선

			graph = new ArrayList<>();
			visited = new boolean[v + 1];
			color = new int[v + 1];

			for (int j = 1; j <= v; j++) {
				graph.add(new ArrayList<>());
			}

			while (e-- > 0) {
				str = br.readLine().split(" ");
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);

				graph.get(a).add(b);
				graph.get(b).add(a);
			}

			for (int j = 1; j <= v; j++) {
				if (!chk)
					break;

				if (visited[j] == false) {
					color[j] = 1;
					dfs(j, 1);
				}
			}
		}
		System.out.println(chk ? "YES" : "NO");
		br.close();
	}

	public static void dfs(int node, int col) {
		for (int i = 1; i <= v; i++) {
			if (color[i] == col) {
				chk = false;
				return;
			}

			if (visited[i] == false && graph.get(node).get(i) != col) {
				visited[i] = true;
				dfs(i, -col);
			}
		}

	}
}
