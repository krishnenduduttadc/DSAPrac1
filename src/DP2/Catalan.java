/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP2;

/**
 *
 * @author krish
 */
public class Catalan {
    public static void main(String[] args) {
        int n=3;
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i]=dp[i]+dp[j]*dp[i-j-1];
            }
        }
        System.out.println(dp[n]);
    }
}
