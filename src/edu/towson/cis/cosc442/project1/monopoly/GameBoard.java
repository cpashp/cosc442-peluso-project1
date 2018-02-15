package edu.towson.cis.cosc442.project1.monopoly;

import java.util.ArrayList;
import java.util.Hashtable;

public class GameBoard {

	private GameBoardProduct2 gameBoardProduct2 = new GameBoardProduct2();
	private GameBoardProduct gameBoardProduct = new GameBoardProduct();
	//the key of colorGroups is the name of the color group.
	private Hashtable<String, Integer> colorGroups = new Hashtable<String, Integer>();
	public GameBoard() {
		Cell go = new GoCell();
		addCell(go);
	}

    public void addCard(Card card) {
        gameBoardProduct2.addCard(card);
    }
	
	public void addCell(Cell cell) {
		gameBoardProduct.getCells().add(cell);
	}
	
	public void addCell(PropertyCell cell) {
		String colorGroup = cell.getColorGroup();
		int propertyNumber = getPropertyNumberForColor(colorGroup);
		colorGroups.put(colorGroup, new Integer(propertyNumber + 1));
        gameBoardProduct.getCells().add(cell);
	}

    public Card drawCCCard() {
        return gameBoardProduct2.drawCCCard();
    }

    public Card drawChanceCard() {
        return gameBoardProduct2.drawChanceCard();
    }

	public Cell getCell(int newIndex) {
		return gameBoardProduct.getCell(newIndex);
	}
	
	public int getCellNumber() {
		return gameBoardProduct.getCellNumber();
	}
	
	public PropertyCell[] getPropertiesInMonopoly(String color) {
		PropertyCell[] monopolyCells = 
			new PropertyCell[getPropertyNumberForColor(color)];
		int counter = 0;
		for (int i = 0; i < gameBoardProduct.getCellNumber(); i++) {
			IOwnable c = gameBoardProduct.getCell(i);
			if(c instanceof PropertyCell) {
				PropertyCell pc = (PropertyCell)c;
				if(pc.getColorGroup().equals(color)) {
					monopolyCells[counter] = pc;
					counter++;
				}
			}
		}
		return monopolyCells;
	}
	
	public int getPropertyNumberForColor(String name) {
		Integer number = (Integer)colorGroups.get(name);
		if(number != null) {
			return number.intValue();
		}
		return 0;
	}

	public Cell queryCell(String string) {
		return gameBoardProduct.queryCell(string);
	}
	
	public int queryCellIndex(String string){
		return gameBoardProduct.queryCellIndex(string);
	}

    public void removeCards() {
        gameBoardProduct2.removeCards();
    }
}
