/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog5121part1;
import static com.mycompany.prog5121part1.Prog5121part1.input;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 *
 * @author Student
 */
public class Prog5121part1 {

    private static boolean exit = false;
    private static int maxMessages = 0;
    private static int totalMessages = 0;
    private static int messageCounter = 0;

    static final JSONArray messageStorage = new JSONArray();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to ChatQuick");

        // Registration
        String storedUsername = registerUserFlow();
        String storedPassword = registerPasswordFlow();
        String cellPhone = registerCellPhoneFlow();

        System.out.println("Username and password successfully captured. User registered!");
        System.out.println("Cell phone number successfully added.");

        // Login
        if (!login(storedUsername, storedPassword)) {
            System.out.println("Too many failed attempts. Exiting.");
            return;
        }

        // Ask how many messages
        try {
            System.out.print("How many messages do you wish to send? ");
            maxMessages = Integer.parseInt(input.nextLine());

            if (maxMessages <= 0) {
                System.out.println("Invalid number. Exiting.");
                return;
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input, exiting programme");
            return;
        }

        // Menu Loop
        while (!exit && totalMessages < maxMessages) {

            System.out.println("\nSelect an Option:");
            System.out.println("1. Send Message");
            System.out.println("2. Coming Soon");
            System.out.println("3. Quit");
            System.out.print("Choice: ");

            int choice;

            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
                continue;
            }

            switch (choice) {

                case 1 -> sendMessage();

                case 2 -> showRecentlySentMessages();

                case 3 -> {
                    saveMessagesToJSON();
                    exit = true;
                }

                default -> System.out.println("Invalid choice");
            }
        }

        if (totalMessages >= maxMessages) {
            System.out.println("Maximum messages reached. Exiting.");
            saveMessagesToJSON();
        }

        input.close();
    }

    // ------------------ Registration Methods ------------------

    private static String registerUserFlow() {

        while (true) {

            System.out.print("Enter Username (must contain '_' and max 5 chars): ");
            String username = input.nextLine();

            if (checkUserName(username)) {
                System.out.println("Username successfully captured.");
                return username;
            } else {
                System.out.println("Username is not correctly formatted; please enure that your username contains an underscore and is no more than five characters in length.");
            }
        }
    }

    private static String registerPasswordFlow() {

        while (true) {

            System.out.print("Enter Password (8+ chars, 1 capital, 1 number, 1 special char): ");
            String password = input.nextLine();

            if (checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                return password;
            } else {
                System.out.println("Password is not correctly formatted; please enure that your password contains at least eight characters, a captial letter, a number, and a special character.");
            }
        }
    }

    private static String registerCellPhoneFlow() {

        while (true) {

            System.out.print("Enter Cell Phone (+27 followed by 9 digits): ");
            String cellPhone = input.nextLine();

            if (checkCellPhoneNumber(cellPhone)) {
                System.out.println("Cell phone number successfully added.");
                return cellPhone;
            } else {
                System.out.println("Cellphone is not correctly formatted or does not contain international code.");
            }
        }
    }

    // ------------------ Login Method ------------------

    private static boolean login(String storedUsername, String storedPassword) {

        int attempts = 3;

        while (attempts > 0) {

            System.out.println("\nLogin");

            System.out.print("Enter Username: ");
            String loginUser = input.nextLine();

            System.out.print("Enter Password: ");
            String loginPass = input.nextLine();

            if (loginUser.equals(storedUsername) &&
                loginPass.equals(storedPassword)) {

                System.out.println("Welcome " + storedUsername + "it is great to see you again");
                return true;

            } else {

                attempts--;

                System.out.println("Username or password incorrect, please try again.");
                System.out.println("Attempts left: " + attempts);
            }
        }

        return false;
    }

    // ------------------ Message Methods ------------------

    static void sendMessage() {

        if (totalMessages >= maxMessages) {
            System.out.println("Maximum messages reached.");
            return;
        }

        long messageId = 1000000000L + new Random().nextInt(900000000);

        messageCounter++;

        System.out.print("Input recipient number (+CCXXXXXXXXXX): ");
        String recipient = input.nextLine();

        recipient = checkRecipient(recipient);

        if (recipient == null) {
            return;
        }

        System.out.print("Enter your message (max 250 characters): ");
        String message = input.nextLine();

        if (message.length() > 250) {
            System.out.println("Message exceeds 250 characters.");
            return;
        }

        String[] words = message.trim().split("\\s+");

        String firstTwoDigits =
                String.valueOf(messageId).substring(0, 2);

        String hash =
                firstTwoDigits + ":" +
                messageCounter + ":" +
                words[0].toUpperCase() +
                (words.length > 1
                        ? words[words.length - 1].toUpperCase()
                        : "");

        System.out.println("\nSelect action:");
        System.out.println("1. Send Message");
        System.out.println("2. Disregard Message");
        System.out.println("3. Store Message");
        System.out.print("Choice: ");

        int action;

        try {
            action = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice");
            return;
        }

        // FIXED ERROR HERE
        if (action == 2) {
            System.out.println("Message Cancelled");
            return;
        }

        JSONObject jsonMessage = new JSONObject();

        jsonMessage.put("MessageID", messageId);
        jsonMessage.put("MessageHash", hash);
        jsonMessage.put("Recipient", recipient);
        jsonMessage.put("Message", message);

        if (action == 3) {

            messageStorage.add(jsonMessage);

            System.out.println("Message stored.");
            return;
        }

        totalMessages++;

        System.out.println("\nMessage Sent!");
        System.out.println("Message ID: " + messageId);
        System.out.println("Message Hash: " + hash);
        System.out.println("Recipient: " + recipient);
        System.out.println("Message: " + message);
    }

    static void saveMessagesToJSON() {

        try (FileWriter file = new FileWriter("storedMessages.json")) {

            file.write(messageStorage.toJSONString());
            file.flush();

            System.out.println("Stored messages saved to storedMessages.json");

        } catch (IOException e) {

            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    private static String checkRecipient(String recipient) {

        if (recipient == null ||
            !recipient.matches("^\\+\\d{9,12}$")) {

            System.out.println("Invalid number. Must include country code and be 9-12 digits.");
            return null;
        }

        return recipient;
    }

    static void showRecentlySentMessages() {

        if (messageStorage.isEmpty()) {

            System.out.println("No stored messages.");

        } else {

            System.out.println("Stored Messages:");

            for (Object obj : messageStorage) {
                System.out.println(obj);
            }
        }
    }

    // ------------------ Validation Methods ------------------

    public static boolean checkUserName(String username) {

        return username != null &&
               username.contains("_") &&
               username.length() <= 5;
    }

    public static boolean checkPasswordComplexity(String password) {

        // FIXED REGEX
        String regex =
                "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";

        return Pattern.matches(regex, password);
    }

    public static boolean checkCellPhoneNumber(String number) {

        String regex = "^\\+27\\d{9}$";

        return Pattern.matches(regex, number);
    }
static String registerUser(String username, String password) {
    // Store the username and password (perhaps in a map or variables)
    // For now, just return the username
    return username;
}

static boolean loginUser(String username, String password, String storedUsername, String storedPassword) {
    return username.equals(storedUsername) && password.equals(storedPassword);
}

static String returnLoginStatus(boolean status) {
    if (status) {
        return "Login successful";
    } else {
        return "Login failed";
    }
}

  }