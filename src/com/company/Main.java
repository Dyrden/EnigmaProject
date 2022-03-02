package com.company;

import java.util.Scanner;

public class Main {

    Scanner sc = new Scanner(System.in);
    boolean running = true;

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        enigma();
    }

    public void enigma() {
        System.out.println("Welcome to Enigma, choose an cipher method");
        while (running) displayEnigma();
    }

    public String displayAskInput() {
        return sc.nextLine().toUpperCase();
    }

    public String displayAskInput(String str) {
        System.out.println(str);
        return sc.nextLine().toUpperCase();
    }


    public void displayEnigma() {
        System.out.println("Choose one of the following");
        System.out.println(" 1 - Caesar");
        System.out.println(" 2 - Vignere");
        System.out.println(" 3 - Exit");
        switch (displayAskInput()) {
            case "1" -> displayCaesarChoice();
            case "2" -> displayVigenereChoice();
            case "3" -> running = false;
            default -> displayEnigma();
        }
    }


    public void displayCaesarChoice() {
        System.out.println("Caesar cipher:");
        System.out.println("Type in what you want to do");
        System.out.println(" 1 : Encrypt a message");
        System.out.println(" 2 : Decrypt a message");
        System.out.println(" 3 : Go back");
        switch (displayAskInput()) {
            case "1" -> displayCaesarEncrypt();
            case "2" -> displayCaesarDecrypt();
            case "3" -> displayEnigma();
            default -> displayCaesarChoice();
        }
    }

    public void displayCaesarEncrypt() {
        String inputMessage = displayAskInput("Text in the message you want to encrypt").toUpperCase();
        int inputShift = Integer.parseInt(displayAskInput("input the number to shift with"));
        String encryptedMessage = cipherMessageCaesar(inputMessage, inputShift, false);
        System.out.printf("Your encrypted message is '%s' with shift of '%s'\n", encryptedMessage, inputShift);
        System.out.println("-".repeat(45));
    }

    public void displayCaesarDecrypt() {
        String inputMessage = displayAskInput("Text in the message you want to decrypt in 'CAPITAL LETTERS'");
        int inputShift = Integer.parseInt(displayAskInput("input the shift number"));
        String encryptedMessage = cipherMessageCaesar(inputMessage, inputShift, true);
        System.out.printf("Your decrypted message shifted by '%s' is '%s'\n", inputShift, encryptedMessage);
        System.out.println("-".repeat(45));
    }


    public void displayVigenereChoice() {
        System.out.println("Vigenère cipher:");
        System.out.println("Type in what you want to do");
        System.out.println(" 1: Encrypt a message");
        System.out.println(" 2: Decrypt a message");
        System.out.println(" 3: Go back");
        switch (displayAskInput()) {
            case "1" -> displayVigenereEncrypt();
            case "2" -> displayVigenereDecrypt();
            case "3" -> displayEnigma();
            default -> displayCaesarChoice();
        }
    }

    public void displayVigenereEncrypt() {
        String text = displayAskInput("Write your text");
        String password = displayAskInput("Write your password");
        System.out.println(cipherMessageVigenere(text, password, false));
    }

    public void displayVigenereDecrypt() {
        String text = displayAskInput("Write your encrypted text");
        String password = displayAskInput("Write your password");
        System.out.println(cipherMessageVigenere(text, password, true));
    }


    public String cipherMessageCaesar(String str, int shift, boolean ciphered) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(shiftLetter(str.charAt(i), shift, ciphered));
        }
        return sb.toString();
    }

    public String cipherMessageVigenere(String text, String password, boolean ciphered) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char passwordCharAtIndex = password.charAt(i % password.length());
            int shift = findNumberByLetter(passwordCharAtIndex);
            sb.append(shiftLetter(text.charAt(i), shift, ciphered));
        }
        return sb.toString();
    }

    public char shiftLetter(char letter, int shift, boolean ciphered) {
        if (ciphered) {
            return findLetterByNumber((findNumberByLetter(letter) - shift) % ALPHABET.length());
        } else
            return findLetterByNumber((findNumberByLetter(letter) + shift) % ALPHABET.length());
    }


    final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";

    public char findLetterByNumber(int num) {
        return ALPHABET.charAt(num);
    }

    public int findNumberByLetter(char letter) {
        return ALPHABET.indexOf(letter);
    }


}
