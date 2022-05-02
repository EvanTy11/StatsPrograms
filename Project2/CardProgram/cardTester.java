package Project2.CardProgram;

public class cardTester {

	public static void main (String args[]) {
		//creates object c of class card
		CardSim c = new CardSim(10000);
		//creates deck
        c.CreateDeck();
		//runs sim
        c.pokerhandCalc();
	}

		
}
