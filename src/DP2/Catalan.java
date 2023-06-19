package DP2;

public class Catalan {
    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j <i ; j++) {
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }

        for (int i = 0; i <dp.length ; i++) {
            System.out.print(dp[i]+" ");
        }
    }
}
