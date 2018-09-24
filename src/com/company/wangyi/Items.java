package com.company.wangyi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Items {
    int n;
    private class Point{
        int a,b,x,y;
        Point(int a,int b,int x,int y){
            this.a = a;
            this.b = b;
            this.x = x;
            this.y = y;
        }

        int getdis(Point p){
            return (int)Math.pow(this.a - p.a,2) + (int)Math.pow(this.b - p.b,2);
        }

        void rotate(){
            int t = y - b + x;
            this.b = a - x + y;
            this.a = t;
        }
    }

    public Items(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Point[] points = new Point[5];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=4;j++){
                points[j] = new Point(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
            }
            run(points);
        }
    }

    private boolean isSquare(Point[] points){
        ArrayList<Integer> num = new ArrayList<>();
        for(int i=1;i<=4;i++){
            for(int j=i+1;j<=4;j++){
                num.add(points[i].getdis(points[j]));
            }
        }
        Collections.sort(num);
        if(num.get(0) == num.get(3) && num.get(4) == num.get(5) && num.get(0) != 0){
            return true;
        }
        else{
            return false;
        }
    }

    private void run(Point[] points){
        int i,j,k,l;
        int ans = Integer.MAX_VALUE;
        for(i=0;i<=3;i++){
            for(j=0;j<=3;j++){
                for(k=0;k<=3;k++){
                    for(l=0;l<=3;l++){
                        if(isSquare(points)){
                            ans = Math.min(ans,i+j+k+l);
                        }
                        points[4].rotate();
                    }
                    points[3].rotate();
                }
                points[2].rotate();
            }
            points[1].rotate();
        }
        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else {
            System.out.println(ans);
        }
    }

}
