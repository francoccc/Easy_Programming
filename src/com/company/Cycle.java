package com.company;

import java.util.Scanner;
import java.util.Vector;

public class Cycle {
    private Vector<Integer> A = new Vector<Integer>();
    private Vector<Integer> Delta = new Vector<Integer>();

    public void run(){
        int N,n;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        while(N-- > 0){
            n = sc.nextInt();
            while(n-- > 0){
                A.add(new Integer(sc.nextInt()));
            }

        }
    }
}
