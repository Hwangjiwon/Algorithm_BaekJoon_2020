package test;

import java.io.*;

public class Main {
 
    static final long MOD = 1000000009L;
    static final int LIMIT = 100000;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        long[][] d = new long[LIMIT + 1][4];
        // 값 저장할 배열 생성
 
        // d[i][j] = i를 1,2,3의 합으로 나타내는 방법의 수, 마지막에 사용한 수는 j
 
        // i로 0이 들어올 때의 케이스는 이미 배열 생성과 동시에 0, 0 , 0으로 세팅되어 있으니 바로 시작
 
        for (int i = 1; i <= LIMIT; i++) {
            
            if (i - 1 >= 0) {
                d[i][1] = d[i - 1][2] + d[i - 1][3];
                // 끝에 1이 올 경우
                if (i == 1) {
                    // 1일 때 1이 오는 경우는 예외 처리
                    d[i][1] = 1;
                }
            }
 
            if (i - 2 >= 0) {
                d[i][2] = d[i - 2][1] + d[i - 2][3];
                // 끝에 2가 올 경우
                if (i == 2) {
                    d[i][2] = 1;
                }
            }
 
            if (i - 3 >= 0) {
                d[i][3] = d[i - 3][1] + d[i - 3][2];
                // 끝에 3이 올 경우
                if (i == 3) {
                    d[i][3] = 1;
                }
            }
 
            d[i][1] %= MOD;
            d[i][2] %= MOD;
            d[i][3] %= MOD;
 
        }
        
        int times = Integer.parseInt(br.readLine());
        // 테스트 케이스의 갯수 입력
 
        for (int i = 0; i < times; i++) {
 
            int n = Integer.parseInt(br.readLine());
            // 입력
            long answer = (d[n][1] + d[n][2] + d[n][3]) % MOD;
            // 테스트 케이스 받고
            bw.write(String.valueOf(answer));
            // 출력
            bw.write('\n');
            bw.flush();
 
        }
 
    }
 
}