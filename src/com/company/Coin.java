package com.company;

import java.util.Scanner;
import java.util.Vector;

public class Coin {
    private int n_1,n_2,m;
    private final int P = 1000000007;
    Vector<Integer> N = new Vector<>();
    private int[] F = new int[100001];
    private int[] OLDF = new int[100001];

    private int getNum(int i,int j, int cost){
        int num = 0;
        num = (OLDF[j] + OLDF[j - cost]) % P;
        if(i <= n_1){
            num = (num + F[j - cost]) % P;
        }
        return num;
    }

    private void verse(){
        for(int i = 1;i <= m;i++){
            OLDF[i] = F[i];
        }
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        n_1 = sc.nextInt();
        n_2 = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1;i <= n_1 + n_2;i++){
            N.add(new Integer(sc.nextInt()));
        }

        F[0] = 1;
        OLDF[0] = 0;

        for(int i = 2;i <= n_1 + n_2;i++){
            int cost = N.get(i);
            for (int j = cost; j <= m; j++) {
                    F[j] = getNum(i,j, cost);
            }
            verse();
        }

        System.out.println(F[m]);
    }
}
