package edu.towson.cis.cosc442.project1.monopoly;

public class UtilityCell extends Cell {

	public static final String COLOR_GROUP = "UTILITY";
	private static int PRICE;

	public static void setPrice(int price) {
		UtilityCell.PRICE = price;
	}

	public int getPrice() {
		return UtilityCell.PRICE;
	}

	public int getRent(int diceRoll) {
		if(theOwner.numberOfUtil() == 1) {
			return diceRoll * 4;
		} else if (theOwner.numberOfUtil() >= 2) {
			return diceRoll * 10;
		}
		return 0;
	}

	public Boolean playAction(String msg) {
		Player currentPlayer = null;
		if(!isAvailable()) {
			currentPlayer(currentPlayer);
		}
		return null;
	}

	private void currentPlayer(Player currentPlayer) {
		currentPlayer = GameMaster.instance().getCurrentPlayer();
		if (theOwner != currentPlayer) {
			GameMaster.instance().utilRollDice();
			int diceRoll = GameMaster.instance().getUtilDiceRoll();
			currentPlayer.payRentTo(theOwner, getRent(diceRoll));
		}
	}

	public void playerMoved(Player player, int playerIndex, GameMaster gameMaster) {
		if (this.isAvailable()) {
			int price = this.getPrice();
			if (price <= player.getMoney() && price > 0) {
				gameMaster.getGUI().enablePurchaseBtn(playerIndex);
			}
		}
		gameMaster.getGUI().enableEndTurnBtn(playerIndex);
	}
}
