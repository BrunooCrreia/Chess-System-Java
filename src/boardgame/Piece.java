package boardgame;

public class Piece {
	protected Position position;
	private Board board;

	public Piece(Board board) {
		this.board = board;
		position = null; // nao precisa ja que de padrão ela ja vem null
		}

	public Board getBoard() {
		return board;
	}

}
