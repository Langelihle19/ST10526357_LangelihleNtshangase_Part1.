/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Scanner;
import java.util.regex.Pattern;
/**
 *
 * @author Student
 */
 public class LoginSystem{
     static Scanner input = new Scanner(System.in);    

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
//----------------Static Methods----------------
// Check if username contains "_" and max 5 characters
public static boolean checkUserName(String username){
    return username.contains("_") && username.length()<=5;
}
//Check if password has at least 8 characters, capital letter, number, special characters
public static boolean checkPasswordComplexity(String password){
    String regex = "^(?=.[A-Z])(?=.//d)(?=.*[@#%^&+=!]).{8,}$";
    return Pattern.matches(regex,password);
}
//Check if cell phone number is valid(+27 followed by 9 digits)
public static boolean checkCellPhoneNumber(String number){
    String regex ="^\\+27\\d{9}$";
    return Pattern.matches(regex,number);
}
//Register user and validate username and password
public static String registerUser(String username, String password){
    if (!checkUserName(username)){
        return "Username is not correct. Must have _ and 5 max characters.";
    }
    if(!checkPasswordComplexity(password)) {
        return "Password is not correct. Must have 8+ characters, capital letter, number, and special characters.";
    }
    return "Username and password successfully captured. User registered!";
}
//Login user by checking stored username and password
public static boolean loginUser(String username, String password, String storedUsername, String storedPassword){
    return username.equals(storedUsername) && password.equals(storedPassword);
}
//Show login message
public static String returnLoginStatus(boolean status){
    if (status){
        return "Login sucessful! Welcome back!";
    }
    else {
        return "Username or password incorrect, please try again.";
    }
}
//-----------------Main Method----------------
public static void main (String[] args) {
    String storedUsername = "";
    String storedPassword = "";
    String cellPhone = "";
 
//----------------Registration----------------
// Loop until valid username
String username;
while (true){
    System.out.print("Enter Username(must contain'_' and 5 characters):");
    username = input.nextLine();
    if (checkUserName(username)) break;
    System.out.println("Invalid username. Examole: user_");
}
// Loop until valid password
String password;
while (true) {
  System.out.print("Enter Password(8 characters, 1 capital, 1 number, 1 special character):");
  password = input.nextLine();
  if (checkPasswordComplexity(password)) break;
  System.out.println("Invalid password. Example:Password1!");
}
// Register user
String registerMessage = LoginSystem.registerUser(username,password);
System.out.println(registerMessage);
storedUsername = username;
storedPassword = password;

// Loop until valid cell phone 
while (true){
    System.out.print("Enter Cell Phone(+27 followed by 9 digits):");
    cellPhone = input.nextLine();
    if (checkCellPhoneNumber(cellPhone)){
        System.out.println("Cell phone number successfully added."); break;
    }
    System.out.println("Invalid number. Must start with +27 and have 9 digits. Example: +27123456789");
}
//----------------Login Section----------------
System.out.println("\nLogin");
String loginUser;
String loginPass;
boolean status;

while (true){
    System.out.print("Enter Username:");
    loginUser = input.nextLine();
    
    System.out.print("Enter Password:");
    loginPass = input.nextLine();
    
    status =
            LoginSystem.loginUser(loginUser,loginPass,storedUsername,storedPassword);
    
    System.out.println(LoginSystem.returnLoginStatus(status));
    if (status) break; // stop loop on successful login
    }
}
