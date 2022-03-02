package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        test();
    }

    public void test() {
        displayChoice();
    }

    public String displayAskInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public String displayAskInput(String str) {
        System.out.println(str);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void displayChoice() {
        System.out.println("Type in what you want to do");
        System.out.println("- e | E | Encrypt : Encrypt a message");
        System.out.println("- d | D | Decrypt : Decrypt a message");
        switch (displayAskInput()) {
            case "E","e","Encrypt" -> displayEncrypt();
            case "D","d","Decrypt" -> System.out.println("Decrypt");
            default -> displayChoice();
        }
    }




    public void displayEncrypt() {
        String inputMessage = displayAskInput("Text in the message you want to encrypt in 'CAPITAL LETTERS'");
        int inputShift = Integer.parseInt(displayAskInput("input the number to shift with"));
        String encryptedMessage = encryptMessage(inputMessage,inputShift);
        System.out.printf("\nYour encrypted message is '%s' with shift of '%s'", encryptedMessage,inputShift);
    }


    public String encryptMessage(String str, int shift) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(encryptLetter(str.charAt(i), shift));
        }
        return sb.toString();
    }

    public char encryptLetter(char letter, int shift) {
        int shiftedCharacterNumber = findNumberByLetter(letter) + shift;
        return findLetterByNumber(shiftedCharacterNumber);
    }

    final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";

    public char findLetterByNumber(int num) {
        return ALPHABET.charAt(num);
    }

    public int findNumberByLetter(char letter) {
        return ALPHABET.indexOf(letter);
    }


}
