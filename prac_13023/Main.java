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
			if (!flag) {
				dfs(1, i);
			} else {
				break;
			}
			visited[i] = false;
		}

		if (flag) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
		br.close();

	}

	public static void dfs(int len, int point) {
		if (flag) {
			return;
		}
		if (len == 5) {
			flag = true;
			return;
		}
		for (int i = 0; i < relation[len].size(); i++) {
			if (!visited[(int) relation[len].get(i)]) {
				visited[(int) relation[len].get(i)] = true;
				dfs(len + 1,(int) relation[len].get(i));
				visited[(int) relation[len].get(i)] = false;
			}
		}
	}
}