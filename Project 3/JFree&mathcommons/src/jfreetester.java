

import org.jfree.ui.RefineryUtilities;
public class jfreetester {
    //runs both graphs
    public static void main( String[ ] args ) {
        //creates the chart1 object which is passed values for the parameters which also helps in determining window size and showing the window
        jfreewoldcode chart1 = new jfreewoldcode(
           "RegGrpah/Salted/Smoothed/oldcode" ,
           "Graphs",100);
      
        chart1.pack( );
        RefineryUtilities.centerFrameOnScreen(chart1);
        chart1.setVisible( true );
        
        //creates the chart2 object which is passed values for the parameters which also helps in determining window size and showing the window
        jfreecommons chart2 = new jfreecommons(
            "regraph/salter/smoother/apache" ,
            "Graphs", 100);
   
         chart2.pack( );
         RefineryUtilities.centerFrameOnScreen(chart2);
         chart2.setVisible( true );
     }
  }

