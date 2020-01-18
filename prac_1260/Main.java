package prac_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] graph;
	static int n, m, v;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		v = Integer.parseInt(str[2]);
		
		graph = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		while(m-- != 0) 	{
			str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			graph[x][y] = graph[y][x] = 1;
		}
		
		dfs(v);
		
		for(int i=1; i<=n; i++) { // @7
			visited[i] = false;
		}
		System.out.println();
		bfs(v);
		br.close();
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " ");
		
		for(int j = 1; j <= n; j++) {
			if(!visited[j] && graph[start][j] == 1)
				dfs(j);
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(start);
		visited[start] = true;
		System.out.print(start+" ");
		
		int tmp;
		
		while(!q.isEmpty()) {
			tmp = q.poll();
			for(int j = 1; j <= n; j++) {
				if(graph[tmp][j] == 1 && !visited[j]) {
					q.offer(j);
					visited[j] = true;
					System.out.print(j + " ");
				}
			}
		}
	}
}
