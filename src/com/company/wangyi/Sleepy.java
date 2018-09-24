package com.company.wangyi;

import java.util.ArrayList;
import java.util.Scanner;

public class Sleepy {
    int n,k;
    ArrayList<Integer> a = new ArrayList<>();
    ArrayList<Integer> t = new ArrayList<>();
    int[] sum = new int[1002];
    int[] sum_2 = new int[1002];
    int[] sum_3 = new int[1002];
    private int ans = 0;

    public Sleepy(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i=1;i<=n;i++){
            a.add(sc.nextInt());
        }
        for(int i=1;i<=n;i++){
            t.add(sc.nextInt());
        }
        for(int i=1;i<=n;i++){
            sum_2[i] =  sum_2[i-1] + a.get(i-1);
            if(t.get(i-1) == 0){
                sum[i] = 0;
            }
            else{
                sum[i] = sum[i-1] + a.get(i-1);
            }
        }
        for(int i=n;i>=1;i--){
            if(t.get(i-1)==0){
                sum[i] = 0;
            }
            else{
                sum[i] = sum[i+1] + a.get(i-1);
            }
        }
        run();
    }

    private void run(){
        for(int i=1;i<=n;i++){
            if(t.get(i-1) ==0){
                int SUM_1 = sum[i-1];
                int SUM_2 = sum_2[i+k > n ? n:i+k] - sum_2[i-1];
                int SUM_3 = sum_3[i+k > n ? n:i+k];
                ans = Math.max(ans, SUM_1+SUM_2+SUM_3);
            }
        }
        System.out.println(ans);
    }
}
