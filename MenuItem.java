import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
* FILE: MenuItem.java
*
* DESCRIPTION: This file contains the methods for MenuItem objects
*
***************************************************************************************/
public class MenuItem extends JButton {
	boolean clicked;
	public MenuItem(String name){
		setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 37));
		setText(name);
		clicked = false;
		addMouseListener(new Click());
	}
	
	/********************************************************************
	*
	* Method: isClicked
	*
	* Description: Returns clicked
	*
	* @param  None
	* 			
	* @return boolean
	* 		
	********************************************************************/
	public boolean isClicked(){
		return clicked;
	}
	/********************************************************************
	*
	* Method: unClick
	*
	* Description: Sets clicked to false
	*
	* @param  None
	* 			
	* @return None
	* 		
	********************************************************************/
	public void unClick(){
		clicked = false;
	}
	
	/********************************************************************
	*
	* Class: Click
	*
	* Description: implements MouseListener class
	* Determines what happens when certain mouse events occur
	*
	* 		
	********************************************************************/
	private class Click implements MouseListener{
		/********************************************************************
		*
		* Method: mouseReleased
		*
		* Description: 
		*
		* @param  MouseEvent
		* 			
		* @return none
		* 		
		********************************************************************/
		public void mouseReleased(MouseEvent mEvent){
			if(SwingUtilities.isLeftMouseButton(mEvent)){
				clicked = true;
			}
		}

		/********************************************************************
		*
		* Method: mouseClicked
		*
		* Description: 
		*
		* @param  MouseEvent
		* 			
		* @return none
		* 		
		********************************************************************/
		public void mouseClicked(MouseEvent e) {
			
		}

		/********************************************************************
		*
		* Method: mouseEntered
		*
		* Description: 
		*
		* @param  MouseEvent
		* 			
		* @return none
		* 		
		********************************************************************/
		public void mouseEntered(MouseEvent e) {
			
		}

		/********************************************************************
		*
		* Method: mouseExited
		*
		* Description: 
		*
		* @param  MouseEvent
		* 			
		* @return none
		* 		
		********************************************************************/
		public void mouseExited(MouseEvent e) {
			
		}

		/********************************************************************
		*
		* Method: mousePressed
		*
		* Description: 
		*
		* @param  MouseEvent
		* 			
		* @return none
		* 		
		********************************************************************/
		public void mousePressed(MouseEvent e) {
			
		}
	}
}
