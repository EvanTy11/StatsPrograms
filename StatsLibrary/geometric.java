package StatsLibrary;
//Geometric Class
public class geometric{
final double p, n;
    //Constructer
    public geometric(double p, double n){
        this.n = n;
        this.p = p;
    }
    //Method that calculate the Geometric formula and returns value
    public void doGeometric(){
        final double r = Math.pow(1.0-p, n-1) * p;
    
        System.out.printf("Geometric"+"%.3f", r);
        
    }
    
}