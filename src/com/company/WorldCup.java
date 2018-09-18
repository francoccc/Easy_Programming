package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class WorldCup {
    private int M;
    private int N;
    private int[][] Map = new int[3001][3001];
    private int[][] Reach = new int[3001][3001];
    private int[] dx = {1,0,1,0,1,-1,-1,1};
    private int[] dy = {0,1,0,1,1,1,-1,-1};
    private int P = 0;
    private int Q = 0;
    private LinkedList<Point> Queue = new LinkedList<>();

    private class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public WorldCup(){
        String[] strs;
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        strs = str.split(",");
        M = Integer.parseInt(strs[0]);
        N = Integer.parseInt(strs[1]);
        for(int i=1;i<=M;i++){
            str = sc.nextLine();
            strs = str.split(",");
            for(int j=1;j<=N;j++){
                Map[i][j] = Integer.parseInt(strs[j-1]);
            }
        }

        run();
    }

    private void bfs(int x, int y, int q){
        Queue.add(new Point(x, y));
        Reach[x][y] = 1;
        while(!Queue.isEmpty()){
            Point p = Queue.get(0);
            Queue.remove(p);
            x = p.x;
            y = p.y;
            for(int k = 0;k < 8;k++){
                int xx = x + dx[k];
                int yy = y + dy[k];
                if(xx < 0 || yy < 0 || xx > M || yy > N) continue;
                if(Map[xx][yy] == 0 || Reach[xx][yy] == 1) continue;
                q++; Q = Math.max(q,Q);
                Queue.add(new Point(xx, yy));
                Reach[xx][yy] = 1;
            }

        }
    }

    private void run(){
        for(int i = 1;i <= M;i++){
            for(int j = 1;j <= N;j++){
                if(Map[i][j] == 1 && Reach[i][j] == 0){
                    bfs(i, j, 1);
                    P++;
                }
            }
        }

        System.out.println(P + "," + Q);
    }
}
