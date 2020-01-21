package prac_4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int w, h, cnt;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1, -1, -1, 1, 1 }; //�����¿� �»� ���� ��� ����
    static int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str;
		while (true) {
			str = br.readLine().split(" ");
			w = Integer.parseInt(str[0]); //�ʺ�
			h = Integer.parseInt(str[1]); //����
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
						dfs(i, j);
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
		
	}
}
