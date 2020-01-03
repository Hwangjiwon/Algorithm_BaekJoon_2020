package prac_10819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int arr[];
	static int result;
	static int max;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);
		dfs(0, arr, n, n);
		System.out.println(max);
		br.close();
	}

	public static void dfs(int len, int[] arr, int n, int r) {
		if (len == n) {
			abs(arr, r);
			if (max < result)
				max = result;
			result = 0;
			return;
		}
		for (int i = len; i < n; i++) {
			swap(arr, len, i);
			dfs(len + 1, arr, n, r);
			swap(arr, len, i);
		}
	}

	public static void abs(int[] arr, int r) {
		for (int i = 0; i < r - 1; i++) {
			result += Math.abs(arr[i] - arr[i + 1]);
		}
	}

	public static void swap(int[] arr, int len, int i) {
		int tmp = arr[len];
		arr[len] = arr[i];
		arr[i] = tmp;
	}
}
