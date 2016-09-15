package edu.jsu.mcis;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGame extends JPanel implements ActionListener{
	
	private JButton[][] posButtons;
	private TicTacToeModel model;
	private String curMark = "X";
	
	public TicTacToeGame() {
            posButtons = new JButton[3][3];
            model = new TicTacToeModel();
            prepareGUI();
		
	}
	
	private void prepareGUI() {
            int boardPosCount = 0;
			setLayout(new GridLayout(3,3));
                
            for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
                    posButtons[i][j] = new JButton("");
                    posButtons[i][j].setPreferredSize(new Dimension(100, 100));
                    posButtons[i][j].setActionCommand("Location" + i + j);
                    posButtons[i][j].addActionListener(this); 
					posButtons[i][j].setName("Location"+ i+ j);
                    add(posButtons[i][j]);
                    boardPosCount++;
				}
            }
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
                JButton curButton = (JButton)e.getSource();
                
                switch(command) {
                    case "Location00" : markLocationWithCurMark(0,0);
                                       curButton.setText(model.getMark(0, 0));
									   break;
                    case "Location01" : markLocationWithCurMark(0,1);
                                       curButton.setText(model.getMark(0, 1));
                        break;
                    case "Location02" : markLocationWithCurMark(0,2);
                                       curButton.setText(model.getMark(0, 2));
									   break;
                    case "Location10" : markLocationWithCurMark(1,0);
                                       curButton.setText(model.getMark(1, 0));
									   break;
                    case "Location11" : markLocationWithCurMark(1,1);
                                       curButton.setText(model.getMark(1, 1));
									   break;
                    case "Location12" : markLocationWithCurMark(1,2);
                                       curButton.setText(model.getMark(1, 2));
									   break;
                    case "Location20" : markLocationWithCurMark(2,0);
                                       curButton.setText(model.getMark(2, 0));
									   break;
                    case "Location21" : markLocationWithCurMark(2,1);
                                       curButton.setText(model.getMark(2, 1));
									   break;
                    case "Location22" : markLocationWithCurMark(2,2);
                                       curButton.setText(model.getMark(2, 2));
									   break;
                    default:
                        break;
                }
                checkWinner();

	}
	
	public void markLocationWithCurMark(int row, int col) {
            model.markLocation(row,col, curMark);
            
            if (curMark.equals("X")) {
                curMark = "O";
            }
            else {
                curMark = "X";
            }
        }
	public void clearButtonText() {
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				posButtons[i][j].setText("");
			}
		}
	}
        
       public void checkWinner() {
           if (model.checkWinner().equals("X")) {
               JOptionPane.showMessageDialog(null,"The Winner is " + "X", "Game Over", JOptionPane.INFORMATION_MESSAGE);
               model.clearBoard();
			   clearButtonText();
           }
           else if (model.checkWinner().equals("O")) {
               JOptionPane.showMessageDialog(null,"The Winner is " + "O", "Game Over", JOptionPane.INFORMATION_MESSAGE);
               model.clearBoard();
			   clearButtonText();
           }
           else {
               if (model.checkWinner().equals("TIE")) {
                    JOptionPane.showMessageDialog(null,"The Winner is " + "TIE", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    model.clearBoard();
					clearButtonText();
               }
           }
       } 
	   
	public static void main(String[] args) {
		TicTacToeGame panel = new TicTacToeGame();
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.pack(); 

	}
}
