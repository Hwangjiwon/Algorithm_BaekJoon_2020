package prac_13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static boolean[] visited;
	static ArrayList<Integer>[] relation; // 인접리스트
	static int n;
	static int m;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		n = Integer.parseInt(str[0]); // 정점의 수
		m = Integer.parseInt(str[1]); // 간선의 수

		visited = new boolean[n];
		relation = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			relation[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			str = br.readLine().split(" ");
			int from = Integer.parseInt(str[0]);
			int to = Integer.parseInt(str[1]);

			relation[from].add(to);
			relation[to].add(from);
		}

		for (int i = 0; i < n; i++) {
			visited[i] = true;
			if (!flag) 
				flag = dfs(i, 1);
			visited[i] = false;
		}

		System.out.println("0");
		br.close();

	}

	public static boolean dfs(int len, int point) {
		if (len == 5) {
			return true;
		}

		for (int i = 0; i < relation[n].size(); i++) {
			int next = relation[n].get(i);
			if (!visited[next]) {
				visited[next] = true;
				dfs(len + 1, next);
				visited[next] = false;
			}
		}
		return false;
	}
}