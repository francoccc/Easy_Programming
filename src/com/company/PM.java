package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class PM {
    private int N,M,P;
    private ArrayList<idea> ideas = new ArrayList<>();
    private Stack<idea> todo = new Stack<>();

    private class idea implements Comparable{
        int id;
        int st;
        int op;
        int ta;

        idea(int id,int st,int op,int ta){
            this.id = id;
            this.st = st;
            this.op = op;
            this.ta = ta;
        }

        @Override
        public int compareTo(Object o) {
            idea i = (idea) o;
            if(this.op == i.op){
                if(this.ta == i.ta){
                    if(this.st == i.st) {
                        return this.id - i.id;
                    }
                    return this.st - i.st;
                }
                else return this.ta - i.ta;
            }
            else return this.op - i.op;
        }
    }

    public PM(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        P = sc.nextInt();
        for(int i=1;i<=P;i++){
            int id = sc.nextInt();
            int start = sc.nextInt();
            int op = sc.nextInt();
            int taken = sc.nextInt();
            ideas.add(new idea(id, start, op, taken));
        }
        Collections.sort(ideas);
        run();
    }

    private void run(){

    }
}
