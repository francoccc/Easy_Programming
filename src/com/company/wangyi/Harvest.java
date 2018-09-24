package com.company.wangyi;

import java.util.ArrayList;
import java.util.Scanner;

public class Harvest {
    int n,m;
    int[] a = new int[100001];
    int[] q = new int[100001];
    int[] sum = new int[100001];

    public Harvest(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=1;i<=n;i++){
            a[i] = sc.nextInt();
            sum[i] = sum[i-1] + a[i];
        }

        m = sc.nextInt();
        for(int i=1;i<=m;i++){
            q[i] = sc.nextInt();
        }
        run();
    }

    private void run(){
        for(int i=1;i<=m;i++){
            int Q = q[i];
            int l = 0;
            int r = n;
            while(l<r){
                int mid = (l+r)/2;
                int key = sum[mid];
                if(key<=Q){
                    l = mid + 1;
                }
                else if(key>Q){
                    r = mid;
                }
            }
            System.out.println(l);
        }
    }
}
