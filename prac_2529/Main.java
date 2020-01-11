package prac_2529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int k;
	static int[] arr;
	static String result;
	static boolean visited[];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");

		for (int i = 0; i < k; i++) {
			System.out.println(str[i]);
		}

		// 1 < 1 : 2
		// 1 < 1 < 1 : 3
		// 1 < 1 < 1 < 1 : 4
		arr = new int[k + 1];
		visited = new boolean[10];

		dfs(0, "");
		br.close();
	}

	public static void dfs(int len, String str) {
		if (len == k + 1) {
			//check
			if(check(str)) {
				result = str;
				System.out.println(result);
			}
			
			
			System.out.println(str);
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (!visited[i]) {
				visited[i] = true;				
				dfs(len + 1, str + i);
				visited[i] = false;
			}
		}
	}
	
	public static boolean check(String str) {
		
		return false;
		
		
		
	}

}
