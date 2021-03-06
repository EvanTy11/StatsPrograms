//import statements
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.analysis.function.Multiply;
import org.apache.commons.math3.stat.descriptive.moment.Mean;

//Class
public class jfreecommons extends ApplicationFrame {
  int userval; 
  //constructor
    public jfreecommons( String applicationTitle , String chartTitle, int uservals) {
        super(applicationTitle);
        this.userval = uservals;
        //Creates XYSeries
        JFreeChart lineChartco = ChartFactory.createXYLineChart(
           chartTitle,
           "xvals","yvals",
           createDataset(),
           PlotOrientation.VERTICAL,
           true,true,false);
        
           //Creates panel
        ChartPanel chartPanel = new ChartPanel(lineChartco);
        chartPanel.setPreferredSize( new java.awt.Dimension( 500 , 500 ) );
        setContentPane( chartPanel );
     }
    /*Function name that creates our data set and creates values for our x array and then generates values 
    for our y array and then salts and smooths the data this is done using w
    a combination of JFree charts and apache commons which we construct and use a XYSeries to add data too and graph each individually.Then returns
    the dataset 
    */
   private XYDataset createDataset() {
    final XYSeries reggraph = new XYSeries("lineargraph");
    JDKRandomGenerator randomnum = new JDKRandomGenerator();
    double genx;
    Double[] xval = new Double[userval];
    
    for (int i = 0; i < userval; i++){
      genx  = randomnum.nextDouble(1.0, 10.0);
      xval[i] = genx;
     
    }

    double yvalgen;
    Multiply m = new Multiply();
    Double[] yval = new Double[userval];
    for(int i = 0; i < xval.length; i++) {

        yvalgen = (m.value(2,(xval[i] + 3)));
        yval[i] = yvalgen;
        reggraph.add(xval[i], yval[i]);
    }
    
  
    final XYSeries salteddata = new XYSeries("Salted");
    boolean flag = true;
    double newval = 0;
    for(int i = 0; i < yval.length; i++){
      
        if(flag){
             newval = yval[i] - randomnum.nextDouble(1.0, 15.0);
             yval[i] = newval;
             flag = false;
        }else{
            newval = yval[i] + randomnum.nextDouble(1.0, 15.0);
            yval[i] = newval;
            flag = true;
        }
        salteddata.add(xval[i], yval[i]);
    }
   
    final XYSeries smoothed = new XYSeries("Smoothed");
   
   Mean m1 = new Mean();
   Double[] mean = new Double[userval - 2];
    for(int i = 0; i < yval.length - 2; i++){
        m1.increment(yval[i]);
        m1.increment(yval[i + 1]);
        m1.increment(yval[i + 2]);
        mean[i] = m1.getResult();
        m1.clear();
        smoothed.add( xval[i], mean[i]);
    }
   
    final XYSeriesCollection dataset = new XYSeriesCollection();
    dataset.addSeries(reggraph);
    dataset.addSeries(salteddata);
    dataset.addSeries(smoothed);
   
    return dataset;
   
}

   
}