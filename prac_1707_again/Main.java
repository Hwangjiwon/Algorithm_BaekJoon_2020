package prac_1707_again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static boolean chk;
	static int v, e;
	static int[] color; // color: 1, -1

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			String[] str = br.readLine().split(" ");
			v = Integer.parseInt(str[0]); // 정점
			e = Integer.parseInt(str[1]); // 간선

			graph = new ArrayList<>();
			color = new int[v + 1];
			chk = true;

			for (int j = 0; j <= v; j++) {
				graph.add(new ArrayList<Integer>());
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

				if (color[i] == 0) {
					dfs(i, 1);
				}
			}
			System.out.println(chk ? "YES" : "NO");
		}
		br.close();
	}

	public static void dfs(int node, int c) {
		color[node] = c;

		for (int adjNode : graph.get(node)) {
			if (color[adjNode] == c) {
				chk = false;
				return;
			}

			if (color[adjNode] == 0) { // not visited
				dfs(adjNode, -c);
			}
		}

	}
}
