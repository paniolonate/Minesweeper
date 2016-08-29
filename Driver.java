import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/***************************************************************************************
*
* NAME: Andrew Millard, Nathan Nahina, John Dieter
*
* HOMEWORK: Group Project
*
* CLASS: ICS 211
*
* INSTRUCTOR: Scott Robertson
*
* DATE: April 29, 2016
*
* FILE: Driver.java
*
* DESCRIPTION: This file contains the the main method
*
***************************************************************************************/
public class Driver {
	/********************************************************************
	*
	* Method: main
	*
	* Description: Runs the Minesweeper game
	*
	* @param  args  contains command line arguments (not utilized)
	* 			
	* @return None
	* 		
	********************************************************************/
	public static void main(String[] args){
		

		
		//Make HighScore Board
		int HighScore = 0;
		boolean GameRunning = true;

		ArrayList<ArrayList<Integer>> HighScoreList = new ArrayList<ArrayList<Integer>>();
		HighScoreList.add(new ArrayList<Integer>());
		HighScoreList.add(new ArrayList<Integer>());
		HighScoreList.add(new ArrayList<Integer>());

		JFrame HighScores = new JFrame();
		HighScores.setSize(500, 400);
		HighScores.setResizable(false);
		HighScores.setLayout(new GridLayout(12, 3));
		HighScores.add(new GreenJPanel());

		JLabel ScoreTitle = new JLabel();
		GreenJPanel ScoreTitlePanel = new GreenJPanel();
		ScoreTitle.setText("HIGHSCORES");
		ScoreTitle.setBackground(new Color(175, 200, 175));
		ScoreTitle.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		ScoreTitlePanel.add("Center", ScoreTitle);
		HighScores.add(ScoreTitlePanel);
		GreenJPanel BeginnerPanel = new GreenJPanel();
		GreenJPanel MediumPanel = new GreenJPanel();
		GreenJPanel HardPanel = new GreenJPanel();
		
		JLabel BeginnerLabel = new JLabel("Beginner");
		JLabel MediumLabel = new JLabel("Medium");
		JLabel HardLabel = new JLabel("Hard");
		
		BeginnerLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		MediumLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		HardLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		
		BeginnerPanel.add(BeginnerLabel);
		MediumPanel.add(MediumLabel);
		HardPanel.add(HardLabel);
		
		
		JPanel[][] HighScorePanels = new JPanel[3][10];
		JLabel[][] HighScoreButtons = new JLabel[3][10];
		

		HighScores.add(new GreenJPanel());
		
		HighScores.add(BeginnerPanel);
		HighScores.add(MediumPanel);
		HighScores.add(HardPanel);
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 3; i++) {
				HighScorePanels[i][j]= new JPanel(new FlowLayout(FlowLayout.LEFT));
				
				HighScoreButtons[i][j] = new JLabel();
				HighScoreButtons[i][j].setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
				
				HighScorePanels[i][j].setBackground(new Color(175, 200, 175));
				HighScorePanels[i][j].add(HighScoreButtons[i][j]);
				HighScores.add(HighScorePanels[i][j]);
			}
		}
		
		//Read old scores
		for (int i = 0; i < 3; i++) {
			try {
				Scanner scanner = new Scanner(new FileReader("HighScores" + i +".txt"));

				for (int j = 0; scanner.hasNext() == true; j++) {
					HighScoreList.get(i).add(scanner.nextInt());
				}
				scanner.close();
			} catch (FileNotFoundException e) {
			}
		}
		
		// update score
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < HighScoreList.get(j).size(); i++) {
				HighScoreButtons[j][i].setText(((Integer) (i + 1)).toString() + ".   "
						+ ((Integer) (HighScoreList.get(j).get(i))).toString());
			}
		}
		
		//Run Game
		while (GameRunning) {
			GameRunning = false;
			JFrame Frame = new JFrame();
			Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Frame.setSize(1000, 1000);
			Frame.setResizable(false);
			Frame.setVisible(true);
			JPanel Main = new JPanel();
			Frame.add(Main);
			Main.setLayout(new GridLayout(5, 3));
			Main.setSize(1000, 1000);
			
			Main.add(new GreenJPanel());
			System.out.println("Hi");
			GreenJPanel Title = new GreenJPanel();
			Title.setLayout(new GridLayout(3, 0));
			JLabel TitleText = new JLabel("MINESWEEPER");
			TitleText.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 37));
			Title.add(new GreenJPanel());
			Title.add("Center", TitleText);
			Title.add(new GreenJPanel());
			Main.add(Title);
			Main.add(new GreenJPanel());
			Main.add(new GreenJPanel());
			MenuItem beginner = new MenuItem("Beginner");
			Main.add(beginner);
			Main.add(new GreenJPanel());
			Main.add(new GreenJPanel());
			MenuItem medium = new MenuItem("Medium");
			Main.add(medium);
			Main.add(new GreenJPanel());
			Main.add(new GreenJPanel());
			MenuItem hard = new MenuItem("Hard");
			Main.add(hard);
			Main.add(new GreenJPanel());
			Main.add(new GreenJPanel());
			Main.add(new GreenJPanel());
			Main.add(new GreenJPanel());
			Main.setVisible(true);
			int x = -1;
			int maxbomb = -1;
			int difficulty = -1;

			while (x == -1) {
				hard.repaint();
				if (hard.isClicked()) {
					x = 20;
					maxbomb = 100;
					difficulty = 2;
				} else if (medium.isClicked()) {
					x = 15;
					maxbomb = 50;
					difficulty = 1;
				} else if (beginner.isClicked()) {
					x = 10;
					maxbomb = 9;
					difficulty = 0;
				}
			}
			Frame.setVisible(false);

			JFrame Game = new JFrame();
			Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Game.setSize(1000, 1000);
			Game.setResizable(false);

			JPanel Main2 = new JPanel();
			Main2.setLayout(new GridLayout(5, 3));

			Tile[][] minefield = new Tile[x][x];
			Main2.setLayout(new GridLayout(x, x));
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < x; j++) {
					minefield[i][j] = new Tile(false, difficulty);
					Main2.add(minefield[i][j]);
				}

			}

			JPanel Control = new JPanel();
			Control.setLayout(new GridLayout(0, 3));
			Control.setBounds(new Rectangle(0, 0, 500, 100));
			// Control.setResizable(false);

			// NewGame, HighScore
			MenuItem Time = new MenuItem("");
			Time.setBackground(new Color(230, 100, 100));
			MenuItem HighScoreButton = new MenuItem("HIGH SCORE");
			HighScoreButton.setBackground(new Color(240, 240, 100));
			MenuItem NewGame = new MenuItem("NEW GAME");
			NewGame.setBackground(new Color(200, 100, 200));
			Control.add(HighScoreButton);
			Control.add(Time);
			Control.add(NewGame);
			Control.setVisible(true);
			Game.add("North", Control);
			Game.add("Center", Main2);
			Game.setVisible(true);

			boolean planting = true;
			int planted = 0;
			while (planting) {
				int posX = (int) (Math.random() * x);
				int posY = (int) (Math.random() * x);
				if (!minefield[posX][posY].hasBomb()) {
					planted++;
					minefield[posX][posY].plantBomb();
				}
				if (planted >= maxbomb) {
					planting = false;
				}
			}
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < x; j++) {
					int bombs = 0;
					try {
						if (minefield[i - 1][j - 1].hasBomb()) {
							bombs++;
						}
					} catch (ArrayIndexOutOfBoundsException e) {

					}
					try {
						if (minefield[i - 1][j].hasBomb()) {
							bombs++;
						}
					} catch (ArrayIndexOutOfBoundsException e) {

					}
					try {
						if (minefield[i - 1][j + 1].hasBomb()) {
							bombs++;
						}
					} catch (ArrayIndexOutOfBoundsException e) {

					}
					try {
						if (minefield[i][j - 1].hasBomb()) {
							bombs++;
						}
					} catch (ArrayIndexOutOfBoundsException e) {

					}
					try {
						if (minefield[i][j + 1].hasBomb()) {
							bombs++;
						}
					} catch (ArrayIndexOutOfBoundsException e) {

					}
					try {
						if (minefield[i + 1][j - 1].hasBomb()) {
							bombs++;
						}
					} catch (ArrayIndexOutOfBoundsException e) {

					}
					try {
						if (minefield[i + 1][j].hasBomb()) {
							bombs++;
						}
					} catch (ArrayIndexOutOfBoundsException e) {

					}
					try {
						if (minefield[i + 1][j + 1].hasBomb()) {
							bombs++;
						}
					} catch (ArrayIndexOutOfBoundsException e) {

					}
					minefield[i][j].scanned(bombs);

				}
			}
			boolean GameOver = false;
			boolean FullTiles = false;
			boolean FlaggedBomb = false;
			boolean BombClicked = false;
			boolean Win = true;
			long StartTime = System.currentTimeMillis();

			boolean StartNewGame = false;

			while (GameOver == false) {
				// Process auto clicking
				for (int i = 0; i < x; i++) {
					for (int j = 0; j < x; j++) {
						if (minefield[i][j].isClicked() && minefield[i][j].returnScanned() == 0) {
							try {
								minefield[i + 1][j - 1].forcedClick();
							} catch (ArrayIndexOutOfBoundsException e) {

							}
							try {
								minefield[i + 1][j].forcedClick();
							} catch (ArrayIndexOutOfBoundsException e) {

							}
							try {
								minefield[i + 1][j + 1].forcedClick();
							} catch (ArrayIndexOutOfBoundsException e) {

							}
							try {
								minefield[i][j - 1].forcedClick();
							} catch (ArrayIndexOutOfBoundsException e) {

							}
							try {
								minefield[i][j + 1].forcedClick();
							} catch (ArrayIndexOutOfBoundsException e) {

							}
							try {
								minefield[i - 1][j - 1].forcedClick();
							} catch (ArrayIndexOutOfBoundsException e) {

							}
							try {
								minefield[i - 1][j].forcedClick();
							} catch (ArrayIndexOutOfBoundsException e) {

							}
							try {
								minefield[i - 1][j + 1].forcedClick();
							} catch (ArrayIndexOutOfBoundsException e) {

							}

						}
					}
				}

				// Process HighScore Board events
				Time.setText(
						"Time: " + ((Integer) ((int) ((System.currentTimeMillis() - StartTime) / 1000))).toString());
				FlaggedBomb = false;
				FullTiles = true;
				for (int i = 0; i < x; i++) {
					for (int j = 0; j < x; j++) {

						// If all tiles are revealed/flagged DO NOT END GAME
						// WHEN FALSE
						if (minefield[i][j].flagged() || minefield[i][j].isClicked()) {

						} else {
							FullTiles = false;
						}

						// If a regular tile is flagged DO NOT END GAME WHEN
						// TRUE
						if (!minefield[i][j].hasBomb() && minefield[i][j].flagged()) {
							FlaggedBomb = true;
						}

						// If a bomb is clicked END GAME WHEN TRUE
						if (minefield[i][j].hasBomb() && minefield[i][j].isClicked()) {
							BombClicked = true;
							Win = false;
						}
					}
				}
				if ((FullTiles == true && FlaggedBomb == false) || BombClicked == true) {
					GameOver = true;
				}
				if (HighScoreButton.isClicked()) {
					HighScoreButton.unClick();
					HighScores.setVisible(true);
				}
				if (NewGame.isClicked()) {
					GameOver = true;
					StartNewGame = true;
					Win = false;
				}
			}
			int EndTime = (int) ((System.currentTimeMillis() - StartTime) / 1000);

			// processing score
			if (Win == true) {
				// processing score
				boolean added = false;
				for (int i = 0; i < HighScoreList.get(difficulty).size(); i++) {

					if (EndTime > HighScoreList.get(difficulty).get(i)) {

					} else {
						added = true;
						HighScoreList.get(difficulty).add(i, EndTime);
						break;
					}

				}
				if (added == false) {
					HighScoreList.get(difficulty).add(EndTime);
				}
				while(HighScoreList.get(difficulty).size()>10){
					HighScoreList.get(difficulty).remove(10);
				}

				// update score
				for (int i = 0; i < HighScoreList.get(difficulty).size(); i++) {
					HighScoreButtons[difficulty][i].setText(((Integer) (i+1)).toString() + ".   " + ((Integer) (HighScoreList.get(difficulty).get(i))).toString());
				}
				//EndUpdate
				for (int i = 0; i < 3; i++) {
					try{
					FileWriter fw = new FileWriter("HighScores"+i+".txt");
					for(int j = 0; j<10; j++){
						try{
							fw.write(HighScoreList.get(i).get(j)+" ");
						}catch(IndexOutOfBoundsException e){
							break;
						}
						
					}
					fw.close();
					}catch(IOException e){
						
					}
				}
				
			}
			
			JFrame Final = new JFrame();
			Final.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			Final.setSize(500, 300);
			Final.setResizable(false);
			JButton WinScreen = new JButton();
			WinScreen.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 40));
			if (StartNewGame == false) {
				if (Win) {
					WinScreen.setBackground(Color.green);
					WinScreen.setText("YOU WIN");
	
					Final.add(WinScreen);
				} else {
					WinScreen.setBackground(Color.red);
					WinScreen.setText("YOU LOST");
					Final.add(WinScreen);
				}
				Final.setVisible(true);
				// WHAT TO DO AFTER WIN/LOSS
				while (true) {
					if (HighScoreButton.isClicked()) {
						HighScoreButton.unClick();
						HighScores.setVisible(true);
					}
					if (NewGame.isClicked()) {
						Final.setVisible(false);
						GameRunning = true;
						Game.setVisible(false);
						break;
					}
				}
			} else {
				GameRunning = true;
				Game.setVisible(false);
			}

		}//End while 
	}


}
