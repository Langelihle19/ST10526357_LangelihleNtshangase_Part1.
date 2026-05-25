/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog5121part1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive test class for ChatQuick Application (Prog5121part1)
 * 
 * @author Student
 */
public class Prog5121part1Test {
    
    public Prog5121part1Test() {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
        System.out.println("========================================");
        System.out.println("Starting ChatQuick Application Tests...");
        System.out.println("========================================");
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
        System.out.println("========================================");
        System.out.println("All tests completed.");
        System.out.println("========================================");
    }

    @BeforeEach
    public void setUp() throws Exception {
        // Silent setup
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Silent teardown
    }

    // ==================== USERNAME VALIDATION TESTS ====================
    // Note: Username must be EXACTLY 5 characters AND contain underscore
    
    @Test
    @DisplayName("Test 1: Valid username with underscore at end (exactly 5 chars)")
    public void testCheckUserName_Valid_UnderscoreAtEnd() {
        String username = "kyl_1";
        boolean result = Prog5121part1.checkUserName(username);
        assertTrue(result, "Username 'kyl_1' (5 chars with underscore) should be valid");
    }
    
    @Test
    @DisplayName("Test 2: Valid username with underscore at start (exactly 5 chars)")
    public void testCheckUserName_Valid_UnderscoreAtStart() {
        String username = "_kyl1";
        boolean result = Prog5121part1.checkUserName(username);
        assertTrue(result, "Username '_kyl1' (5 chars with underscore) should be valid");
    }
    
    @Test
    @DisplayName("Test 3: Valid username with underscore in middle (exactly 5 chars)")
    public void testCheckUserName_Valid_UnderscoreInMiddle() {
        String username = "ky_l1";
        boolean result = Prog5121part1.checkUserName(username);
        assertTrue(result, "Username 'ky_l1' (5 chars with underscore) should be valid");
    }
    
    @Test
    @DisplayName("Test 4: Invalid username - missing underscore")
    public void testCheckUserName_NoUnderscore() {
        String username = "kyl11";
        boolean result = Prog5121part1.checkUserName(username);
        assertFalse(result, "Username without underscore should be invalid");
    }
    
    @Test
    @DisplayName("Test 5: Invalid username - too short (4 chars)")
    public void testCheckUserName_TooShort() {
        String username = "ky_1";
        // ky_1 is 4 characters: k, y, _, 1
        boolean result = Prog5121part1.checkUserName(username);
        assertFalse(result, "Username with 4 characters should be invalid (exactly 5 required)");
    }
    
    @Test
    @DisplayName("Test 6: Invalid username - too short (3 chars)")
    public void testCheckUserName_TooShort2() {
        String username = "a_1";
        boolean result = Prog5121part1.checkUserName(username);
        assertFalse(result, "Username with 3 characters should be invalid (exactly 5 required)");
    }
    
    @Test
    @DisplayName("Test 7: Invalid username - too long (6 chars)")
    public void testCheckUserName_TooLong() {
        String username = "kyle_1";
        // kyle_1 is 6 characters
        boolean result = Prog5121part1.checkUserName(username);
        assertFalse(result, "Username with 6 characters should be invalid (exactly 5 required)");
    }
    
    @Test
    @DisplayName("Test 8: Invalid username - too long (7 chars)")
    public void testCheckUserName_TooLong2() {
        String username = "kyle_12";
        boolean result = Prog5121part1.checkUserName(username);
        assertFalse(result, "Username with 7 characters should be invalid (exactly 5 required)");
    }
    
    @Test
    @DisplayName("Test 9: Invalid username - null value")
    public void testCheckUserName_Null() {
        String username = null;
        boolean result = Prog5121part1.checkUserName(username);
        assertFalse(result, "Null username should be invalid");
    }
    
    @Test
    @DisplayName("Test 10: Invalid username - empty string")
    public void testCheckUserName_Empty() {
        String username = "";
        boolean result = Prog5121part1.checkUserName(username);
        assertFalse(result, "Empty username should be invalid");
    }

    // ==================== PASSWORD COMPLEXITY TESTS ====================
    
    @Test
    @DisplayName("Test 11: Valid complex password")
    public void testCheckPasswordComplexity_Valid() {
        String password = "Ch&&sec@ke99!";
        boolean result = Prog5121part1.checkPasswordComplexity(password);
        assertTrue(result, "Password 'Ch&&sec@ke99!' should be valid");
    }
    
    @Test
    @DisplayName("Test 12: Valid password with exclamation")
    public void testCheckPasswordComplexity_ValidWithExclamation() {
        String password = "Password123!";
        boolean result = Prog5121part1.checkPasswordComplexity(password);
        assertTrue(result, "Password 'Password123!' should be valid");
    }
    
    @Test
    @DisplayName("Test 13: Valid password with @ symbol")
    public void testCheckPasswordComplexity_ValidWithAtSymbol() {
        String password = "Secure@Pass9";
        boolean result = Prog5121part1.checkPasswordComplexity(password);
        assertTrue(result, "Password 'Secure@Pass9' should be valid");
    }
    
    @Test
    @DisplayName("Test 14: Valid password with hash symbol")
    public void testCheckPasswordComplexity_ValidWithHash() {
        String password = "MyPass#2024";
        boolean result = Prog5121part1.checkPasswordComplexity(password);
        assertTrue(result, "Password 'MyPass#2024' should be valid");
    }
    
    @Test
    @DisplayName("Test 15: Invalid password - too short (6 chars)")
    public void testCheckPasswordComplexity_TooShort() {
        String password = "Ch@1";
        boolean result = Prog5121part1.checkPasswordComplexity(password);
        assertFalse(result, "Password with less than 8 characters should be invalid");
    }
    
    @Test
    @DisplayName("Test 16: Invalid password - missing capital letter")
    public void testCheckPasswordComplexity_NoCapital() {
        String password = "ch&&sec@ke99!";
        boolean result = Prog5121part1.checkPasswordComplexity(password);
        assertFalse(result, "Password without capital letter should be invalid");
    }
    
    @Test
    @DisplayName("Test 17: Invalid password - missing number")
    public void testCheckPasswordComplexity_NoNumber() {
        String password = "Ch&&sec@ke!!";
        boolean result = Prog5121part1.checkPasswordComplexity(password);
        assertFalse(result, "Password without number should be invalid");
    }
    
    @Test
    @DisplayName("Test 18: Invalid password - missing special character")
    public void testCheckPasswordComplexity_NoSpecial() {
        String password = "Chandsek99e";
        boolean result = Prog5121part1.checkPasswordComplexity(password);
        assertFalse(result, "Password without special character should be invalid");
    }
    
    @Test
    @DisplayName("Test 19: Invalid password - null value")
    public void testCheckPasswordComplexity_Null() {
        String password = null;
        try {
            boolean result = Prog5121part1.checkPasswordComplexity(password);
            assertFalse(result, "Null password should return false");
        } catch (NullPointerException e) {
            // Acceptable if method throws NPE
            System.out.println("checkPasswordComplexity threw NPE for null input");
        }
    }
    
    @Test
    @DisplayName("Test 20: Invalid password - empty string")
    public void testCheckPasswordComplexity_Empty() {
        String password = "";
        boolean result = Prog5121part1.checkPasswordComplexity(password);
        assertFalse(result, "Empty password should be invalid");
    }
    
    @Test
    @DisplayName("Test 21: Invalid password - no uppercase letters")
    public void testCheckPasswordComplexity_NoUpperCase() {
        String password = "lowercase123!";
        boolean result = Prog5121part1.checkPasswordComplexity(password);
        assertFalse(result, "Password without uppercase should be invalid");
    }
    
    @Test
    @DisplayName("Test 22: Valid password - all uppercase with numbers")
    public void testCheckPasswordComplexity_AllUpperCase() {
        String password = "UPPERCASE123!";
        boolean result = Prog5121part1.checkPasswordComplexity(password);
        assertTrue(result, "All uppercase should be valid if it meets other criteria");
    }

    // ==================== CELL PHONE VALIDATION TESTS ====================
    
    @Test
    @DisplayName("Test 23: Valid SA cell phone number - MTN")
    public void testCheckCellPhoneNumber_Valid_MTN() {
        String number = "+27838968976";
        boolean result = Prog5121part1.checkCellPhoneNumber(number);
        assertTrue(result, "Cell number '+27838968976' should be valid");
    }
    
    @Test
    @DisplayName("Test 24: Valid SA cell phone number - Vodacom")
    public void testCheckCellPhoneNumber_Valid_Vodacom() {
        String number = "+27123456789";
        boolean result = Prog5121part1.checkCellPhoneNumber(number);
        assertTrue(result, "Cell number '+27123456789' should be valid");
    }
    
    @Test
    @DisplayName("Test 25: Valid SA cell phone number - Cell C")
    public void testCheckCellPhoneNumber_Valid_CellC() {
        String number = "+27761234567";
        boolean result = Prog5121part1.checkCellPhoneNumber(number);
        assertTrue(result, "Cell number '+27761234567' should be valid");
    }
    
    @Test
    @DisplayName("Test 26: Invalid - missing +27 prefix")
    public void testCheckCellPhoneNumber_NoCountryCode() {
        String number = "0838968976";
        boolean result = Prog5121part1.checkCellPhoneNumber(number);
        assertFalse(result, "Number without +27 prefix should be invalid");
    }
    
    @Test
    @DisplayName("Test 27: Invalid - too few digits (8 digits after +27)")
    public void testCheckCellPhoneNumber_TooFewDigits() {
        String number = "+27838968";
        boolean result = Prog5121part1.checkCellPhoneNumber(number);
        assertFalse(result, "Number with too few digits should be invalid (needs exactly 9 digits after +27)");
    }
    
    @Test
    @DisplayName("Test 28: Invalid - too many digits (10 digits after +27)")
    public void testCheckCellPhoneNumber_TooManyDigits() {
        String number = "+278389689761";
        boolean result = Prog5121part1.checkCellPhoneNumber(number);
        assertFalse(result, "Number with too many digits should be invalid (needs exactly 9 digits after +27)");
    }
    
    @Test
    @DisplayName("Test 29: Invalid - contains letters")
    public void testCheckCellPhoneNumber_WithLetters() {
        String number = "+27ABCDEFGHI";
        boolean result = Prog5121part1.checkCellPhoneNumber(number);
        assertFalse(result, "Number with letters should be invalid");
    }
    
    @Test
    @DisplayName("Test 30: Invalid - null value")
    public void testCheckCellPhoneNumber_Null() {
        String number = null;
        try {
            boolean result = Prog5121part1.checkCellPhoneNumber(number);
            assertFalse(result, "Null phone number should return false");
        } catch (NullPointerException e) {
            // Acceptable if method throws NPE
            System.out.println("checkCellPhoneNumber threw NPE for null input");
        }
    }
    
    @Test
    @DisplayName("Test 31: Invalid - empty string")
    public void testCheckCellPhoneNumber_Empty() {
        String number = "";
        boolean result = Prog5121part1.checkCellPhoneNumber(number);
        assertFalse(result, "Empty phone number should be invalid");
    }
    
    @Test
    @DisplayName("Test 32: Invalid - wrong country code")
    public void testCheckCellPhoneNumber_WrongCountryCode() {
        String number = "+44123456789";
        boolean result = Prog5121part1.checkCellPhoneNumber(number);
        assertFalse(result, "Only +27 country code should be accepted");
    }

    // ==================== USER REGISTRATION TESTS ====================
    
    @Test
    @DisplayName("Test 33: Register user with valid credentials")
    public void testRegisterUser() {
        String username = "test_";
        String password = "Test@1234";
        String result = Prog5121part1.registerUser(username, password);
        assertEquals(username, result, "Register user should return the username");
    }
    
    @Test
    @DisplayName("Test 34: Register user with different username")
    public void testRegisterUser_DifferentUsername() {
        String username = "user_";
        String password = "User@1234";
        String result = Prog5121part1.registerUser(username, password);
        assertEquals(username, result, "Register user should return the correct username");
    }

    // ==================== LOGIN TESTS ====================
    
    @Test
    @DisplayName("Test 35: Successful login with correct credentials")
    public void testLoginUser_Success() {
        String username = "test_";
        String password = "Test@1234";
        String storedUsername = "test_";
        String storedPassword = "Test@1234";
        boolean result = Prog5121part1.loginUser(username, password, storedUsername, storedPassword);
        assertTrue(result, "Correct credentials should return true");
    }
    
    @Test
    @DisplayName("Test 36: Failed login - wrong username")
    public void testLoginUser_WrongUsername() {
        String username = "wrong_";
        String password = "Test@1234";
        String storedUsername = "test_";
        String storedPassword = "Test@1234";
        boolean result = Prog5121part1.loginUser(username, password, storedUsername, storedPassword);
        assertFalse(result, "Wrong username should return false");
    }
    
    @Test
    @DisplayName("Test 37: Failed login - wrong password")
    public void testLoginUser_WrongPassword() {
        String username = "test_";
        String password = "Wrong@1234";
        String storedUsername = "test_";
        String storedPassword = "Test@1234";
        boolean result = Prog5121part1.loginUser(username, password, storedUsername, storedPassword);
        assertFalse(result, "Wrong password should return false");
    }
    
    @Test
    @DisplayName("Test 38: Failed login - case sensitivity check")
    public void testLoginUser_CaseSensitive() {
        String username = "TEST_";
        String password = "test@1234";
        String storedUsername = "test_";
        String storedPassword = "Test@1234";
        boolean result = Prog5121part1.loginUser(username, password, storedUsername, storedPassword);
        assertFalse(result, "Login should be case sensitive");
    }

    // ==================== LOGIN STATUS TESTS ====================
    
    @Test
    @DisplayName("Test 39: Return login status - successful")
    public void testReturnLoginStatus_Success() {
        boolean status = true;
        String result = Prog5121part1.returnLoginStatus(status);
        assertEquals("Login successful", result, "True status should return 'Login successful'");
    }
    
    @Test
    @DisplayName("Test 40: Return login status - failed")
    public void testReturnLoginStatus_Failure() {
        boolean status = false;
        String result = Prog5121part1.returnLoginStatus(status);
        assertEquals("Login failed", result, "False status should return 'Login failed'");
    }

    // ==================== MESSAGE STORAGE TESTS ====================
    
    @Test
    @DisplayName("Test 41: Save messages to JSON - should not throw exception")
    public void testSaveMessagesToJSON() {
        assertDoesNotThrow(() -> Prog5121part1.saveMessagesToJSON(), 
            "saveMessagesToJSON should not throw an exception");
    }

    @Test
    @DisplayName("Test 42: Show recently sent messages - should not throw exception")
    public void testShowRecentlySentMessages() {
        assertDoesNotThrow(() -> Prog5121part1.showRecentlySentMessages(),
            "showRecentlySentMessages should not throw an exception");
    }

    // ==================== DISABLED TESTS (Require Console Input) ====================
    
    @Test
    @Disabled("Main method requires console interaction - test manually")
    @DisplayName("Test 43: Main method (disabled - requires console input)")
    public void testMain() {
        String[] args = null;
        Prog5121part1.main(args);
    }

    @Test
    @Disabled("sendMessage requires console interaction - test manually")
    @DisplayName("Test 44: Send message (disabled - requires console input)")
    public void testSendMessage() {
        Prog5121part1.sendMessage();
    }
}