package chess;

import boardgame.Board;

public class ChessMatch {
	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
	}

	public ChessPiece[][] getpieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColunmn()];
		for(int i = 0;i<board.getRows();i++) {
			for (int j=0;j<board.getColunmn();j++) {
				mat[i][j] = (ChessPiece) board.piece(i,j);
				//(ChessPiece) downcasting como peça de xadrex
			}	
		}
		return mat;
	}

}
