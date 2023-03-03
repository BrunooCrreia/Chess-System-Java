package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private int turn;
	private Color currentPlayer;
	private Board board;
	
	public int getTurn(){
		return turn;
	}
	public Color getCurrentPlayer(){
		return currentPlayer;
	}

	public ChessMatch() {
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Color.WHITE; 
		initialSetup();
	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColunmn()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColunmn(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
				// (ChessPiece) casting como pe�a de xadrex
			}
		}
		return mat;
	}
	
		public boolean [][] possibleMoves(ChessPosition sourcePosition){
			Position position = sourcePosition.ToPosition();
			validateSourcePosition(position);
			return board.piece(position).possibleMoves();
			
		}
	public ChessPiece performChessMove(ChessPosition sourcePosition,ChessPosition targetPosition) {
		Position source = sourcePosition.ToPosition();
		Position target = targetPosition.ToPosition();
		validateSourcePosition(source);
		validadeTargetPosition(source,target);
		Piece capturedPiece =  makeMove(source,target);
		nextTurn();
		return (ChessPiece) capturedPiece;
		
	}
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
		
	}
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("there is no piece on source position");
			}
		if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
			throw new ChessException("the chosen piece is not yours");
		}
		if (!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("theres is no possible moves for the chosen piece");
					}
		
	}
	private void validadeTargetPosition(Position source,Position target) {
		if(!board.piece(source).possibleMoves(target)) {
			throw new ChessException("the chosen piece can't move to target position");
		}
		
	}

	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).ToPosition());
		// aqui ele est� pegando a pe�a em posi��o em coordenadas xadrez e
		// passando para matriz

		/*
		 * aqui � um metodo pra voce conseguir ditar a posi��o da pe�a do xadrez de
		 * acordo com a numera��o do do xadrez n�o com a da matriz
		 */

	}

	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ?Color.BLACK : Color.WHITE;
	}

}
