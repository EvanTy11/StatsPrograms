package Distributions;
public class binomial {
    double success, trials, probofsucc, proboffailure;
public binomial(double success, double trials,double probofsucc, double proboffailure){
this.success = success;
this. trials = trials;
this.probofsucc = probofsucc;
this.proboffailure = proboffailure;

}
    public double Factorial(double n) {
        double sum = n;
    for(int i = 0; i < n; i++) {
            if(i != 0) {
                sum = sum * i;             	       	
            }
         }
    return sum;
    }

    public double Combination(double n, double r) {
        double answer1 =  0;
        double n1= 0, n2 = 0, n3 = 0;
        n1 = Factorial(n);
        n2 = Factorial(n - r);
        n3 = Factorial(r);
        answer1 = n1/ (n2 * n3);
        System.out.println(answer1);
        return answer1;
       
    }
    
    public void doBinomial(){
      double comb = Combination(trials, success);
      double answer = comb * ((Math.pow(probofsucc, 2)) * (Math.pow(proboffailure, 2)));
      System.out.print(answer);
    } 

}
