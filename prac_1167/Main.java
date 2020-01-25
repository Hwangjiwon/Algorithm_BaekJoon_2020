package prac_1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Edge {
		int to;
		int cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	static ArrayList<ArrayList<Edge>> tree;
	static boolean[] visited;
	static int[] dist;
	static int max, max_idx = 1;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		tree = new ArrayList<ArrayList<Edge>>();
		visited = new boolean[n + 1];
		dist = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<Edge>());
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			while (true) {
				int to = Integer.parseInt(st.nextToken());
				if (to == -1)
					break;
				int cost = Integer.parseInt(st.nextToken());
				tree.get(from).add(new Edge(to, cost));
			}
		}

		bfs(1);
		//dfs(1);
		
		Arrays.fill(visited, false);
		Arrays.fill(dist, 0);
		bfs(max_idx);
		//dfs(max_idx);
		
		System.out.println(max);
		br.close();
	}

	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int from = q.poll();
			for (Edge e : tree.get(from)) {
				int to = e.to;
				int cost = e.cost;

				if (!visited[to]) {
					q.add(to);
					visited[to] = true;
					dist[to] = dist[from] + cost;

					if (max < dist[to]) {
						max = dist[to];
						max_idx = to;
					}
				}
			}
		}
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		
		for(Edge e : tree.get(start)) {
			int to = e.to;
			int cost = e.cost;
			
			if(!visited[to]) {
				dist[to] = dist[start] + cost;

				if (max < dist[to]) {
					max = dist[to];
					max_idx = to;
				}
				dfs(to);
			}
		}
	}
}
