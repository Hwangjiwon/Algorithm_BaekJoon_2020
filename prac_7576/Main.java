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
		int day;
		
		public Dot(int y, int x, int day) {
			this.y = y;
			this.x = x;
			this.day = day;
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
		int day = 0;
		
		// 토마토가 있는 좌표 찾아서 Queue에 넣기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 1) {
					q.add(new Dot(i, j, 0));
				}
			}
		}

		while (!q.isEmpty()) {
			Dot dot = q.poll();
			day = dot.day;
			
			for (int i = 0; i < 4; i++) {
				int nx = dot.x + dx[i];
				int ny = dot.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
					if (box[ny][nx] == 0) {
						box[ny][nx] = 1;
						q.add(new Dot(ny, nx, day+1));
					}
				}
			}
		}
		
		if(chk()) 
			System.out.println(day);
		else System.out.println(-1);

	}
	
	public static boolean chk() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(box[i][j] == 0) { //덜익은 토마토 있음
					return false;
				}
			}
		}
		return true;
	}

}
