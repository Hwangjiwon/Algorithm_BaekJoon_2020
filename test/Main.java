package test;

import java.io.*;

public class Main {
 
    static final long MOD = 1000000009L;
    static final int LIMIT = 100000;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        long[][] d = new long[LIMIT + 1][4];
        // �� ������ �迭 ����
 
        // d[i][j] = i�� 1,2,3�� ������ ��Ÿ���� ����� ��, �������� ����� ���� j
 
        // i�� 0�� ���� ���� ���̽��� �̹� �迭 ������ ���ÿ� 0, 0 , 0���� ���õǾ� ������ �ٷ� ����
 
        for (int i = 1; i <= LIMIT; i++) {
            
            if (i - 1 >= 0) {
                d[i][1] = d[i - 1][2] + d[i - 1][3];
                // ���� 1�� �� ���
                if (i == 1) {
                    // 1�� �� 1�� ���� ���� ���� ó��
                    d[i][1] = 1;
                }
            }
 
            if (i - 2 >= 0) {
                d[i][2] = d[i - 2][1] + d[i - 2][3];
                // ���� 2�� �� ���
                if (i == 2) {
                    d[i][2] = 1;
                }
            }
 
            if (i - 3 >= 0) {
                d[i][3] = d[i - 3][1] + d[i - 3][2];
                // ���� 3�� �� ���
                if (i == 3) {
                    d[i][3] = 1;
                }
            }
 
            d[i][1] %= MOD;
            d[i][2] %= MOD;
            d[i][3] %= MOD;
 
        }
        
        int times = Integer.parseInt(br.readLine());
        // �׽�Ʈ ���̽��� ���� �Է�
 
        for (int i = 0; i < times; i++) {
 
            int n = Integer.parseInt(br.readLine());
            // �Է�
            long answer = (d[n][1] + d[n][2] + d[n][3]) % MOD;
            // �׽�Ʈ ���̽� �ް�
            bw.write(String.valueOf(answer));
            // ���
            bw.write('\n');
            bw.flush();
 
        }
 
    }
 
}