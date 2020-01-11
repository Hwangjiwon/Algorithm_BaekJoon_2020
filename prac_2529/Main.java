package prac_2529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int k;
	static String[] compare;
	static boolean visited[];
	static List<String> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());
		compare = br.readLine().split(" ");

		visited = new boolean[10];
		
		dfs(0, "");
		
		System.out.println(result.get(result.size()-1));
		System.out.println(result.get(0));
		
		br.close();
	}

	public static void dfs(int len, String str) {
		if (len == k + 1) {
			if (check(str) == true) {
				result.add(str);
			}
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
		for (int i = 1; i < str.length(); i++) {
			int j = i - 1;
			
			if (compare[j].equals("<")) {
				if (!(str.charAt(i - 1) - '0' < str.charAt(i) - '0')) {
					return false;
				}
			} else if (compare[j].equals(">")) {
				if (!(str.charAt(i - 1) - '0' > str.charAt(i) - '0')) {
					return false;
				}
			}
		}
		return true;
	}

}
