package Project2.CardProgram;
//Worked on this project with Ruth Wittek and John Huges in class

import java.util.ArrayList;
import java.util.Random;
public class CardSim {
public ArrayList<Card> list, fivecards, shuffled;
public int onepsucc, twopsucc, toksucc, fhsucc, foaksucc, straightsucc, flushsucc;
double trials, onepsuccres;
//Constructor
public CardSim(double trials) {
this.trials = trials;
list = new ArrayList<Card>();
fivecards = new ArrayList<Card>();
shuffled = new ArrayList<Card>();
}
//runs the pokerhand simulation
public void pokerhandCalc( ){
    for(int i = 0; i < trials; i++){
     shuffle();
     fiveRandomCards();
    }
    Stats();
}
// Creates a deck of 52 cards no jokers
	public void CreateDeck() {
		ArrayList<String> suite = new ArrayList<String>();
		String Spades = "Spades", Diamonds = "Diamonds", Hearts = "Hearts", Clubs = "Clubs";
		suite.add(Spades);
		suite.add(Diamonds);
		suite.add(Hearts);
		suite.add(Clubs);
		int time = 13;
		int suiteselect = 0;
			for(int i = 0; i < 55; i ++) {
					if(time > 0) {
					list.add(new Card(suite.get(suiteselect),time));
					time--;	
					}
					else {
					suiteselect++;
					time = 13;
					}
				}
			}
            //Draws one card
            public void drawCard(){
                Random rand1 = new Random();
                int drawran = rand1.nextInt(list.size());
                System.out.println( "Card" + list.get(drawran).getSuite() + list.get(drawran).getNumber());

            }
    //Shuffles the deck of 52 cards so cards are in random positions 
    public void shuffle(){
        shuffled.clear();
        Random shufpicker = new Random();
        int numshuf;
        String suiteshuf;
        int shufrandnum;
        for(int i= 0; i < list.size(); i++) {
    
            shufrandnum = shufpicker.nextInt(list.size());
            numshuf = list.get(shufrandnum).getNumber();
            suiteshuf =  list.get(shufrandnum).getSuite();
           shuffled.add(new Card(suiteshuf,numshuf));
        }
    }
    //Draws five random cards
	public void fiveRandomCards(){
        Random rand = new Random();
        int ranNum;
        String ranSuite;
        System.out.println("\nFive random cards:");
        for(int i = 0; i < 5; i ++){
            int rand1 = rand.nextInt(shuffled.size());
            ranSuite = shuffled.get(rand1).getSuite();
            ranNum = shuffled.get(rand1).getNumber();
            System.out.println(ranSuite + ranNum);
            shuffled.remove(list.get(rand1));
            fivecards.add(new Card(ranSuite,ranNum));
        }
        isPair();
        isStraight();
        isFlush();
        int ranNum1;
        String ranSuite1;
        for(int i = 0; i < fivecards.size(); i ++){
            ranNum1 = fivecards.get(i).getNumber();
            ranSuite1 = fivecards.get(i).getSuite();
            shuffled.add(new Card(ranSuite1, ranNum1));
        }
        fivecards.clear();
    }

    //Returns the deck that is generated
	public void getDeck(){
        
        for(int i= 0; i < list.size(); i++) {
            System.out.println("Card" + " " + list.get(i).getSuite()+ list.get(i).getNumber()+" ");
        }
      

			}
    //Checks for certain hands
    public void isPair(){
        int pair = 0;
        for (int i = 0; i < fivecards.size()-1; i++) {
             for (int j = i+1; j < fivecards.size(); j++) {
            if(fivecards.get(i).getNumber() == fivecards.get(j).getNumber()){
               
                pair++;
                System.out.println(pair);
            }
            if(i == fivecards.size() - 2){
                if(pair == 1){
                    System.out.println("One Pair");
                    onepsucc++;
                }
                if(pair == 2){
                    System.out.println("Two Pair");
                    twopsucc++;
                }
                if(pair == 3){
                    System.out.println("Three of a kind");
                    toksucc++;
                }
                if(pair == 4){
                    System.out.println("Full House");
                    fhsucc++;
                }
                if(pair == 6){
                    System.out.println("Four of a kind");
                    foaksucc++;
                }
             
            }
          }
        }
      }
      //checks for a straight
    public void isStraight(){
       
        int Straight = 0;
        for(int i = 0; i < fivecards.size(); i++){
           if(i >= fivecards.size() + 1 - fivecards.size()){
            if(fivecards.get(i - 1).getNumber() > fivecards.get(i).getNumber()){
                Straight++;
            }
            if(i == fivecards.size() - 1){
                if(Straight == 4){
                    //Five cards in descending order
                    System.out.println("\n It is a Straight");
                    straightsucc++;
                }
            }
           
          

           }
        }

    }
    //checks for a flush
    public void isFlush(){
       
        int Flush = 0;
        for(int i = 0; i < fivecards.size(); i++){
           if(i >= fivecards.size() + 1 - fivecards.size()){
            if(fivecards.get(i - 1).getSuite() == fivecards.get(i).getSuite()){
                Flush++;
            }
            if(i == fivecards.size() - 1){
                if(Flush == 4){
                    //Five cards in descending order
                    System.out.println("\n It is a Flush");
                    flushsucc++;
                }
            }

           }
        }

    }
    //Prints out stats of hands
    public void Stats(){
            
System.out.println("Percentage of One Pairs"+ onepsucc * 100/ trials+"%" +"\nPercentage of two pairs" + twopsucc * 100 /trials+"%"+"\nPercentage of three of a kind"+ toksucc * 100 /trials +"%"+"\nPercentage of Full houses"+ fhsucc * 100 /trials +"\nPercentage of four of a kind" + foaksucc * 100 /trials+ "%" +"\nPercentage of straight" +straightsucc * 100 /trials+"%" + "\nPercentage of flush"+ flushsucc * 100 /trials+"%");
    }

    }
	

