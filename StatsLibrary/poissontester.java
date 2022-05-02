package StatsLibrary;
//Tester class
public class poissontester {
    //Main Method
    public static void main(String[] args) {
        //Creates instance of class poisson and calls method to solve
        Poisson p = new Poisson(4.6,3);
        System.out.println("Poisson: "+p.DoPoisson());
    } 
}
