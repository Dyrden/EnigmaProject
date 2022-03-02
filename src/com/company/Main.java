package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {


    boolean running = true;

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        test();
    }

    public void test() {
        while (running) displayEnigma();
    }

    public String displayAskInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().toUpperCase();
    }

    public String displayAskInput(String str) {
        System.out.println(str);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().toUpperCase();
    }


    public void displayEnigma() {
        System.out.println("Welcome to Enigma, choose an cipher method");
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
        System.out.println(" 1 | e | E | Encrypt : Encrypt a message");
        System.out.println(" 2 | d | D | Decrypt : Decrypt a message");
        System.out.println(" 3 | b | back : Go back");
        switch (displayAskInput()) {
            case "1", "E", "e", "Encrypt" -> displayCaesarEncrypt();
            case "2", "D", "d", "Decrypt" -> displayCaesarDecrypt();
            case "3", "back", "b" -> displayEnigma();
            default -> displayCaesarChoice();
        }
    }

    public void displayCaesarEncrypt() {
        String inputMessage = displayAskInput("Text in the message you want to encrypt").toUpperCase(Locale.ROOT);
        int inputShift = Integer.parseInt(displayAskInput("input the number to shift with"));
        String encryptedMessage = cipherCaesarMessage(inputMessage, inputShift, false);
        System.out.printf("Your encrypted message is '%s' with shift of '%s'\n", encryptedMessage, inputShift);
        System.out.println("-".repeat(45));
    }

    public void displayCaesarDecrypt() {
        String inputMessage = displayAskInput("Text in the message you want to decrypt in 'CAPITAL LETTERS'");
        int inputShift = Integer.parseInt(displayAskInput("input the shift number"));
        String encryptedMessage = cipherCaesarMessage(inputMessage, inputShift, true);
        System.out.printf("Your decrypted message shifted by '%s' is '%s'\n", inputShift, encryptedMessage);
        System.out.println("-".repeat(45));
    }


    public void displayVigenereChoice() {
        System.out.println("Vigenère cipher:");
        System.out.println("Type in what you want to do");
        System.out.println(" 1 | e | E | Encrypt : Encrypt a message");
        System.out.println(" 2 | d | D | Decrypt : Decrypt a message");
        System.out.println(" 3 | b | back : Go back");
        switch (displayAskInput()) {
            case "1", "E", "e", "Encrypt" -> displayVigenereEncrypt();
            case "2", "D", "d", "Decrypt" -> displayVigenereDecrypt();
            case "3", "back", "b" -> displayEnigma();
            default -> displayCaesarChoice();
        }
    }

    public void displayVigenereEncrypt() {
        String text = displayAskInput("Write your text");
        String password = displayAskInput("Write your password");
        System.out.println(cipherVigenereMessage(text, password, false));
    }

    public void displayVigenereDecrypt() {
        String text = displayAskInput("Write your encrypted text");
        String password = displayAskInput("Write your password");
        System.out.println(cipherVigenereMessage(text, password, true));
    }


    public String cipherCaesarMessage(String str, int shift, boolean ciphered) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(shiftLetter(str.charAt(i), shift, ciphered));
        }
        return sb.toString();
    }

    public String cipherVigenereMessage(String text, String password, boolean cipher) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char charAtIndex = password.charAt(i % password.length());
            int shift = findNumberByLetter(charAtIndex);
            sb.append(shiftLetter(text.charAt(i), shift, cipher));
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
