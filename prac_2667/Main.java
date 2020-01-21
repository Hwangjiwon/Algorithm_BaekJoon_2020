package prac_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int n, cnt;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 }; //상하좌우
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
					dfs(i, j);
					result.add(cnt);
				}
			}
		}
		
		Collections.sort(result);
		System.out.println(result.size()); //단지수
		
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i)); //단지내 집 수
		}
		
		br.close();
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (graph[nx][ny] == 1 && visited[nx][ny] == false) {
					cnt++;
					dfs(nx, ny);
				}
			}
		}
	}

}
