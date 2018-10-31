package Lab5;

import java.util.Arrays;

public class Pile implements CardListInterface {
    private Card[] pile;
    private int numberOfEntries;
    private static final int MAX_CAPACITY = 52;
    
    //constructors
    public Pile () {
        pile = new Card[MAX_CAPACITY];
    }
    
    public void createDeck() {
    	//creates an array of ranks
    	Rank[] ranks = new Rank[13];
    	ranks[0] = Rank.ACE;
    	ranks[1] = Rank.TWO;
    	ranks[2] = Rank.THREE;
    	ranks[3] = Rank.FOUR;
    	ranks[4] = Rank.FIVE;
    	ranks[5] = Rank.SIX;
    	ranks[6] = Rank.SEVEN;
    	ranks[7] = Rank.EIGHT;
    	ranks[8] = Rank.NINE;
    	ranks[9] = Rank.TEN;
    	ranks[10] = Rank.JACK;
    	ranks[11] = Rank.QUEEN;
    	ranks[12] = Rank.KING;
    	
    	//creates an array of suits
    	Suit[] suits = new Suit[4];
    	suits[0] = Suit.SPADE;
    	suits[1] = Suit.CLUB;
    	suits[2] = Suit.DIAMOND;
    	suits[3] = Suit.HEART;
    	
    	int counter = 0;
    	for(int i = 0; i < 4; i++) {
    		for(int j = 0; j < 13; j++) {
    			Card c = new Card(ranks[j], suits[i]);
    			pile[counter] = c;
    			counter++;
    		}
    	}
    }
    
    public void shuffle(int numShuffled) {
    	
    }
    
    //method declarations
    @Override
    public void add (Card anEntry) {
      pile[numberOfEntries]  = anEntry;
      numberOfEntries ++;
      ensureCapacity();
    }
    
    public Card[] toArray() {
		Card[] result = (Card[]) new Object[numberOfEntries];
        for (int idx = 0; idx < numberOfEntries; idx ++)
            result[idx] = pile[idx];
        return result;
    }

    private void ensureCapacity(){
        int capacity = pile.length - 1; // last index
        if (numberOfEntries >= capacity) {
            capacity *= 2;
            pile = Arrays.copyOf(pile, capacity + 1);       
        }
        
    }

    private void makeRoom (int newPosition){
        assert (newPosition >= 0 && newPosition <= numberOfEntries);
        for (int index = numberOfEntries; index > newPosition; index --)
            pile[index] = pile[index-1];
    }	

    public void add (int newPosition, Card newEntry) {
    	makeRoom(newPosition);
    	pile[newPosition] = newEntry;
    	numberOfEntries++;
    	ensureCapacity();
    }
    
    private void removeGap(int position) {
    	for(int i=position; i < numberOfEntries-1; i++) {
    		pile[i] = pile[i+1];
    	}
    	pile[numberOfEntries - 1] = null;
    }
    
    //should this be a void?
    public Card remove (int givenPosition) {
    	if(givenPosition < 0 || givenPosition >= numberOfEntries) {
    		//the exception in Gia's notes, OutOfBoundariesException doesn't exist.. i think
    		throw new IndexOutOfBoundsException();    		
    	}
    	Card result = pile[givenPosition];
    	removeGap(givenPosition);
    	numberOfEntries--;
    	return result;
    }

    public boolean remove (Card anEntry) {
    	for(int i=0; i<numberOfEntries-1; i++) {
    		if(anEntry.equals(pile[i])) {
    			removeGap(i);
    			numberOfEntries--;
    			return true;
    		}
    			
    	}
		return false;
    }

    public void clear() {
    	for(int i = 0; i < numberOfEntries; i++) {
			pile[i] = null;
		}
    }

    /**
     * Replaces an entry at given position with a new one
     * @param givenPosition
     * @param newEntry
     * @return the replaced entry
     * @throws IndexOutOfBoundsException if either givenPosition < 0 or
     * givenPosition >= getLength()
     */
    public Card replace (int givenPosition, Card newEntry) {
    	if(givenPosition < 0 || givenPosition >= numberOfEntries) {
    		throw new IndexOutOfBoundsException();
    	}
    	pile[givenPosition] = newEntry;
    	return newEntry;
    };
    
    /**
     * Retrieves an entry at given position
     * @param givenPosition
     * @return the entry at givenPosition
     * @throws IndexOutOfBoundsException if either givenPosition < 0 or
     * givenPosition >= getLength()
     */
    public Card getEntry (int givenPosition) {
    	if(givenPosition < 0 || givenPosition >= numberOfEntries) {
    		throw new IndexOutOfBoundsException();
    	}
    	return pile[givenPosition];
    }
    
   /** Retrieves all entries that are in this pile in the order they occur in the pile.
   /* @ return a newly allocated array of all the entries in the pile
   /* If the pile is empty, the returned array is empty
    public Card[] toArray();
   
    
   /**
   /* Sees whether the pile contains the given entry
   /* @param anEntry the object: desired entry
   /* @return true if the pile contains anEntry; false if not.
   */
    public boolean contains (Card anEntry) {
    	for(int i=0; i < numberOfEntries-1; i++) {
    		if(pile[i] == anEntry) {
    			return true;
    		}    		
    	}
    	return false;
    }
    
    /**
    /* Gets the length of this pile
    /* @return the integer number of entries currently in the pile
    */
    public int getLength() {
    	return numberOfEntries;
    }
    
    /** 
    /* Sees whether this pile is empty
    /* return true if the pile is empty, false if not
    */
    public boolean isEmpty() {
    	if(numberOfEntries == 0) {
    		return true;
    	}
    	return false;
    }
    
    public void printList() {
    	for(int i = 0; i < numberOfEntries; i++) {
    		System.out.println(pile[i]);
    	}
    }
}
