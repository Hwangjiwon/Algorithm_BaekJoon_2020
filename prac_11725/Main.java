package prac_11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static ArrayList<ArrayList<Integer>> list;
	static int[] parents;
	static boolean[] visited;
	static int n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		list = new ArrayList<ArrayList<Integer>>();
		parents = new int[n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i <= n + 1; i++) {
			list.add(new ArrayList<Integer>());
		}

		String[] str;
		int a, b;
		for (int i = 1; i < n; i++) {
			str = br.readLine().split(" ");
			a = Integer.parseInt(str[0]);
			b = Integer.parseInt(str[1]);
			// 양방향 연결
			list.get(a).add(b);
			list.get(b).add(a);
		}

		dfs(1);
		//bfs(1);
		
		for (int i = 2; i <= n; i++) {
			System.out.println(parents[i]);
		}

		br.close();
	}

	public static void dfs(int start) {
		visited[start] = true;

		for (int i : list.get(start)) {
			if (!visited[i]) {
				parents[i] = start;
				dfs(i);
			}
		}
	}

	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		parents[start] = start;
		visited[start] = true;

		while (!q.isEmpty()) {
			int p = q.poll();

			for (int i : list.get(p)) {
				if (!visited[i]) {
					q.add(i);
					parents[i] = p;
					visited[i] = true;
				}
			}
		}

	}
}
