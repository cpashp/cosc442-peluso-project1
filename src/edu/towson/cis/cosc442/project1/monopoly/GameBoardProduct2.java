package edu.towson.cis.cosc442.project1.monopoly;


import java.util.ArrayList;

public class GameBoardProduct2 {
	private GameBoardProduct2Product gameBoardProduct2Product = new GameBoardProduct2Product();
	private ArrayList<Card> communityChestCards = new ArrayList<Card>();

	public Card drawChanceCard() {
		return gameBoardProduct2Product.drawChanceCard(this.communityChestCards);
	}

	public void addCard(Card card) {
		gameBoardProduct2Product.addCard(card, this.communityChestCards);
	}

	public Card drawCCCard() {
		Card card = (Card) communityChestCards.get(0);
		communityChestCards.remove(0);
		gameBoardProduct2Product.addCard(card, this.communityChestCards);
		return card;
	}

	public void removeCards() {
		communityChestCards.clear();
	}
}