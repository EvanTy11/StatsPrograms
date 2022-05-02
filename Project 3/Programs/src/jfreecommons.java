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


public class jfreecommons extends ApplicationFrame {
   
   public jfreecommons( String applicationTitle , String chartTitle ) {
      super(applicationTitle);
      //Creates our chart
      JFreeChart lineChart = ChartFactory.createXYLineChart(
         chartTitle,
         "xvals","yvals",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
      //Created our panel
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 500 , 500 ) );
      setContentPane( chartPanel );

   }

   private XYDataset createDataset() {
    final XYSeries reggraph = new XYSeries("lineargraph");
    JDKRandomGenerator randomnum = new JDKRandomGenerator();
    double genx;
    int userval = 150;
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
        reggraph.add( xval[i], yval[i] );
    }
    
  
    final XYSeries salteddata = new XYSeries("Salted");
    boolean flag = true;
    for(int i = 0; i < yval.length; i++){
      
         double newval = yval[i];
        if(flag){
             newval = newval - randomnum.nextDouble(1.0, 15.0);
             yval[i] = newval;
             flag = false;
        }else{
            newval = newval + randomnum.nextDouble(1.0, 15.0);
            yval[i] = newval;
            flag = true;
        }
        System.out.print(newval);
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
        System.out.print(mean[i]);
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