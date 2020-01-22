package prac_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n, cnt;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 }; // 상하좌우
	static int[] dy = { 1, -1, 0, 0 };
	static ArrayList<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		visited = new boolean[n][n];

		String[] str;
		for (int i = 0; i < n; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(str[j]);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == false && graph[i][j] == 1) {
					cnt = 1;
					//dfs(i, j);
					bfs(i, j);
					result.add(cnt);
				}
			}
		}

		Collections.sort(result);
		System.out.println(result.size()); // 단지수

		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i)); // 단지내 집 수
		}

		br.close();
	}

	public static void dfs(int y, int x) {
		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (graph[ny][nx] == 1 && visited[ny][nx] == false) {
					cnt++;
					dfs(ny, nx);
				}
			}
		}
	}

	public static void bfs(int y, int x) {
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.add(x);
		qy.add(y);
		visited[y][x] = true;

		int tmpx;
		int tmpy;

		while (!qx.isEmpty() && !qy.isEmpty()) {
			tmpx = qx.poll();
			tmpy = qy.poll();

			for (int i = 0; i < 4; i++) {
				x = tmpx + dx[i];
				y = tmpy + dy[i];

				if (x >= 0 && y >= 0 && x < n && y < n) {
					if (graph[y][x] == 1 && visited[y][x] == false) {
						cnt++;
						visited[y][x] = true;
						qx.add(x);
						qy.add(y);
					}
				}
			}
		}
	}

}
