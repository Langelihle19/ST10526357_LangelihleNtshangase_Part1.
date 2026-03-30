/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog5121part1;
import java.util.Scanner;
import java.util.regex.Pattern; 
/**
 *
 * @author Student
 */
public class Prog5121part1 {
 
    public class LoginSystem{
        static Scanner input= new Scanner(System.in);
    }
public static boolean checkUsername(String username){
    if (username.length()<5 &&username.contains("_")){
        System.out.println("Username successfully captured ");
        }
        else { System.out.println("Username is not correctly formatted; please ensurenthat your username contains an underscore and is no more than five characters in length");
    }
    return true;
}   
 public static boolean checkpasswordComplexity(String password){
     String regex ="^(?=.*[A-Z]) (?=.*\\d) (?=.*[@#$%^&]).{8,}$";
     return Pattern.matches(regex, password);
 }
 public static boolean checkCellPhoneNumber(String number){
     String regex ="^\\+27\\d{9}$";
     return Pattern.matches(regex, number);
   }
 public static String registerUser(String username, String password){
     if (!checkUserName(username)){
         return "Username is not correct.  Must _ and max 5 chars.";
     }
     if (!checkpasswordComplexity(password)){
         return "Password is not correct. Must have 8+ chars, captial letter, number, and special char.";
     }
     return "Username and password successfully captured. User registered!";
 }
 public static boolean loginUser(String username, String password, String storedUsername, String storedPassword){
     return username.equals(storedUsername) && password.equals(storedPassword);
 }
 public static String returnLoginStatus(boolean status){
     if (status){
         return "Login successful! Welcome back!";
     } else{
         return "Username or password incorrect, please try again.";
     }
 }
 
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Enter your username:");
        String username =sc.nextLine();
        if (username.length()<5 &&username.contains("_")){
        System.out.println("Username successfully captured ");
        }
        else { System.out.println("Username is not correctly formatted; please ensurenthat your username contains an underscore and is no more than five characters in length");
        }
        System.out.println("Enter your password:");
        String password =sc.nextLine();
        if(password.length()<8 &&password.matches("A-Z") &&password.matches("0-9") &&password.matches("")
                ){
            System.out.println("Password successfully captured.");
        }
        else{ System.out.println("Password is not correctly formatted; please ensure the password contains at least eight characters, a capital letter, a number, and a special character.");
        }
       
        System.out.println("Enter your cellphone number");
        String cellphoneNumber =sc.nextLine();
        
       System.out.println("Username:"+username + "Password:"+password + "Cellphone Number:"+cellphoneNumber);
    }
}

