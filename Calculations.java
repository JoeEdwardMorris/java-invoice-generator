package rwp.invoice.generator.v1;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Performs necessary calculations and stores variables in correct format
 * as well as parsing them for calculations and correct output format
 * @author rachelwhiting
 */
public class Calculations {
    
    //Invoice number in numerical form
    private static int myInvoiceNum=0; 
    
    //Today's date for invoice date
    private static Date myInvoiceDate=new Date();
    
    //Individual costs NOW BIGDECIMAL
    //private static double feePerDay=0;
    //private static double feeDays=0;
    //private static double asPerDay=0;
    //private static double asDays=0;
    //private static double processingFee=0;
    //private static double equipmentHire=0;
    //private static double subsistenceFee=0;
    //private static double parkingFee=0;
    //private static double congestionCharge=0;
    //private static double mileageFee=0;
    //private static double postageFee=0;
    
    //Total costs NOW BIGDECIMAL
    //private static double totalDue=0;
    //private static double amountDue=0;
    //private static double vatDue=0;
    //private static double totalFee=0;
    //private static double assistFee=0;
    //private static double totalExpenses=0;
    
    Calculations () {}
    
    // Run through set of calculations needed on button press
    public static void doCalculations (initArray textarray) {
    
        // Convert invoice number to integer
        Calculations.parseInvoiceNumber (textarray);
        // Convert Rachel invoice filename to correct filename
        Calculations.makeRachelFilename (textarray);
        // Convert Refresh invoice filename to correct filename
        Calculations.makeRefreshFilename (textarray);
        // Formats today's date and places in array for invoice month and date
        Calculations.makeInvoiceDate(textarray, myInvoiceDate);
        // Convert relevant text fields to numbers                
        Calculations.parseNumbersCalculateTotalsSetArray (textarray);
        // Add pound signs to beginning of figures where necessary
        Calculations.addPoundSigns(textarray);
    }
    
    //get methods
    public static int getMyInvoiceNum () {return myInvoiceNum;}
    //public static double getTotalDue () {return totalDue;}
    //public static double getAmountDue () {return amountDue;}
    //public static double getVatDue () {return vatDue;}
    //public static double getTotalFee () {return totalFee;}
    //public static double getAssistFee () {return assistFee;}
    //public static double getTotalExpenses () {return totalExpenses;}
    
    //Converts Invoice number to an integer
    public static void parseInvoiceNumber (initArray textarray) {
        myInvoiceNum=Integer.parseInt(textarray.getInput(0));
    }
    
    //Makes correct Rachel Invoice filename using Invoice number
    public static void makeRachelFilename (initArray textarray) {
        Calculate_button.set_rwpnew("Invoice Number "+(textarray.getInput(0))+".rtf");
    }
    
    //Makes correct Refresh Invoice filename using Refresh Inv number
    public static void makeRefreshFilename (initArray textarray) {
        Calculate_button.set_rfanew("RGW"+(textarray.getInput(1))+".rtf");
    }
    
    //Converts date to correct format and enters into text array 
    //for month [2] & date [3]
    public static void makeInvoiceDate (initArray textarray, Date date) {
        //Sets formatting using SimpleDateFormat Class
        SimpleDateFormat invoiceMonth = new SimpleDateFormat ("MMMM");
        SimpleDateFormat invoiceDate = new SimpleDateFormat ("dd/MM/yyyy");
        //Sets relevant array values using correct formats
        textarray.setInput(2,invoiceMonth.format(date));
        textarray.setInput(3,invoiceDate.format(date));
    }
    
    //Converts all costs from string to Big decimal numbers then calculates totals
    public static void parseNumbersCalculateTotalsSetArray (initArray textarray) {
       
        BigDecimal feePerDay=new BigDecimal(Double.parseDouble(textarray.getInput(11)));
        BigDecimal feeDays=new BigDecimal(textarray.getInput(12));
        BigDecimal asPerDay=new BigDecimal(textarray.getInput(14));
        BigDecimal asDays=new BigDecimal(textarray.getInput(15));
        BigDecimal processingFee=new BigDecimal(textarray.getInput(20));
        BigDecimal equipmentHire=new BigDecimal(textarray.getInput(23));
        BigDecimal subsistenceFee=new BigDecimal(textarray.getInput(26));
        BigDecimal parkingFee=new BigDecimal(textarray.getInput(27));
        BigDecimal congestionCharge=new BigDecimal(textarray.getInput(28));
        BigDecimal mileageFee=new BigDecimal(textarray.getInput(29));
        BigDecimal postageFee=new BigDecimal(textarray.getInput(30));
        
        //Rachel fee calculator
        BigDecimal totalFee=(feePerDay.multiply(feeDays));
        
        //Assistant calculator
        BigDecimal assistFee=(asPerDay.multiply(asDays));
        
        //Expenses calculator
        //Accumulates expenses (REPLACE IF MORE ELEGANT WAY OF ADDING BIGDECIMAL!)
        BigDecimal totalExpenses0=assistFee;
        BigDecimal totalExpenses1=totalExpenses0.add(processingFee);
        BigDecimal totalExpenses2=totalExpenses1.add(equipmentHire);
        BigDecimal totalExpenses3=totalExpenses2.add(subsistenceFee);
        BigDecimal totalExpenses4=totalExpenses3.add(parkingFee);
        BigDecimal totalExpenses5=totalExpenses4.add(congestionCharge);
        BigDecimal totalExpenses6=totalExpenses5.add(mileageFee);
        //Final expense total
        BigDecimal totalExpenses=totalExpenses6.add(postageFee);
        
        //Final totals calculator
        BigDecimal amountDue=totalFee.add(totalExpenses);
        BigDecimal vatRate=new BigDecimal("0.2");
        BigDecimal vatDue=amountDue.multiply(vatRate);
        BigDecimal totalDue=amountDue.add(vatDue);
    
    //Reset initial text array with new totals in correct decimal format 
        DecimalFormat dFormat = new DecimalFormat("####,###,###.##");
        textarray.setInput(5, dFormat.format(amountDue));
        textarray.setInput(6, dFormat.format(vatDue));
        textarray.setInput(7, dFormat.format(totalDue));
        textarray.setInput(10, dFormat.format(totalFee));
        textarray.setInput(13, dFormat.format(assistFee));
        textarray.setInput(16, dFormat.format(totalExpenses));
    }
    
    //Add pound signs to text array where necessary
    public static void addPoundSigns (initArray textarray) {
        textarray.setInput(5, "\u00A3"+textarray.getInput(5));
        textarray.setInput(6, "\u00A3"+textarray.getInput(6));
        textarray.setInput(7, "\u00A3"+textarray.getInput(7));
        textarray.setInput(10, "\u00A3"+textarray.getInput(10));
        textarray.setInput(13, "\u00A3"+textarray.getInput(13));
        textarray.setInput(16, "\u00A3"+textarray.getInput(16));
    }
            
}
