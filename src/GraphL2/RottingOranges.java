package GraphL2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class RottingOranges {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(orangesRotting(arr));

    }

    public static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    public static int orangesRotting(int[][] arr) {
        LinkedList<Pair> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==2){
                    q.addLast(new Pair(i,j));
                }else if(arr[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh==0){
            return 0;
        }
        int[][] dirs={{-1,0},{0,1},{1,0},{0,-1}};
        int level=-1;

        while(q.size()>0){
            int size=q.size();
            level++;
            while(size-->0){
                Pair rem=q.removeFirst();
                for(int i=0;i<dirs.length;i++){
                    int rdash=rem.row+dirs[i][0];
                    int cdash=rem.col+dirs[i][1];

                    if(rdash>=0 && cdash>=0 && rdash<arr.length &&
                            cdash<arr[0].length && arr[rdash][cdash]==1){
                        q.addLast(new Pair(rdash,cdash));
                        arr[rdash][cdash]=0;
                        fresh--;
                    }
                }
            }
        }

        if(fresh==0){
            return level;
        }else{
            return -1;
        }

    }

}
/*
3 3
2 1 1
1 1 0
0 1 1
 */
