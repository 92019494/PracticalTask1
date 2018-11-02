/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketingsystem;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;


public class TicketingSystem {

    public static Queue<Integer> queue = new LinkedList<>();
    public static int i = 1;
    public static int j = 0 ;
    public static void main(String[] args) {
     
 
        Timer timer = new Timer();
        timer.schedule(new SalesAssisstantTask(), 0, 5000); 
        timer.schedule(new Task(), 0, 3000); 
        
       
    }
    
   
    public static class SalesAssisstantTask extends TimerTask { 
        
        public void run() { // runs every 5 seconds
            
            
            System.out.println("\nSales Assistant is ready to see the next customer.");
        
            
            if (queue.isEmpty()) {
                System.out.println("\nThere are no customers left to see\n");
            } else {
            System.out.println("The customer with ticket number " + j + " will be seen.");
            queue.remove(j);
            System.out.println("The customers with the following tickets are in the queue: "
            + queue + "\n");
            }
         
            j++;
        
        }
    }
   

        public static class Task extends TimerTask {
        
        public void run() { // runs every 3 seconds
            
            queue.add(i);
            System.out.println("customer with ticket " + i + " is added to the queue.");
            i++;
        
            
           
            
        
        }
    }
    
}
