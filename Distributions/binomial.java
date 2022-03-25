package Distributions;
//Class
public class binomial {
    double x, n, probofsucc, proboffailure;
//Constructor
public binomial(double x, double n,double probofsucc,double proboffailure){
this.x = x;
this.n = n;
this.probofsucc = probofsucc;
this.proboffailure = proboffailure;

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
//Method that calcs combinationa and returns answer
    public double Combination(double n, double r) {
        double answer1 =  0;
        double n1= 0, n2 = 0, n3 = 0;
        n1 = Factorial(n);
        n2 = Factorial(n - r);
        n3 = Factorial(r);
        answer1 = n1/ (n2 * n3);  
        return answer1;
       
    }
//Method that calculate the Binomial formula and returns value
    public void doBinomial(){
      double comb = Combination(n,x);
      double answer = comb * ((Math.pow(probofsucc, 2)) * Math.pow((1 - proboffailure), n - x));
      System.out.print("Binomial: "+answer);
    } 

}
