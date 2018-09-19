package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Sequence {
    private int n;
    private int[] a = new int[500001];
    private int[] sum = new int[500001];

    public Sequence(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1;i <= n;i++){
            a[i] = sc.nextInt();
        }
        run();
    }

    private void run(){
        for(int i = 1;i <= n;i++){
            sum[i] = sum[i-1] + a[i];
        }
    }
}
