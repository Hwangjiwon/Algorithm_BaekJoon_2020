package prac_16194;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();

		int[] p = new int[10001];
		for (int i = 1; i <= n; i++) {
			p[i] = sc.nextInt();
		}

		int[] d = new int[1001];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (d[i] == 0 || d[i] > d[i - j] + p[j]) {
					d[i] = d[i - j] + p[j];
				}
			}
		}
		System.out.println(d[n]);

		sc.close();
	}

}
