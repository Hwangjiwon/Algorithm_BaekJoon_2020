package prac_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int m, n;
	static int[][] box;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static class Dot {
		int y;
		int x;

		public Dot(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		m = Integer.parseInt(str[0]); // 가로
		n = Integer.parseInt(str[1]); // 세로
		box = new int[n][m];

		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(str[j]);
			}
		}

		bfs();

		br.close();
	}

	public static void bfs() {
		Queue<Dot> q = new LinkedList<Main.Dot>();

		// 토마토가 있는 좌표 찾아서 Queue에 넣기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 1) {
					q.add(new Dot(i, j));
				}
			}
		}

		while (!q.isEmpty()) {
			Dot dot = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = dot.x + dx[i];
				int ny = dot.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
					if (box[ny][nx] == 0) {
						// box[ny][nx]칸에 이전 box의 익은일수 +1
						box[ny][nx] = box[dot.y][dot.x] + 1;
						q.add(new Dot(ny, nx));
					}
				}
			}
		}

		System.out.println(chkDay());

	}

	public static int chkDay() {
		int day = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 0) { // 덜익은 토마토 있음
					return -1;
				} else {
					day = Math.max(day, box[i][j]);
				}
			}
		}
		return day - 1;
	}

}
