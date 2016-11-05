/*
 * This class contains the main method for calculating and global variables
 * Note these variables must be accessed through get and set though.
 * 
 */
package rwp.invoice.generator.v1;

/**
 *
 * @author joemorris
 */
public class Calculate_button {
    
    //Contains all global variables..
    private static String rwptemplate="Invoice Template RWP.rtf";
    private static String rwpnew="Invoice Template RWP test.rtf";
    private static String rfatemplate="Invoice Template RFA.rtf";
    private static String rfanew="Invoice Template RFA test.rtf";
    private static String exceltemplate="Rachel Whiting Accounts VAT.xls";
    private static String excelnew="Rachel Whiting Accounts VAT test.xls";
    private static int row = 0;
    public static initArray all_text = new initArray();
    
    //Constructor
    Calculate_button () {

    }
    
    //Get and set methods
    public static String get_rwptemplate() { return rwptemplate; }
    public static String get_rwpnew() { return rwpnew; }  
    public static String get_rfatemplate() { return rfatemplate; }  
    public static String get_rfanew() { return rfanew; }  
    public static String get_exceltemplate() { return exceltemplate; }  
    public static String get_excelnew() { return excelnew; }  
    public static int get_row() { return row; }
    public static initArray get_text() { return all_text; }
    
    public static void set_rwptemplate(String set) {rwptemplate=set;}
    public static void set_rwpnew(String set) {rwpnew=set;}    
    public static void set_rfatemplate(String set) {rfatemplate=set;}    
    public static void set_rfanew(String set) {rfanew=set;}
    public static void set_exceltemplate(String set) {exceltemplate=set;}
    public static void set_excelnew(String set) {excelnew=set;}
    public static void set_row(int set) {row=set;}
    public static void set_text(initArray set) {all_text=set;} 
    
    //Other methods
    public static void main_button_run() {
    //contains main run code for the program, triggered when 
    //'calculate' button pressed    
    }
    
}
