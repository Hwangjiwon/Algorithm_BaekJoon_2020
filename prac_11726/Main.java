package prac_11726;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[n + 1];
		
		d[0] = 0;
		d[1] = 1;
		d[2] = 2;
		for (int i = 3; i <= n; i++) {
			d[i] = d[i - 1] + d[i - 2];
			d[i] %= 10007;
		}
		
		System.out.println(d[n]);

		sc.close();
	}

}
