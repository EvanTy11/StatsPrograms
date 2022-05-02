
//Poisson Class
public class Poisson {
double lambda, k;
//Constructor
public Poisson(double lambda, double k){

this.lambda = lambda;
this.k = k;
}
//method that calculates factorial and returns answer
    public double Factorial(double n) {
        double sum = n;
    for(int i = 0; i < n; i++) {
            if(i != 0) {
                sum = sum * i;             	       	
            }
         }
    return sum;
    }
//Method that calculate the Poisson formula and returns value
    public double DoPoisson(){
        return Math.pow(lambda, k) * Math.pow(Math.E, -lambda) / Factorial(k);
    }
    
   
}