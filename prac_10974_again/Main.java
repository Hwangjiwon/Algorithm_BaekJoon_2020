package prac_10974_again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = i + 1;

		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		while (true) {
			if (nextPerm(arr) == null)
				break;
		}
		br.close();
	}

	public static int[] nextPerm(int[] arr) {
		int[] result = new int[n];
		for (int i = 0; i < n; i++)
			result[i] = arr[i];

		int idx = -1;
		for (int i = 0; i < n - 1; i++) {
			if (result[i] < result[i + 1])
				idx = i;
		}
		if (idx < 0) {
			System.out.println(-1);
			return null;
		}
		for (int i = n - 1; i > idx; i--) {
			if (result[idx] < result[i]) {
				int tmp = result[idx];
				result[idx] = result[i];
				result[i] = tmp;
				break;
			}
		}

		for (int i = idx + 1; i < (n + idx + 1) / 2; i++) {
			int tmp = result[i];
			result[i] = result[n - (i - idx)];
			result[n - (i - idx)] = tmp;
		}

		for (int i = 0; i < n; i++) {
			System.out.print(result[i] + " ");
		}
		return result;
	}
}
