package Lab5;

public class Testing {

	public static void main(String[] args) {
		Pile p = new Pile();
		
		p.createDeck();
		System.out.println("Top card on unshuffled deck is: " + p.printCard(p.remove()));
		
		p.shuffle(1);
		System.out.println("Top card on deck shuffled once is: " + p.printCard(p.remove()));
		
		p.shuffle(4);
		System.out.println("Top card on deck shuffled 4 times is: " + p.printCard(p.remove()));
		
		p.clear();
		System.out.println("Is the pile empty?");
		System.out.println(p.isEmpty());
		
		Pile a = new Pile();
		Pile b = new Pile();
		
		Card c = new Card(Rank.ACE, Suit.CLUB);
		Card d = new Card(Rank.ACE, Suit.DIAMOND);
		Card e = new Card(Rank.ACE, Suit.HEART);
		Card f = new Card(Rank.ACE, Suit.SPADE);
		
		a.add(c);
		a.add(d);
		a.printList();
		
		b.add(e);
		b.add(f);
		b.printList();
		
		a.union(b);
		a.printList();
		
		
		
		
		

	}

}
