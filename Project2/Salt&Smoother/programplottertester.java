package Project2;
public class programplottertester{

    public static void main(String args[]){
        programplotter c = new programplotter();
        c.genxvalues();
        c.genyvalues();
        c.writetographCSV();
        c.salttheGraph();
        c.writeSaltedGraph();
        c.writeSmoothedGraph();
    }
    
}