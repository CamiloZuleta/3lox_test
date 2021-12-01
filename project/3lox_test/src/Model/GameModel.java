package Model;

public class GameModel {
	private Long id;
	private String player1Name;
	private String player2Name;
	private String winner = "";
	private String moves;
	
	public GameModel(String player1Name, String player2Name){
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlayer1Name() {
		return player1Name;
	}
	public void setPlayer1Name(String player1Name) {
		this.player1Name = player1Name;
	}
	public String getPlayer2Name() {
		return player2Name;
	}
	public void setPlayer2Name(String player2Name) {
		this.player2Name = player2Name;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getMoves() {
		return moves;
	}
	public void setMoves(String moves) {
		this.moves = moves;
	}

	
	
}
