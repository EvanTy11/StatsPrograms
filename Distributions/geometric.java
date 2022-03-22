package Distributions;
public class geometric{
final double p, n;
//Constructer
    public geometric(double p, double n){
        this.n = n;
        this.p = p;
    }
    //Calculates geometricmean
    public void doGeometric(){
        final double r = Math.pow(1.0-p, n-1) * p;
    
        System.out.printf("%.3f", r);
        
    }
    
}