package hospitalrecords;


import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 92019494
 */
public class Patient {
    
    public String patientID;
    public String name;
    public String checkInDate;
    public String doctor;
    
    // constructor
    public Patient(String patientID, String name,
            String checkInDate, String doctor) {
            this.patientID = patientID;
            this.name = name;
            this.checkInDate = checkInDate;
            this.doctor = doctor;
    }
    
    @Override
    public String toString(){
        return ("Patient ID: [" + this.patientID + "]\n" 
                + "Name: [" + this.name + "]\n" 
                + "Check In Date [" + this.checkInDate + "]\n" 
                + "Assigned Medical Personnel [" + this.doctor + "]");
    }
    

 
public static void main(String[] args){

    

        
    
        
        String path = "ListOfPatients.txt"; 
        //Use path to the ListOfPatients.txt here
        LineNumberReader lr = null; 
        //allows to read information from the file line by line
        String[] oneRecord = new String[4]; 
        //an array to store info about one patient
        Patient pat;
        ArrayList<Patient> patientList = new ArrayList<>();
        try {     
        
        
        
        //using try-catch for exception handling to catch 
        //possible errors with i/o operations
        FileReader inputStream = new FileReader(path); 
        
         //FileReader reads the file’s contents
        lr = new LineNumberReader(inputStream);
        String str;
        
        while((str = lr.readLine())!= null) {  // start of first while loop
        //while the next line exists
        oneRecord = str.split(",");  
        //dividing one file line by commas and assigning to array
        pat = new Patient(oneRecord[0], oneRecord[1], 
        oneRecord[2], oneRecord[3]); 
        
        
        patientList.add(pat);//adding patient to the ArrayList
 
        } // end of first while loop         
        
        }
        catch(IOException ioe){
            System.out.println("IOExcception occured");
        }
       
       
       
        String searchOrExit = null;
        String inputID = null;
        String deleteRecord = null;
        Scanner input = new Scanner(System.in);
        
        while(!"E".equals(searchOrExit)){ // start of second while loop
        System.out.println("Press S for search, Press E for exit");
        searchOrExit = input.next().toUpperCase();
        if("S".equals(searchOrExit) ){ // start of if statement
            System.out.println("Enter patient ID to search");
            inputID = input.next().toUpperCase();
            if (!patientList.get(1).toString().contains(inputID)){
                System.out.println("There is no existing record.");
            }
            for (int i = 0; i < patientList.size(); i++) { // start of for loop
                
                if (patientList.get(i).toString().contains(inputID)){
                System.out.println(patientList.get(i));
                System.out.println("Would you like to remove the patients record(s)?");
                System.out.println("Y or N?");
                
               
                while(!"Y".equals(deleteRecord) || !"N".equals(deleteRecord)){ // start of third while loop
                    deleteRecord = input.next().toUpperCase();
                    if ("Y".equals(deleteRecord))
                    {
                        patientList.remove(i);
                        System.out.println(patientList);
                        System.out.println("");
                        System.out.println("Record(s) successfully removed");
                        System.out.println("");
                        break;
                    }
                    else if ("N".equals(deleteRecord)) {
                        break;
                    }
                    else {
                        System.out.println("Please enter a Y or N");
                        System.out.println("Would you like to remove the patients record(s)?");
                        System.out.println("Y or N?");
                    }
            
                } // end of third while loop
                }
             
            
                
                
                
                
                
                
                
            } // end of for loop 
            
            
            
            

           
            
            
            
        } //end of if statement
        else if("E".equals(searchOrExit)){
            System.out.println("Bye");
            break;
        }
      
        
        
                } // end of second while loop
        
     }
}
