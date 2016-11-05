/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rwp.invoice.generator.v1;

/**
 * all array setting and getting.
 * Could be better to use an advanced data structure capable of multiple types.
 * (One for a future release?)
 * First dimension is the 30 fields, 
 * second dimension - [0]=Placeholders [1]=New settings from app [2]=Index (for ref)
 * @author rachelwhiting
 */
public class initArray {
    
    static String[][] placeholders = new String[31][3];
    
    //Constructors
    public initArray() {
        //placeholders to be replaced in RTF files
        placeholders[0][0] = "INVOICENUM"; placeholders[1][0] = "REFRESHREF";
        placeholders[2][0] = "INVOICEMONTH"; placeholders[3][0] = "INVOICEDATE";
        placeholders[4][0] = "JOBNAME"; placeholders[5][0] = "AMOUNTDUE";
        placeholders[6][0] = "VATDUE"; placeholders[7][0] = "TOTALDUE";
        placeholders[8][0] = "AGENTFEES"; placeholders[9][0] = "JOBDATE";
        placeholders[10][0] = "TOTALFEE"; placeholders[11][0] = "FEEPERDAY";
        placeholders[12][0] = "FEEDAYS"; placeholders[13][0] = "ASFEE";
        placeholders[14][0] = "ASPERDAY"; placeholders[15][0] = "ASDAY";
        placeholders[16][0] = "EXPENSES"; placeholders[17][0] = "STYLIST";
        placeholders[18][0] = "CLIENT"; placeholders[19][0] = "CONTACT";
        placeholders[20][0] = "PROCFEE"; placeholders[21][0] = "POLAROIDS";
        placeholders[22][0] = "PRINTS"; placeholders[23][0] = "EQUIPHIRE";
        placeholders[24][0] = "STUDIO"; placeholders[25][0] = "BIKES";
        placeholders[26][0] = "SUBSISTENCE"; placeholders[27][0] = "PARKING";
        placeholders[28][0] = "CONGESTION"; placeholders[29][0] = "MILEAGE";
        placeholders[30][0] = "POSTAGE"; 
        //Set starting points
        placeholders[0][1] = ""; placeholders[1][1] = "";
        placeholders[2][1] = ""; placeholders[3][1] = "";
        placeholders[4][1] = ""; placeholders[5][1] = "";
        placeholders[6][1] = ""; placeholders[7][1] = "";
        placeholders[8][1] = ""; placeholders[9][1] = "";
        placeholders[10][1] = ""; placeholders[11][1] = "";
        placeholders[12][1] = ""; placeholders[13][1] = "";
        placeholders[14][1] = ""; placeholders[15][1] = "";
        placeholders[16][1] = ""; placeholders[17][1] = "";
        placeholders[18][1] = ""; placeholders[19][1] = "";
        placeholders[20][1] = ""; placeholders[21][1] = "";
        placeholders[22][1] = ""; placeholders[23][1] = "";
        placeholders[24][1] = ""; placeholders[25][1] = "";
        placeholders[26][1] = ""; placeholders[27][1] = "";
        placeholders[28][1] = ""; placeholders[29][1] = "";
        placeholders[30][1] = ""; 
        //index for reference
        placeholders[0][2] = "RWP invoice number"; 
        placeholders[1][2] = "Refresh invoice number";
        placeholders[2][2] = "Month invoice raised"; 
        placeholders[3][2] = "Date invoice raised";
        placeholders[4][2] = "Job name"; 
        placeholders[5][2] = "Amount due";
        placeholders[6][2] = "VAT due"; 
        placeholders[7][2] = "Total due";
        placeholders[8][2] = "Agent fees"; 
        placeholders[9][2] = "Job date";
        placeholders[10][2] = "Fee"; 
        placeholders[11][2] = "Fee per day";
        placeholders[12][2] = "Number of days"; 
        placeholders[13][2] = "Assistant fee";
        placeholders[14][2] = "Assistant fee per day"; 
        placeholders[15][2] = "Assistant number of days";
        placeholders[16][2] = "Expenses"; 
        placeholders[17][2] = "Stylist";
        placeholders[18][2] = "Client"; 
        placeholders[19][2] = "Contact";
        placeholders[20][2] = "Processing fee"; 
        placeholders[21][2] = "Polaroids";
        placeholders[22][2] = "Prints"; 
        placeholders[23][2] = "Equipment hire";
        placeholders[24][2] = "Studio"; 
        placeholders[25][2] = "Bikes";
        placeholders[26][2] = "Subsistence"; 
        placeholders[27][2] = "Parking";
        placeholders[28][2] = "Congestion"; 
        placeholders[29][2] = "Mileage";
        placeholders[30][2] = "Postage"; 
        
    }
    
    //Get and Set Methods
    
    public String getPlaceholder(int i) {
        return placeholders[i][0];
    }   
    
    public String getIndex(int i) {
        return placeholders[i][2];
    }
    
    public String getInput (int i) {
        return placeholders[i][1];
    }
    
    public int getLength () {
        return placeholders.length;
    }
    
    public void setInput (int i, String input) {
        placeholders[i][1] = input;
    }
    
}
