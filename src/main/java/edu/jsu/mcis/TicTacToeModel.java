package edu.jsu.mcis;

public class TicTacToeModel {
	private int TicTacToeBoard[][];
	private int numOfRows = 3;
	private int numOfCols = 3;
	
	public TicTacToeModel() {
		TicTacToeBoard = new int[numOfRows][numOfCols];
		clearBoard();
		
	}
	
	public void clearBoard() {
		for (int i = 0; i < numOfRows; i++) {
			for(int j = 0; j < numOfCols; j++){
				TicTacToeBoard[i][j] = 0;
			}
		}
	}
	
	public boolean isEmpty() {
		for (int i = 0; i < numOfRows; i++) {
			for(int j = 0; j < numOfCols; j++){
				if (getMark(i,j) != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isFull() {
		String returnValue = "";
		for (int i = 0; i < numOfRows; i++) {
			for(int j = 0; j < numOfCols; j++){
				if (getMark(i,j) == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public boolean markLocation(int row, int col, String mark){
		if (getMark(row, col) == 0) {
			if (mark.equals("X")) {
				TicTacToeBoard[row][col] = 1;
			}
			else if(mark.equals("O")) {
				TicTacToeBoard[row][col] = 2;
			}
			else {
				TicTacToeBoard[row][col] = 0;
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getMark (int row, int col) {
		return TicTacToeBoard[row][col];
	}
	
	private boolean threeInRow(int mark) {
		int markcount = 0;
		for (int i = 0; i < numOfRows; i++) {
			for (int j = 0; j < numOfCols; j++) {
				if (getMark(i, j) == mark) {
					markcount++;
				}
			}
			
			if (markcount >= 3) {
				return true;
			}
			else {
				markcount = 0;
			}
		}
		return false;
	}
	
	private boolean threeInCol(int mark) {
		int markcount = 0;
		for (int i = 0; i < numOfCols; i++) {
			for (int j = 0; j < numOfRows; j++) {
				if (getMark(j, i) == mark) {
					markcount++;
				}
			}
			if (markcount >= 3) {
				return true;
			}
			else {
				markcount = 0;
			}
		}
		return false;
	}
	
	private boolean threeDiagonally(int mark) {
		for (int i = 0; i < numOfCols; i++) {
			if (getMark(i, i) != mark) {
				return false;
			}
		}
		
		for (int i = (numOfCols - 1); i > 0; i--) {
			if (getMark(i, i) != mark) {
				return false;
			}
		}
		return true;
	}
	
	public String checkWinner() {
		if (threeInRow(1) || threeInCol(1) || threeDiagonally(1)) {
			return "X";
		}
		else if (threeInRow(2) || threeInCol(2) || threeDiagonally(2)) {
			return "O";
		}
		else {
			if(isFull() == false) {
				return "";
			}
			else {
				return "TIE";
			}
		}
	}
}
