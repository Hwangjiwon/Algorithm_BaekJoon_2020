package prac_10972_again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// https://jins-dev.tistory.com/m/entry/%EB%8B%A4%EC%9D%8C-%EC%88%9C%EC%97%B4-%EC%B0%BE%EA%B8%B0-%EC%A0%84%EC%B2%B4-%EC%88%9C%EC%97%B4-%ED%83%90%EC%83%89-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Next-Permutation

public class Main {
	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		nextPermute(arr);
		
		br.close();
	}

	public static void nextPermute(int[] nums) {
		int[] copies = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			copies[i] = nums[i];
		}
		int idx = -1;
		for (int i = 0; i < copies.length - 1; i++) {
			if (copies[i] < copies[i + 1]) {
				idx = i;
			}
		}
		if (idx < 0) {
			// Last Permutation
			System.out.println(-1);
			return;
		}
		for (int i = copies.length - 1; i > idx; i--) {
			if (copies[idx] < copies[i]) {
				int tmp = copies[idx];
				copies[idx] = copies[i];
				copies[i] = tmp;
				break;
			}
		}
		for (int i = idx + 1; i < (copies.length + idx + 1) / 2; i++) {
			int tmp = copies[i];
			copies[i] = copies[copies.length - (i - idx)];
			copies[copies.length - (i - idx)] = tmp;
		}

		for (int i = 0; i < copies.length; i++) {
			System.out.print(copies[i] + " ");
		}
	}

}
