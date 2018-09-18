package com.company;

import java.util.*;

public class MatrixGame {
    private String S;
    private int Q;
    private Map<String,Point> Direaction = new HashMap<>();
    private ArrayList<Point> Points = new ArrayList<>();

    private class Point implements Comparable{
        int x;
        int y;
        int d;//切比雪夫距离

        Point(int x, int y){
            this.x = x;
            this.y = y;
            this.d = Math.max(Math.abs(x), Math.abs(y));
        }

        public void add(Point p){
            this.x += p.x;
            this.y += p.y;
            this.d = Math.max(Math.abs(x), Math.abs(y));
        }

        public void add(int x, int y){
            this.x += x;
            this.y += y;
            this.d = Math.max(Math.abs(x), Math.abs(y));
        }

        @Override
        public int compareTo(Object o) {
            Point p = (Point) o;
            return this.d - p.d;
        }
    }

    public MatrixGame(){
        int N, M, X, Y;
        Scanner sc = new Scanner(System.in);
        this.S = sc.nextLine();
        this.Q = sc.nextInt();
        Direaction.put("u", new Point(0, 1));
        Direaction.put("d", new Point(0, -1));
        Direaction.put("l", new Point(-1, 0));
        Direaction.put("r", new Point(1, 0));

        Point pos = new Point(0, 0);
        for(int i = 0;i < S.length();i++){
            pos.add(Direaction.get(S.charAt(i)));
            Points.add(pos);
        }
        Collections.sort(Points);

        //Inquiry
        for(int i = 1;i <= Q;i++){
            N = sc.nextInt(); M = sc.nextInt();
            X = sc.nextInt(); Y = sc.nextInt();
            run(N, M, X, Y);
        }
    }

    public void run(int N, int M, int X, int Y){
        int left = 0;
        int right = Points.size() - 1;
        int mid = (left + right) / 2;

    }
}
