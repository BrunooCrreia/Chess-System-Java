package boardgame;

public class Board {
	
	private int rows;
	private int colunmn;
	private Piece[][] pieces;
	public Board(int rows, int colunmn) {
		this.rows = rows;
		this.colunmn = colunmn;
		pieces = new Piece[rows][colunmn];
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColunmn() {
		return colunmn;
	}
	public void setColunmn(int colunmn) {
		this.colunmn = colunmn;
	}

	public Piece piece(int row, int column) {
		return pieces [row][column];
		}
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColum()];
		
	}

}
