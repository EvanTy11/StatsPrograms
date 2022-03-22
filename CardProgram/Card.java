package CardProgram;

public class Card {
int number;
String suite;
//Constructor
public Card(String suite, int number) {
this.number = number;
this.suite = suite;
}
//getter
public String getSuite() {
return suite;	
}
//getter
public int getNumber() {
return number;
}
}
