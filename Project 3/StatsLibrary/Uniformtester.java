import java.util.Scanner;
public class Uniformtester {
    public static void main(String[] args) {
        //Scanner
        Scanner scan = new Scanner(System.in);
        System.out.println("Number of minutes a person must wait for a taxi is uniformly distributed between enter your min val for waiting, \nthen your max val for waiting, then < or >, then finally enter the value you want to figure out");
        double min = scan.nextDouble();
        double max = scan.nextDouble();
        String g = scan.next();
        Double valsol = scan.nextDouble();
        //Creates object
        Uniform a = new Uniform();
        //Calls function
        a.UniDis(min,max,g,valsol);
        //Closes Scanner
        scan.close();
          
         
    }
}
