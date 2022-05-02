//import statements
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.util.ArrayList;
import java.util.Random;

//Class
public class jfreewoldcode extends ApplicationFrame {
    ArrayList<Integer> xval = new ArrayList<Integer>();
    ArrayList<Integer> yval = new ArrayList<Integer>();
    int userval;
 //Constructor
   public jfreewoldcode( String applicationTitle , String chartTitle, int uservals) {
      super(applicationTitle);
      this.userval = uservals;
      //Creates XYSeries
      JFreeChart lineChart = ChartFactory.createXYLineChart(
         chartTitle,
         "xvals","yvals",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
        //Creates panel
      ChartPanel chartPanel = new ChartPanel(lineChart);
      chartPanel.setPreferredSize( new java.awt.Dimension( 500 , 500 ) );
      setContentPane( chartPanel );
   }
/*Function name that creates our data set and creates values for our x array and then generates values 
for our y array and then salts and smooths the data this is done using my old code from project 2 with 
a combination of JFree charts which we construct and use a XYSeries to add data too and graph each individually.Then returns
the dataset 
*/
   private XYDataset createDataset() {
    Random rand = new Random();
    int newx = 0;
    for(int i = 0; i < userval; i++) {
        newx =  newx + 1;
        xval.add(newx);
    }
    final XYSeries reggraph = new XYSeries("lineargraph");
    int yvalgen;
    for(int i = 0; i < xval.size(); i++) {
        yvalgen = (2 * xval.get(i)) + 3;
        yval.add(yvalgen);
        reggraph.add( xval.get(i), yval.get(i) );
    }
  
   
    final XYSeries salteddata = new XYSeries("Salted");

 
    for(int i = 0; i < yval.size(); i++){
         int newval = yval.get(i);
        if(i + 1 % 2 == 0){
             newval = newval - rand.nextInt(15) + 1;
             yval.set(i, newval);
        }else{
            newval = newval + rand.nextInt(15) + 1;
            yval.set(i, newval);
        }
        salteddata.add(xval.get(i), yval.get(i));
    }
   
    final XYSeries smoothed = new XYSeries("Smoothed");
    ArrayList<Integer> smoothvals = new ArrayList<Integer>();
    for(int i = 0; i < yval.size() - 2; i++){
        int smoothval =  (yval.get(i) + yval.get(i + 1) + yval.get(i + 2))/3;
        smoothvals.add(smoothval);
        smoothed.add(xval.get(i), smoothvals.get(i));
    }
   
   
   
    final XYSeriesCollection dataset = new XYSeriesCollection();
    dataset.addSeries(reggraph);
    dataset.addSeries(salteddata);
    dataset.addSeries(smoothed);
   
    return dataset;
   
}

}
