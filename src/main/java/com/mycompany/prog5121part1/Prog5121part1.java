/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog5121part1;
import static com.mycompany.prog5121part1.Prog5121part1.LoginSystem.input;
import java.util.Scanner;
import java.util.regex.Pattern; 
/**
 *
 * @author Student
 */
public class Prog5121part1 {

    private static boolean checkPasswordComplexity(String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static boolean checkUserName(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
    public class LoginSystem{
        static Scanner input= new Scanner(System.in);

        private static String registerUser(String username, String password) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static boolean loginUser(String loginUser, String loginPass, String storedUsername, String storedPassword) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static boolean returnLoginStatus(boolean status) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
//------------------ Static Methods ------------------
    
 // Check if username contains "_" and max 5 characters
public static boolean checkUsername(String username){
    if (username.length()<5 &&username.contains("_")){
        System.out.println("Username successfully captured ");
        }
        else { System.out.println("Username is not correctly formatted; please ensurenthat your username contains an underscore and is no more than five characters in length");
    }
    return true;
}   
// Check if password has at least 8 characters, captial letter, number, special characters
 public static boolean checkpasswordComplexity(String password){
     String regex ="^(?=.*[A-Z]) (?=.*\\d) (?=.*[@#$%^&]).{8,}$";
     return Pattern.matches(regex, password);
 }
 // Check if cellphone number is valid (+27 followed by 9 digits)
 public static boolean checkCellPhoneNumber(String number){
     String regex ="^\\+27\\d{9}$";
     return Pattern.matches(regex, number);
   }
 // Register user and validate username and password
 public static String registerUser(String username, String password){
     if (!checkUserName(username)){
         return "Username is not correct.  Must _ and max 5 chars.";
     }
     if (!checkpasswordComplexity(password)){
         return "Password is not correct. Must have 8+ chars, captial letter, number, and special char.";
     }
     return "Username and password successfully captured. User registered!";
 }
 // Login user by checking stored username and password
 public static boolean loginUser(String username, String password, String storedUsername, String storedPassword){
     return username.equals(storedUsername) && password.equals(storedPassword);
 }
 // Show login message 
 public static String returnLoginStatus(boolean status){
     if (status){
         return "Login successful! Welcome back!";
     } else{
         return "Username or password incorrect, please try again.";
     }
 }
 // ------------------ Main Method -------------------
 
    public static void main(String[] args) {
         String storedUsername ="";
         String storedPassword ="";
         String cellPhone;
         
// ------------------ Registration ------------------  
// Loop until valid username
     String username;
     while (true){
         System.out.print("Enter Username (must contain '_' and max 5 chars:");
         username = input.nextLine();
         if (checkUsername(username)) break;
         System.out.println("Invalid username. Example: user _");
     }
         
// Loop until valid password
     String password;
     while (true) {
     System.out.print("Enter Passwor (8+ chars, 1 captial, 1 number, 1 special char):");
     password = input.nextLine();
     if (checkPasswordComplexity(password)) break;
     System.out.println("Invalid password. Example: Password1!");
     }
      
// Register user
    String registerMessage = LoginSystem.registerUser(username, password);
    System.out.println(registerMessage);
    storedUsername = username;
    storedPassword = password;
    
// Loop until valid cellphone
    while (true) {
        System.out.print("Enter Cellphone (+27 followed by 9 digits);");
        cellPhone = input.nextLine();
        if (checkCellPhoneNumber(cellPhone)){
        System.out.println("Cell phone number successfully added.");
        break;
        }
        System.out.println("Invalid number. Must start with +27 and have 9 digits. Example: +27123456789");
    }
// ----------------- Login Section ----------------
    System.out.println("/nLogin");
             
    String loginUser;
    String loginPass;
    boolean status;
    
    while (true) {
   System.out.print("Enter Username:");
   loginUser = input.nextLine();
   
   System.out.print("Enter Password:");
   loginPass = input.nextLine();
   
   status = LoginSystem.loginUser(loginUser, loginPass, storedUsername, storedPassword);
   
   System.out.println(LoginSystem.returnLoginStatus(status));
   
   if (status) break; // stop loop on successful login
    }
} 
}

