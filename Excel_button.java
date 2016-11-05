/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rwp.invoice.generator.v1;

import java.io.IOException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 *
 * @author rachelwhiting
 */
public class Excel_button {
    
    Excel_button(){}
            
        public static void generate_Excel () throws IOException, BiffException, WriteException {
        //get global variables for template and new filenames
        String extemp=Calculate_button.get_exceltemplate();
        String exnew=Calculate_button.get_excelnew();
        initArray text=Calculate_button.get_text();
        int row=Calculate_button.get_row();
        //run replace excel file method
             Excelreplace excel_replace=new Excelreplace(extemp,exnew,text,row);
    }
}
