package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}

	public ChessPiece[][] getpieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColunmn()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColunmn(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
				// (ChessPiece) casting como peça de xadrex
			}
		}
		return mat;
	}

	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).ToPosition());
		// aqui ele está pegando a peça em posição em coordenadas xadrez e
		// passando para matriz

		/*
		 * aqui é um metodo pra voce conseguir ditar a posição da peça do xadrez de
		 * acordo com a numeração do do xadrez não com a da matriz
		 */

	}

	private void initialSetup() {
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8,new King(board, Color.BLACK));
		placeNewPiece('e',1,new King(board, Color.BLACK));
	}

}
