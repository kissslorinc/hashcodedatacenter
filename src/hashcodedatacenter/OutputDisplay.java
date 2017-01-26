package hashcodedatacenter;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class OutputDisplay {
	void displayOutput() {
		JFrame outputFrame=new JFrame();
		outputFrame.setSize(600, 600);
		
		outputFrame.add(new JComponent(){
			
			protected void paintComponent(Graphics g) {
				int topMargin=100;
				int sideMargin=100;
				
				int numOfRows=DataCenter.rows.size();
				int numOfColumns=DataCenter.rows.get(0).slots.size();
				
				int minLeft;
				int currX;
				int currY;
				int slotSize;
				
				if (numOfColumns>numOfRows) {
					minLeft=sideMargin;
					slotSize=(outputFrame.getWidth()-2*sideMargin)/numOfColumns;
					currY=(outputFrame.getHeight()-slotSize*numOfRows)/2;
				} else {
					currY=sideMargin;
					slotSize=(outputFrame.getHeight()-2*topMargin)/numOfRows;
					minLeft=(outputFrame.getWidth()-slotSize*numOfColumns)/2;
				}
				
				currX=minLeft;
				Random rand=new Random();
							
				for (Row r : DataCenter.rows) {
					for (Slot s : r.slots) {
						g.setColor(new Color(rand.nextInt()));
						if (s.enabled) g.fillRect(currX, currY, slotSize,slotSize);
						currX+=slotSize;
					}
					currX=minLeft;
					currY+=slotSize;
				}
				
				g.drawString("Score: " +Integer.toString(calculateScore()), 50, 50);
				
			}
			
			int calculateScore() {
				int score=-1;
				for (int inactiveRowIndex=0;inactiveRowIndex<DataCenter.rows.size();inactiveRowIndex++) {
					for (Pool p : DataCenter.pools) {
						int poolSum=0;
						for (Server s : p.servers) {
							
						}
					}
				}				
				return 18;
			}
		});
		
		
		outputFrame.setVisible(true);		
	}
}
