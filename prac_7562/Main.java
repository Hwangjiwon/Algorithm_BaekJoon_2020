package prac_7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int I;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -2, -1, 2, 1, -2, 2, 1, -1 };
	static int[] dy = { 1, 2, 1, 2, -1, -1, -2, -2 };

	static class Dot {
		int x;
		int y;

		public Dot(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			I = Integer.parseInt(br.readLine());
			map = new int[I][I];
			visited = new boolean[I][I];

			String[] str = br.readLine().split(" ");
			int fromX = Integer.parseInt(str[0]);
			int fromY = Integer.parseInt(str[1]);

			str = br.readLine().split(" ");
			int toX = Integer.parseInt(str[0]);
			int toY = Integer.parseInt(str[1]);

			bfs(new Dot(fromY, fromX), toX, toY);
			System.out.println(map[toY][toX]);
		}
		br.close();
	}

	public static void bfs(Dot d, int tx, int ty) {
		if (d.x == tx && d.y == ty) {
			return;
		}

		Queue<Dot> q = new LinkedList<Main.Dot>();
		visited[d.y][d.x] = true;
		q.add(d);

		while (!q.isEmpty()) {
			Dot cur = q.poll();

			for (int i = 0; i < dx.length; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < I && ny < I) {
					if (!visited[ny][nx]) {
						visited[ny][nx] = true;
						q.add(new Dot(ny, nx));
						map[ny][nx] = map[cur.y][cur.x] + 1;
					}
				}
			}

		}

	}

}
