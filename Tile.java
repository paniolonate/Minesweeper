import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

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
* FILE: Tile.java
*
* DESCRIPTION: This file contains the methods for Tile objects
*
***************************************************************************************/
public class Tile extends JButton{
	private boolean checked, bomb, flagged;
	private Integer nearbyBombs, diff;
	private Icon flagIcon, bombIcon;
	
	/********************************************************************
	*
	* Method: Tile
	*
	* Description: Constructs a Tile object
	*
	* @param  boolean isbomb, int Difficulty
	* 			
	* @return none
	* 		
	********************************************************************/
	public Tile(boolean isbomb, int Difficulty){
		setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 40));
		nearbyBombs = 0;
		checked = false;
		diff = Difficulty;
		bomb = isbomb;
		flagged = false;
		if(diff==0){
			flagIcon = new ImageIcon("flag1.png");
			bombIcon = new ImageIcon("bomb1.png");
		}else if(diff == 1){
			flagIcon = new ImageIcon("flag1.png");
			bombIcon = new ImageIcon("bomb1.png");
			setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 30));
		}else{
			flagIcon = new ImageIcon("flag2.png");
			bombIcon = new ImageIcon("bomb2.png");
			setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		}
		
		addMouseListener(new Sweep());
		setBackground(new Color(200,200,175));
	}
	
	/********************************************************************
	*
	* Method: isClicked
	*
	* Description: Returns checked
	*
	* @param  None
	* 			
	* @return boolean
	* 		
	********************************************************************/
	public boolean isClicked(){
		return checked;
	}
	
	/********************************************************************
	*
	* Method: flagged
	*
	* Description: Returns flagged
	*
	* @param  None
	* 			
	* @return boolean
	* 		
	********************************************************************/
	public boolean flagged(){
		return flagged;
	}
	
	/********************************************************************
	*
	* Method: returnScanned
	*
	* Description: Returns nearbyBombs
	*
	* @param  None
	* 			
	* @return int
	* 		
	********************************************************************/
	public int returnScanned(){
		return nearbyBombs;
	}
	
	/********************************************************************
	*
	* Method: scanned
	*
	* Description: Sets the value of amount to nearbyBombs
	*
	* @param  int amount
	* 			
	* @return None
	* 		
	********************************************************************/
	public void scanned(int amount){
		nearbyBombs = amount;
	}
	
	/********************************************************************
	*
	* Method: hasBomb
	*
	* Description: returns bomb
	*
	* @param  None
	* 			
	* @return boolean
	* 		
	********************************************************************/
	public boolean hasBomb(){
		return bomb;
	}
	
	/********************************************************************
	*
	* Method: plantBomb
	*
	* Description: Sets the value of bomb to true
	*
	* @param  None
	* 			
	* @return None
	* 		
	********************************************************************/
	public void plantBomb(){
		bomb = true;
	}
	
	/********************************************************************
	*
	* Method: forcedClick
	*
	* Description: Performs actions of Tile depending if it is a bomb or not
	* 				Acts as if the tile was clicked by the user
	*
	* @param  None
	* 			
	* @return None
	* 		
	********************************************************************/
	public void forcedClick(){
		if(flagged == false){
			if(bomb == true){
				setIcon(bombIcon);
				setBackground(new Color(200,100,100));
				checked = true;
			} else {
				if (nearbyBombs != 0) {
					setText(nearbyBombs.toString());
				}
				setBackground(new Color(150,150,150));
				checked = true;

			}
		}
	}
	
	/***************************************************************************************
	*
	*
	* Class: Sweep.java
	*
	* Description: This file contains the methods for Sweep and implements MouseListener
	* 	Sweep handles what to do when a mouse event occurs for the tile
	* 
	* 
	* NOTE: Multiple methods are not used but declared only to meet requirements of MouseListener interface
	*
	***************************************************************************************/
	private class Sweep implements MouseListener{
		
		/********************************************************************
		*
		* Method: mouseReleased
		*
		* Description: Performs actions for sweeping Tiles
		*
		* @param  MouseEvent mEvent
		* 			
		* @return None
		* 		
		********************************************************************/
		public void mouseReleased(MouseEvent mEvent){
			if(SwingUtilities.isRightMouseButton(mEvent)){
				if(flagged == false && checked == false){
					setBackground(new Color(200,200,210));
					setIcon(flagIcon);
					flagged = true;
				}else if(checked == false){
					setBackground(new Color(200,200,175));
					flagged = false;
					setIcon(null);
				}				
			}else if(SwingUtilities.isLeftMouseButton(mEvent)){
				if(flagged == false){
					if(bomb == true){
						setIcon(bombIcon);
						setBackground(new Color(200,100,100));
						checked = true;
					} else {
						if (nearbyBombs != 0) {
							setText(nearbyBombs.toString());
						}
						setBackground(new Color(150,150,150));
						checked = true;

					}
				}
			}
		}
		/********************************************************************
		*
		* Method: mouseClicked
		*
		* Description: 
		*
		* @param  MouseEvent arg0
		* 			
		* @return None
		* 		
		********************************************************************/
		public void mouseClicked(MouseEvent arg0) {
			
		}

		/********************************************************************
		*
		* Method: mouseEntered
		*
		* Description: 
		*
		* @param  MouseEvent arg0
		* 			
		* @return None
		* 		
		********************************************************************/
		public void mouseEntered(MouseEvent arg0) {
			
		}

		/********************************************************************
		*
		* Method: mouseExited
		*
		* Description: 
		*
		* @param  MouseEvent arg0
		* 			
		* @return None
		* 		
		********************************************************************/
		public void mouseExited(MouseEvent arg0) {
			
		}

		/********************************************************************
		*
		* Method: mousePressed
		*
		* Description: 
		*
		* @param  MouseEvent arg0
		* 			
		* @return None
		* 		
		********************************************************************/
		public void mousePressed(MouseEvent arg0) {
			
		}

	}

		
		
	
}
