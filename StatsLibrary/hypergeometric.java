package StatsLibrary;

public class hypergeometric {
     double Popsize, samplesize, numofsucc, numofsuccchosen;
//Constrcutor
public hypergeometric(double Popsize, double samplesize, double numofsucc, double numofsuccchosen){

this.Popsize = Popsize;
this.samplesize = samplesize;
this.numofsucc = numofsucc;
this.numofsuccchosen = numofsuccchosen;

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
//Method that calculate the Hypergeomtric formula and returns value
    public void doHyperGeo(){
        double top = Popsize - numofsucc;
        double bottom = samplesize - numofsuccchosen;
        double a3 = Combination(top,bottom);
        double a4 = Combination(numofsucc, numofsuccchosen); 
        double a5 = Combination(Popsize, samplesize);       
        double answer = (a3 * a4)/a5;
        System.out.println("HyperGeometric: "+answer);

    }

   
}
