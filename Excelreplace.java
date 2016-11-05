/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rwp.invoice.generator.v1;

import jxl.*;
import java.io.*;
import java.util.Date;
import jxl.read.biff.BiffException;
import jxl.write.*; 
/**
 * 
 * @author rachelwhiting
 */
public class Excelreplace {
    
    private String template_filename;
    private String final_filename;
    
    //Constructor methods
    
    Excelreplace(String old_filename, String new_filename, initArray arrayname, 
            int row) throws IOException, BiffException, WriteException 
    {
        template_filename=old_filename;
        final_filename=new_filename;
        updateExcel(arrayname,row);
    }
    
    // Other methods
    
    void updateExcel(initArray arrayname, int row) 
            throws IOException, BiffException, WriteException {
         Workbook workbook = Workbook.getWorkbook(new File(template_filename));        

                     // Calculate first empty row
                int rowCounter=0;
                boolean empty=false;         
                     
            Sheet sheet = workbook.getSheet(0); 
            
            //uses invoice number to work out correct row. 
            // Could work out automatically if we can manage it!.
            row=Calculations.getMyInvoiceNum();

                //test current row is empty, if not continue incrementing until it is.
                 //while (empty=false) {
                    //Cell testCell = sheet.getCell(0,rowCounter);
                    //Cell testCell2 = sheet.getCell(5,5);
                    //String test2Contents = testCell2.getContents();
                    //System.out.print(test2Contents);
                    //String testContents = testCell.getContents();
                    //System.out.print(testContents);
                    //row=rowCounter;
                    //System.out.print(row);
                    //if (testContents==null) {empty=true;}
                    //rowCounter+=1;
                //}


         WritableWorkbook copy = Workbook.createWorkbook
                                        (new File(final_filename), workbook);  
            WritableSheet sheet1 = copy.getSheet(0);
            

            

            String invoicenum=arrayname.getInput(0);
            String refreshref=arrayname.getInput(1);
            String invoicemonth=arrayname.getInput(2);
            String invoicedate=arrayname.getInput(3);
            String jobname=arrayname.getInput(4);
            String amountdue=arrayname.getInput(5);
            String vatdue=arrayname.getInput(6);
            String totaldue=arrayname.getInput(7);
            
            Label invoicenumx = new Label(0, row, invoicenum);
            sheet1.addCell(invoicenumx); 
            
            Label refreshrefx = new Label(1, row, refreshref);
            sheet1.addCell(refreshrefx); 
            
            Label invoicemonthx = new Label(2, row, invoicemonth);
            sheet1.addCell(invoicemonthx);
            
            Label invoicedatex = new Label(3, row, invoicedate);
            sheet1.addCell(invoicedatex);
            
            Label jobnamex = new Label(4, row, jobname);
            sheet1.addCell(jobnamex);
            
            Label amountduex = new Label(5, row, amountdue);
            sheet1.addCell(amountduex);

            Label vatduex = new Label(6, row, vatdue);
            sheet1.addCell(vatduex);
            
            Label totalduex = new Label(7, row, totaldue);
            sheet1.addCell(totalduex);
               
               // All cells modified/added. Now write out the workbook
            copy.write();
            copy.close(); 
    }
    
}
