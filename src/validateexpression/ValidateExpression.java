/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validateexpression;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author 92019494
 */
public class ValidateExpression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Stack<String> stack = new Stack<>();
        
        Scanner input = new Scanner(System.in);
        String expression;
        char openingChar;
        char closingChar;
        boolean validExpression = true;
        
        // asking user for expression
        System.out.println("Enter your expression");
        expression = input.next();
        
        // asking for opening character
        System.out.println("Enter the opening character to validate");
        openingChar = input.next().charAt(0);
        
        // asking for closing character
        System.out.println("Enter the closing character to validate");
        closingChar = input.next().charAt(0);
        
       
        for(int i = 0; i < expression.length();i++)  { // start of for loop
            if (openingChar == (expression.charAt(i))) {
                stack.push("character occurance");
//                System.out.println(stack);
                       
            
            } else {
                
            }
            
            if (closingChar == expression.charAt(i)) {
            
                try {
                    stack.pop();
                }
                
                catch (EmptyStackException e) {
                    System.out.println("Expression is incorrect. Too many closing characters");
                    validExpression = false;
                    break;
                }
            }
            
            
            
        } // end of for loop
        
        
        if (stack.isEmpty() && validExpression == true){
                System.out.println("Valid expression");
            }
        else if (stack.isEmpty() && validExpression == false) {
                
        }
        
        else {
            System.out.println("Expression is incorrect. Too many opening characters");
        }
    }
    
    
    
}