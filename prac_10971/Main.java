package prac_10971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] w;
	static int[] check;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		w = new int[n][n];
		check = new int[n];
		visited = new boolean[n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
			check[i] = i;
		}

		dfs(0, check);

		br.close();
	}

	public static void dfs(int len, int[] arr) {
		if (len == n) {
			print(arr);
			return;
		}

		for (int i = len; i < n; i++) {
			swap(arr,len,i);
			dfs(len + 1, arr);
			swap(arr,len,i);
		}
	}

	public static void swap(int[] arr, int len, int i) {
		int tmp = arr[len];
		arr[len] = arr[i];
		arr[i] = tmp;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}
}
