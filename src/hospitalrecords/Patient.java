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
    
    // declaring variables
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
    
    // setter and getters for variables
    public String getPatientID() {
        return patientID;
    }
    
    public void setPatientID(String ID){
        this.patientID = ID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getCheckInDate() {
        return checkInDate;
    }
    
    public void setCheckInDate(String checkIn){
        this.checkInDate = checkIn;
    }
    
    public String getDoctor() {
        return doctor;
    }
    
    public void setDoctor(String doctor){
        this.doctor = doctor;
    }
    
    
    @Override
    public String toString(){
        return ("Patient ID: [" + this.getPatientID() + "]\n" 
                + "Name: [" + this.getName() + "]\n" 
                + "Check In Date [" + this.getCheckInDate() + "]\n" 
                + "Assigned Medical Personnel [" + this.getDoctor() + "]");
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
        
        oneRecord = str.split(","); //while the next line exists
 
        pat = new Patient(oneRecord[0], oneRecord[1], 
        oneRecord[2], oneRecord[3]); //dividing one file line by commas and assigning to array
        
        patientList.add(pat);//adding patient to the ArrayList
 
        } // end of first while loop         
        
        }
        catch(IOException ioe){
            System.out.println("IOExcception occured");
        }
       
        // initializing the variables needed
        String searchOrExit = null;
        String inputID = null;
        String deleteRecord = null;
        boolean recordFound = false;
        Scanner input = new Scanner(System.in);
        
        while(!"E".equals(searchOrExit)){ // start of second while loop
            System.out.println("Press S for search, Press E for exit");
            searchOrExit = input.next().toUpperCase();
        
        if("S".equals(searchOrExit) ){ // start of if statement
            System.out.println("Enter patient ID to search");
            inputID = input.next().toUpperCase();

            for (int i = 0; i < patientList.size(); i++) { // start of for loop
                
                if (patientList.get(i).getPatientID().equals(inputID)){
                    System.out.println(patientList.get(i));
                    System.out.println("Would you like to remove the patients record(s)?");
                    System.out.println("Y or N?");
                    recordFound = true;
               
                while(!"Y".equals(deleteRecord) || !"N".equals(deleteRecord)){ // start of third while loop
                    deleteRecord = input.next().toUpperCase();
                    if ("Y".equals(deleteRecord)){
                        patientList.remove(i);
                        System.out.println("\nRecord(s) successfully removed\n");
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
                
                else{
                    recordFound = false;
                }
              
            } // end of for loop 

            
            if (recordFound == false){
                System.out.println("There is no existing record.\n");
            }
            
        } //end of if statement
        else if("E".equals(searchOrExit)){
            System.out.println("Bye");
            break;
        }
        } // end of second while loop
}
}
