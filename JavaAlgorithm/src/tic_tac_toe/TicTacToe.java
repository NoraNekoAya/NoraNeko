package tic_tac_toe;

/* ----Noraneko----
 * 标题: 井字棋
 * 描述: 3x3的棋盘,双方轮流落子, 若有一方的棋子横/竖/斜连成三个则胜利,编写程序计算必胜法.
 * 
 */
abstract class TicTacToe {
	static int[][] board = new int[3][3] ;
	
	public static void main(String[] args) {
		//棋盘初始化
		for (int i = 0; i < 3; i++) {
			for (int j = 0;j < 3;j++) {
				board[i][j] = 1;
			}
		}
		
		
	}
	
	
}
