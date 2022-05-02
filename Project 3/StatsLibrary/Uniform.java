public class Uniform {
    //Function which depending on what the user chooses calculates the probability of a person waiting for a bus > or < the value the user enter using uniform distribution
            public void UniDis(double min, double max, String gol, double valsol){
                System.out.println(min+" "+max+" "+gol+" "+valsol);
            double denfunc;
            double sol = 0.0; 
            String lthen = "<";
            denfunc = 1/(max - min);
            if(gol.equals(lthen)){
               sol = ((valsol - min) * denfunc);
               System.out.println("The probability of someone waiting < "+valsol+" is "+sol);
            }
            else{
                sol = ((max - valsol) * denfunc);
                System.out.println("The probability of someone waiting < "+valsol+" minutes is "+sol);

            }
            }
            
    
        }
     

