package prac_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n, m;
	static int[][] graph;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]); //정점
		m = Integer.parseInt(str[1]); //간선
		
		graph = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i = 0; i < m; i++) {
			str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			
			graph[x][y] = graph[y][x] = 1;
		}
		
		cnt = 0;
		for(int i = 1; i <= n; i++) {
			if(visited[i] == false) {
				cnt++;
				dfs(i);
			}
		}
		System.out.println(cnt);
		br.close();
	}

	public static void dfs(int node) {
		for(int i = 1; i <= n; i++) {
			if(visited[i] == false && graph[node][i] == 1) {
				visited[i] = true;
 				dfs(i);
			}
		}
	}
}
