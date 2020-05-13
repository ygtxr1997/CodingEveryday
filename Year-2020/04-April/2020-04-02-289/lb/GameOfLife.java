package com.company;

public class GameOfLife {
    //生命游戏
    public void gameOfLife(int[][] board) {
        //计算每个细胞周围的活细胞数
        int[][] alive = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                calculator(board,alive,i,j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (alive[i][j] < 2)
                    board[i][j] = 0;
                if (alive[i][j] > 3 && board[i][j] == 1)
                    board[i][j] = 0;
                if (alive[i][j] == 3 && board[i][j] == 0)
                    board[i][j] = 1;
            }
        }
    }

    public void calculator(int[][] board,int[][] alive,int i,int j){
        boolean canLeft = j-1>=0;
        boolean canRight = j+1<board[0].length;
        boolean canUp = i-1>=0;
        boolean canDown = i+1<board.length;
        int ans = 0;
        if (canLeft)
            ans += board[i][j-1];
        if (canRight)
            ans += board[i][j+1];
        if (canDown)
            ans += board[i+1][j];
        if (canUp)
            ans += board[i-1][j];
        if (canLeft && canUp)
            ans += board[i-1][j-1];
        if (canLeft && canDown)
            ans += board[i+1][j-1];
        if (canRight && canUp)
            ans += board[i-1][j+1];
        if (canRight && canDown)
            ans += board[i+1][j+1];
        alive[i][j] = ans;
    }

}
