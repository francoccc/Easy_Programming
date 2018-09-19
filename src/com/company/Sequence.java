package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Sequence {
    private int n;
    private int[] a = new int[500001];
    private int[] sum = new int[500001];
    private int ans = 0;

    public Sequence(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1;i <= n;i++){
            a[i] = sc.nextInt();
        }
        run();
    }

    private int extend(int i){
        int l = i;
        int r = i;
        int max;
        boolean flag = true;
        while(flag){
            flag = false;
            if(r<n && a[r+1] >= a[i]){
                r++;
                flag = true;
            }
            else if(l>1 && a[l-1] >= a[i]){
                l--;
                flag = true;
            }
        }
        max = (sum[r] - sum[l-1]) * a[i];
        return max;
    }

    private void run(){
        for(int i = 1;i <= n;i++){
            sum[i] = sum[i-1] + a[i];
        }
        for(int i = 1;i <= n;i++){
            int t = extend(i);
            ans = ans > t ? ans : t;
        }

        System.out.println(ans);
    }
}
