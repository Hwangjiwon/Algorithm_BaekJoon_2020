package prac_11052;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();

		int[] p = new int[10001];
		for (int i = 1; i <= N; i++) {
			p[i] = sc.nextInt();
		}

		int[] d = new int[1001];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				d[i] = Math.max(d[i], d[i - j] + p[j]);
			}
		}
		
		System.out.println(d[N]);

		sc.close();
	}

}
