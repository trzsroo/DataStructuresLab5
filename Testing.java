package Lab5;

public class Testing {

	public static void main(String[] args) {
		Pile p = new Pile();
		
		p.createDeck();
		System.out.println(p.printCard(p.remove()));
		
		p.shuffle(1);
		System.out.println(p.printCard(p.remove()));
		

	}

}
