package BOJ;

import java.util.Scanner;

public class Main_8320 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;
        for(int i=1; i<=N; i++)
            for(int j=1; j<=i; j++)
                if(i*j <= N) ans++;
        System.out.println(ans);
    }
}
