package com.company.wangyi;

import java.util.HashMap;
import java.util.Scanner;

public class Blocks {
    HashMap<Integer,Integer> map = new HashMap<>();
    int m,n;
    int min = new Integer(1000);

    public Blocks(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=1;i<=n;i++){
            map.put(i,0);
        }
        for(int i=1;i<=m;i++){
            int k = sc.nextInt();
            map.put(k,map.get(k)+1);
        }

        for(int i=1;i<=n;i++){
            min = Math.min(map.get(i),min);
        }
        System.out.println(min);
    }
}
