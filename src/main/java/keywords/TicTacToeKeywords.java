import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	
	private TicTacToeModel model;
	private int curMark = 1;
	
	public void startNewGame() {
		model = new TicTacToeModel();
	}
	
	public void markLocation(int row, int col) {
		if (curMark == 1) {
			model.markLocation(row, col, "X");
			curMark = 0;
		}
		else {
			model.markLocation(row, col, "0");
			curMark = 1;
		}
	}
	
	public String getMark(int row, int col) {
		int myMark = model.getMark(row,col);
		if (myMark == 1){
			return "X";
		}
		else {
			return "O";
		}
	}
    
	public String getWinner() {
		
		return model.checkWinner();
	}
}
