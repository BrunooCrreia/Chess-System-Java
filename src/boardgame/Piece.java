package boardgame;

public abstract class Piece {
	protected Position position;
	private Board board;

	public Piece(Board board) {
		this.board = board;
		position = null; // nao precisa ja que de padr�o ela ja vem null
	}

	public Board getBoard() {
		return board;
	}

	public abstract boolean[][] possibleMoves();

	//abaixo doiis metodos conceretos que dependem de um metodo abstrato
	public boolean possibleMoves(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}

	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}

		}
		return false;

	}

}
