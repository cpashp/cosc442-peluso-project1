package edu.towson.cis.cosc442.project1.monopoly;

public class CardCell extends Cell {
    private int type;
	public CardCell(int type, String name) {
        setName(name);
        this.type = type;
    }
    
    public Boolean playAction(String msg) {
    	return null;
    }
    
    public int getType() {
        return type;
    }
}
