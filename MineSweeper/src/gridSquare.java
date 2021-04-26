import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border; 

public class gridSquare extends JLabel implements MouseListener{
	
	Boolean overLap;
	Boolean isBomb = false;
	int gridNum;
	int numBombs;
	int neighbors[] = new int[8];
	boolean isClicked = false;
	
	gridSquare(int gridNum){
		
		this.gridNum = gridNum;
		
		neighbors[0] = gridNum - 10 - 1; //Top left 
		neighbors[1] = gridNum - 10 ; //Top center
		neighbors[2] = gridNum - 10 + 1; //Top Left
		neighbors[3] = gridNum - 1;//center left
		neighbors[4] = gridNum + 1;//center right
		neighbors[5] = gridNum + 10 -1;//Bottom Left
		neighbors[6] = gridNum + 10; //Bottom Center
		neighbors[7] = gridNum + 10 + 1; //Bottom Right
		
		setText("");
		
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		setFont(new Font("Copperplate Gothic Bold",Font.PLAIN,20));
		setForeground(new Color(0x000000)); //set font color CHANGE FOR EACHER NUMBER
		setSize(50,50);
		
		Border border = BorderFactory.createLineBorder(new Color(0x808080),5);
		setBorder(border);
		
		setBackground(new Color(0xd3d3d3)); //set background color ----- change to #424242 after clicked
		setOpaque(true);//display background color
		
		addMouseListener(this);
		
		}
	
	public void revealNeighbors() {
			minesweeperFrame frame = (minesweeperFrame) SwingUtilities.getWindowAncestor(this);
			
		if(this.getNumBombs() == 0) {
			for(int i:neighbors) {
				if(i > -1 && i < 80 ) {
					if(!frame.getSquares().get(i).getIsBomb()) { 
						frame.getSquares().get(i).setTextColor();
						frame.getSquares().get(i).setText(String.valueOf((frame.getSquares().get(i).getNumBombs())));
						frame.getSquares().get(i).setBackground(new Color(0xc0c0c0));
					}
				}
			}
		}
	}
	public void setTextColor() {
		if(getNumBombs() == 1) {
			setForeground(new Color(0x0001fd));
		}else if(getNumBombs() == 2) {
			setForeground(new Color(0x017e00));
		}else if(getNumBombs() == 3) {
			setForeground(new Color(0xfe0001));
		}else if(getNumBombs() == 4) {
			setForeground(new Color(0x010180));
		}else if(getNumBombs() == 5) {
			setForeground(new Color(0x7e0300));
		}else if(getNumBombs() == 6) {
			setForeground(new Color(0x008080));
		}else if(getNumBombs() == 7) {
			setForeground(new Color(0x000000));
		}else if(getNumBombs() == 8) {
			setForeground(new Color(0x808080));
		}
	}
	
	public void fixOverlap() {
		
for(int i:neighbors) {
	
			if(i > -1 && i < 80 && i % 10 != 9  && i % 10 != 0) {
							
			i = -1;

			}
		}
		
	}
	
	public int getNumBombs() {
		minesweeperFrame frame = (minesweeperFrame) SwingUtilities.getWindowAncestor(this);
		
		//Checks if its a bomb and returns -1
		if(!isClicked) {
		
			if(isBomb) {
				numBombs = -1;
				return numBombs ;
		}
		//Checks for how many bombs surround it.
		for(int i:neighbors) {
			
			if(i > -1 && i < 80 ) {
				if(frame.getSquares().get(i).getIsBomb()) { // if any neighbor is a bomb increase bombNumber 
					numBombs++;
				}
			}
		}
			isClicked = true;	
		}
		return numBombs;
	}
	
	public Boolean getIsBomb() {
		return isBomb;
	}

	public void setIsBomb(Boolean isBomb) {
		this.isBomb = isBomb;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getButton() == MouseEvent.BUTTON1) {
			
			
				if(isBomb) {
					setText("bomb");
					setBackground(new Color(0xc0c0c0));

					} else if(!isClicked) {
						setTextColor();
						setText(String.valueOf((this.getNumBombs())));
						revealNeighbors();
						setBackground(new Color(0xc0c0c0));
						
						isClicked = true;
					}
				
				}
				
			 if(e.getButton() == MouseEvent.BUTTON3) {
				 
				 setText("Flag");
				 
		        }
		}	

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
