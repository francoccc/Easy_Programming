package com.company;

import java.util.Scanner;
import java.util.Vector;

public class Cycle {
    private Vector<Integer> A = new Vector<Integer>();
    private Vector<Integer> Delta = new Vector<Integer>();
    private Vector<Integer> Sum = new Vector<Integer>();

    public void run(){
        int N,n;
        Integer T = null,J_T;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        while(N-- > 0){
            A.add(new Integer(0));
            Delta.add(new Integer(0));
            Sum.add(new Integer(0));
            n = sc.nextInt();
            for(int i = 1;i <= n;i++) {
                A.add(new Integer(sc.nextInt()));
                if(i == 1) Delta.add(new Integer(0));
                else Delta.add(A.get(i) - A.get(i-1));
            }
            for(int i = 1;i <= n;i++){
                Sum.add(Sum.get(i-1) + Delta.get(i));
            }
            boolean flag = true;
            for(int d = 1;d < n && flag == true ;d++){
                T = null;
                flag = false;
                for(int r = 1 + d;r <= n;r++){
                    J_T = Sum.get(r) - Sum.get(r - d);
                    if(T == null){
                        T = J_T;
                    }
                    else if(!T.equals(J_T)){
                        flag = true;
                        break;
                    }
                }
            }
            System.out.println(T);
            A.removeAllElements();
            Delta.removeAllElements();
            Sum.removeAllElements();
        }
    }
}
