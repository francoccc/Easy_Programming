package com.company;

import java.util.*;

public class BigPoints {
    private int N;
    private ArrayList<Point> points = new ArrayList<>();
    private ArrayList<Point> ans = new ArrayList<>();

    private class Point implements Comparable{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            Point p = (Point) o;
            if(this.x == p.x) return this.y - p.y;
            return p.x - this.x;
        }
    }

    public BigPoints() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int x = 0;
        int y = 0;
        for(int i = 1;i <= N;i++){
            points.add(new Point(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(points);
        run();
    }

    private void run(){
        Point t = points.get(0);
        ans.add(t);

        for(int i = 1;i < N;i++){
            Point p = points.get(i);
            if(p.y >= t.y){
                ans.add(p);
                t = p;
            }
        }

        for(int i = ans.size()-1;i >= 0;i--){
            System.out.println(ans.get(i).x +" "+ans.get(i).y);
        }

    }
}
