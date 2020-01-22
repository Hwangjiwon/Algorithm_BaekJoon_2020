package prac_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n, m;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]); // y√‡
		m = Integer.parseInt(str[1]); // x√‡

		graph = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];

		for (int i = 0; i < n; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				graph[i+1][j+1] = Integer.parseInt(str[j]);
			}
		}

		visited[1][1] = true;
		bfs(1,1);
		
		System.out.println(graph[n][m]);
	
		br.close();
	}

	public static void bfs(int y, int x) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		
		qx.add(x);
		qy.add(y);

		int tmpx;
		int tmpy;

		while (!qx.isEmpty() && !qy.isEmpty()) {
			tmpx = qx.poll();
			tmpy = qy.poll();

			for (int i = 0; i < 4; i++) {
				x = tmpx + dx[i];
				y = tmpy + dy[i];

				if (x >= 1 && y >= 1 && x <= m && y <= n) {
					if (graph[y][x] == 1 && visited[y][x] == false) {
						qx.add(x);
						qy.add(y);
					
						graph[y][x] = graph[tmpy][tmpx] + 1;
						visited[y][x] = true;
					}
				}
			}

		}
	}
}
