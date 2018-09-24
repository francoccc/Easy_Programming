package com.company.tencent;

import java.util.Scanner;

public class ReverseString {
    int[][] dp = new int[1001][1001];

    public ReverseString(){
        Scanner sc = new Scanner(System.in);
        String str;
        while(sc.hasNext()){
            str = sc.nextLine();
            run(str);
        }

    }

    private int find_ans(String str,int l,int d){
        if(d==1){
            return 1;
        }
        if(d<=0){
            return 0;
        }
        if(l<1 || l>str.length()){
            return 0;
        }
        else if(str.charAt(l-1) == str.charAt(l+d-2)){
            return find_ans(str,l+1,d-2) + 2;
        }
        else{
            return Math.max(find_ans(str,l+1,d-1),find_ans(str,l,d-1));
        }
    }

    private void run(String str){
        int len = str.length();
        for(int l = 1;l<=len;l++){
            dp[l][1] = 1;
        }

        for(int d = 2;d <= len;d++){
            for(int l = len - d + 1;l >= 1;l--){
                if(str.charAt(l-1) == str.charAt(l+d-2)){
                    dp[l][d] = dp[l+1][d-2] + 2;
                }
                else dp[l][d] = Math.max(dp[l+1][d-1],dp[l][d-1]);
            }
        }
        System.out.println(len - dp[1][len]);
    }
}
