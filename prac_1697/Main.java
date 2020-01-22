package prac_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n, k;
	static int[] map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		k = Integer.parseInt(str[1]);
		map = new int[100001];

		System.out.println(bfs());
		br.close();
	}

	public static int bfs() {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(n);

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == k)
				break;

			for (int i = 0; i < 3; i++) {
				int next;
				
				if (i == 0)
					next = cur - 1;
				else if (i == 1)
					next = cur + 1;
				else
					next = cur * 2;

				if (next >= 0 && next <= 100000) {
					if (map[next] == 0) {
						q.add(next);
						map[next] = map[cur] + 1;
					}
				}
			}

		}
		return map[k];
	}
}
