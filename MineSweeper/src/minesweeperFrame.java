import java.awt.GridLayout;
import java.awt.color.*;
import java.util.ArrayList;

import javax.swing.*;


public class minesweeperFrame extends JFrame{
	

	private final int numColumns = 10;
	private int numRows = 8;
	
	int numBombs = 0;
	
	ArrayList<gridSquare> squares = new ArrayList<gridSquare>();
	
	minesweeperFrame(){
		
		setTitle("Minesweeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,850);
		setResizable(false);
		setLayout(new GridLayout(numRows,numColumns,1,1));
		setVisible(true);
		
		
		//Fill Arraylist and add to frame
		for(int i = 0; i < 80;i++) {
			squares.add(new gridSquare(i));
			add(squares.get(i));
		}
		
		//AddBombs
		while(numBombs < 10) {
			squares.get((int) (Math.random()*80)).setIsBomb(true);
			numBombs++;
		}
				
	}

	
	public ArrayList<gridSquare> getSquares() {
		return squares;
	}
	
	public int getGridRows() {
		return numRows;
	}

	public int getGridColumns() {
		return numColumns;
	}
	
	
	
}
