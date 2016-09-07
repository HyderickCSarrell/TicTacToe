package edu.jsu.mcis;

public class TicTacToeModel {
	private int TicTacToeBoard[][];
	private int numOfRows = 3;
	private int numOfCols = 3;
	
	public TicTacToeModel() {
		TicTacToeBoard = new int[numOfRows][numOfCols];
		
	}
	
	public boolean IsEmpty() {
		for (int i = 0; i < numOfRows; i++) {
			for(int j = 0; j < numOfCols; j++){
				if (GetMark(i,j) != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean IsFull() {
		for (int i = 0; i < numOfRows; i++) {
			for(int j = 0; j < numOfCols; j++){
				if (GetMark(i,j) == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public boolean MarkLocation(int row, int col, String mark){
		if (GetMark(row, col) == 0) {
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
	
	public int GetMark (int row, int col) {
		return TicTacToeBoard[row][col];
	}
	
	public boolean ThreeInRow(int mark) {
		int markcount = 0;
		for (int i = 0; i < numOfRows; i++) {
			for (int j = 0; j < numOfCols; j++) {
				if (GetMark(i, j) == mark) {
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
	
	public boolean ThreeInCol(int mark) {
		int markcount = 0;
		for (int i = 0; i < numOfCols; i++) {
			for (int j = 0; j < numOfRows; j++) {
				if (GetMark(j, i) == mark) {
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
	
	public boolean ThreeDiagonally(int mark) {
		for (int i = 0; i < numOfCols; i++) {
			if (GetMark(i, i) != mark) {
				return false;
			}
		}
		
		for (int i = (numOfCols - 1); i > 0; i--) {
			if (GetMark(i, i) != mark) {
				return false;
			}
		}
		return true;
	}
	
	public String CheckWinner() {
		if (ThreeInRow(1) || ThreeInCol(1) || ThreeDiagonally(1)) {
			return "X";
		}
		else if (ThreeInRow(0) || ThreeInCol(0) || ThreeDiagonally(0)) {
			return "O";
		}
		else {
			if (IsFull()) {
				return "TIE";
			}
			else {
				return "";
			}
		}
	}
}
