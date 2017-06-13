/* 	Final project "Conway's Game of Life", AP Computer Science
 * 
 *  Copyright (C) 2017  Robert Ciliberto
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package elements;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Cell extends JLabel {
	private boolean isLiving;
	private boolean oldState;
	private int row, col;
	private Icon alive, dead;
	
	public Cell(int row, int col) {
		this.row=row;
		this.col=col;
		isLiving=false;
		oldState=true;

		alive=new ImageIcon("resources/cell/Cell_Alive.png");
		dead=new ImageIcon("resources/cell/Cell_Dead.png");
		
		updateUI();
	}
	
	public boolean isLiving(){
		return isLiving;
	}
	
	public boolean oldState(){
		return oldState;
	}
	
	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;
	}
	
	public void setLiving(){
		isLiving=true;
	}
	
	public void setDead(){
		isLiving=false;
	}
	
	public void toggle(){
		isLiving=!isLiving;
	}
	
	public void toggleAndUpdate(){
		toggle();
		updateUI();
	}
	
	@Override
	public void updateUI(){
		if(oldState!=isLiving){
			if(isLiving){
				setIcon(alive);
				super.updateUI();
			}
			else{
				setIcon(dead);
				super.updateUI();
			}
			oldState=isLiving;
		}
		
	}
	
	@Override
	public String toString(){
		String out;
		if(isLiving()) out="T";
		else out="F";
		return "Cell ("+row+","+col+") "+out;
	}
}
