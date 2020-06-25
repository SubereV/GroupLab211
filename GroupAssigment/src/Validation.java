/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Validation {
    public static Scanner input = new Scanner(System.in);
    
    public static int checkInputRange(int a, int b){
                while(true){
            try {
                int result = Integer.parseInt( input.nextLine() );
                if(result>=a && result<=b)return result;
                System.err.println("Must be between "+a+" and "+b);
                System.out.print("Enter again: ");
            } catch(NumberFormatException e){
                System.err.println("Please input integer");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static String checkInputString(){
        while(true){
            String result = input.nextLine();
            if(!result.isEmpty()) return result;
            System.err.println("String can't be empty");
            System.out.print("Enter again: ");
        }
    }
    
    public static int checkInputInt(){
        while(true){
            try {
                int result = Integer.parseInt( input.nextLine() );
                return result;
            } catch(NumberFormatException e){
                System.err.println("Please input integer");
                System.out.print("Enter again: ");
            }
        }
    }
 
    public static int checkInputPositiveInt(){
        while(true){
            try {
                int result = Integer.parseInt( input.nextLine() );
                if(result>0) return result;
                System.err.println("Must be positive integer");
                System.out.print("Enter again: ");
            } catch(NumberFormatException e){
                System.err.println("Please input integer");
                System.out.print("Enter again: ");
            }
        }
    }

    public static double checkInputDouble(){
        while(true){
            try {
                double result = Double.parseDouble( input.nextLine() );
                return result;
            } catch(NumberFormatException e){
                System.err.println("Please input a double");
                System.out.print("Enter again: ");
            }
        }
    }    
    
    public static double checkInputPositiveDouble(){
        while(true){
            try {
                double result = Double.parseDouble( input.nextLine() );
                if(result>0) return result;
                System.err.println("Can't be a negative number");
                System.out.print("Enter again: ");
            } catch(NumberFormatException e){
                System.err.println("Please input a double");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static boolean checkInputTF(){
        while(true){
            String result = checkInputString();
            if(result.equalsIgnoreCase("T")) return true;
            if(result.equalsIgnoreCase("F")) return false;
            System.err.println("Please enter t/T or f/F");
            System.out.print("Enter again: ");
        }
    }
    
    public static boolean checkInputUD() {
        while (true) {
            String result = input.nextLine();
            if (result.equalsIgnoreCase("U")) return true;
            if (result.equalsIgnoreCase("D")) return false;
            System.err.println("Please input u/D or d/D.");
            System.out.print("Enter again: ");
        }
    }
    
    public static String checkInputID(){
        while(true){
            String result = checkInputString();
            if(result.matches("^S\\d{3}")) return result;
            System.err.println("Student ID: S + 3 digits");
            System.out.print("Enter again: ");
        }
    }
    
    public static String checkInputCourseName(){
        while(true){
            String result = input.nextLine();
            if((result.equals("C/C++")) || (result.equals(".Net")) || (result.equals("Java"))  ) return result;
            System.err.println("Please input one: C/C++, Java, .Net");
            System.out.print("Enter again: ");
        }
    }
    
}
