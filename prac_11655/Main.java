package prac_11655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		char[] rot = new char[str.length()];

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (Character.isLowerCase(c)) {
				if ((c + 13) > 'z')
					rot[i] = (char) (((c + 13 - 'a') % 26) + 'a');
				else
					rot[i] = (char) (c + 13);
			} else if (Character.isUpperCase(c)) {
				if ((c + 13) > 'Z')
					rot[i] = (char) (((c + 13 - 'A') % 26) + 'A');
				else
					rot[i] = (char) (c + 13);
			} else
				rot[i] = str.charAt(i);
			System.out.print(rot[i]);
		}

		br.close();
	}

}
