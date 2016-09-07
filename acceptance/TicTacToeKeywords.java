import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	
	private TicTacToeModel model;
	private int curMark = "X";
	
	public void startNewGame() {
		TicTacToeModel model = new TicTacToe();
	}
	
	public void markLocation(int row, int col) {
		model.MarkLocation(row, col, curMark);
		if (curMark == "X") {
			curMark = "O";
		}
		else {
			curMark = "X";
		}
	}
	
	public String getMark(int row, int col) {
		return model.GetMark(row,col);
	}
    
	public String getWinner() {
		
		return model.CheckWinner();
	}
}
