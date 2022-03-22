package Graph;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;


public class programplotter{
    String filename1 = "SaltedGraph.csv";
    String filename2 = "SmoothedGraph.csv";
    ArrayList<Integer> xval, yval, saltvalsint, smoothvals;
    ArrayList<String> saltvalsS;
    public String line =  "";
    String filename = "graph.csv";

    public programplotter(){
     xval = new ArrayList<Integer>();
     yval = new ArrayList<Integer>();
     saltvalsint = new ArrayList<Integer>();
     saltvalsS = new ArrayList<String>();
     smoothvals = new ArrayList<Integer>();
    }

    
    //Generates x values 
    public void genxvalues(){
       
        int x = -3;
        for(int i = 0; i < 7; i ++){
            xval.add(x);
            x++;
        }
        for(int i = 0; i < xval.size(); i++) {
             System.out.print(xval.get(i));   
        }
    }
    //Generates y values of y=mx +b
    public void genyvalues(){
     int genyval;
        for(int i = 0; i < xval.size(); i++) {
            genyval = (2 * xval.get(i)) + 3;
            yval.add(genyval);
       }
    }
    // Writes our original graph to csv
    public void writetographCSV(){
        try (PrintWriter pw = new PrintWriter(filename)){
            for(int i = 0; i < xval.size(); i++){
                pw.write( xval.get(i)+ ",");
             
            }
            pw.write("\n");
            for(int i = 0; i < xval.size(); i++){
                pw.write( yval.get(i)+ ",");
             
            }
            
        }  
        catch(FileNotFoundException e){
            System.out.println("Error creating or writing to file");
            e.printStackTrace();
        }  
    
    }
    //grabs data from original csv file and salts values
    public void salttheGraph(){
        Random rand = new Random();
        try{
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            int count = 0;
            while((line = br.readLine()) != null){
            String[] saltvalsS = line.split(",");
            if(count == 1){
            for(int i = 0; i < saltvalsS.length; i++){
                saltvalsint.add(Integer.parseInt(saltvalsS[i]));
                int newval = saltvalsint.get(i);
                saltvalsint.remove(i);
                if(i + 1 % 2 == 0){
                    newval = newval - rand.nextInt(9) + 1;
                    saltvalsint.add(newval);
                }else{
                    newval = newval + rand.nextInt(9) + 1;
                    saltvalsint.add(newval);
                }
                }
               
                 }
            count++;
            }
              
            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            }
            catch(IOException e){

            }
        }

        //outputs salted graph onto new csv
        public void writeSaltedGraph(){
            try (PrintWriter p2 = new PrintWriter(filename1)){
                for(int i = 0; i < xval.size(); i++){
                    p2.write( xval.get(i)+ ",");
                 
                }
                p2.write("\n");
                for(int i = 0; i < saltvalsint.size(); i++){
                    p2.write( saltvalsint.get(i)+ ",");
                 
                }
                
            }  
            catch(FileNotFoundException e){
                System.out.println("Error creating or writing to file");
                e.printStackTrace();
            } 
        } 
            //Smooths data and outputs as a csv
            public void writeSmoothedGraph(){
               
                for(int i = 0; i < saltvalsint.size() - 2; i++){
                    int smoothval =  (saltvalsint.get(i) + saltvalsint.get(i + 1) + saltvalsint.get(i + 2))/3;
                    smoothvals.add(smoothval);
                }
                
                try (PrintWriter p3 = new PrintWriter(filename2)){
                    for(int i = 0; i < saltvalsint.size(); i++){
                        p3.write( xval.get(i)+ ",");
                     
                    }
                    p3.write("\n");
                    for(int i = 0; i < smoothvals.size(); i++){
                        p3.write( smoothvals.get(i)+ ",");
                     
                    }
                    
                }  
                catch(FileNotFoundException e){
                    System.out.println("Error creating or writing to file");
                    e.printStackTrace();
                }     
        }
               
        
        
    
            
        
}   