package prac_4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int w, h, cnt;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1, -1, -1, 1, 1 }; // 상하좌우 좌상 좌하 우상 우하
	static int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str;
		while (true) {
			str = br.readLine().split(" ");
			w = Integer.parseInt(str[0]); // 너비
			h = Integer.parseInt(str[1]); // 높이
			if (w == 0 && h == 0)
				break;

			graph = new int[h][w];
			visited = new boolean[h][w];
			cnt = 0;

			String[] gra;
			for (int i = 0; i < h; i++) {
				gra = br.readLine().split(" ");
				for (int j = 0; j < w; j++) {
					graph[i][j] = Integer.parseInt(gra[j]);
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (graph[i][j] == 1 && !visited[i][j]) {
						cnt++;
						//dfs(i, j);
						bfs(i, j);
					}
				}
			}
			System.out.println(cnt);
		}
		br.close();
	}

	public static void dfs(int y, int x) {
		visited[y][x] = true;

		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < w && ny < h) {
				if (!visited[ny][nx] && graph[ny][nx] == 1) {
					dfs(ny, nx);
				}
			}
		}
	}

	public static void bfs(int y, int x) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();

		visited[y][x] = true;
		qx.add(x);
		qy.add(y);

		int tmpx;
		int tmpy;
		while (!qx.isEmpty() && !qy.isEmpty()) {
			tmpx = qx.poll();
			tmpy = qy.poll();

			for (int i = 0; i < 8; i++) {
				x = tmpx + dx[i];
				y = tmpy + dy[i];

				if (x >= 0 && y >= 0 && x < w && y < h) {
					if (graph[y][x] == 1 && visited[y][x] == false) {
						visited[y][x] = true;
						qx.add(x);
						qy.add(y);
					}
				}
			}
		}
	}
}
