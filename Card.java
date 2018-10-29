package Lab5;

public class Card {
	private Rank rank;
	private Suit suit;
	
	public Card(Rank r, Suit s) {
		rank = r;
		suit = s;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public void setSuit(Suit s) {
		suit = s;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public void setRank(Rank r) {
		rank = r;
	}
}
