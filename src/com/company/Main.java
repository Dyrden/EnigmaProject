package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        new Main().run();
    }


    public void run() {
        System.out.println(encryptMessage("TESTER TESTER", 5));


        dispalyInput();

    }

    public void dispalyInput() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Type in what you want to do");
        System.out.println("- e | E | Encrypt : Encrypt a message");
        System.out.println("- d | D | Decrypt : Decrypt a message");
        switch (sc.nextLine()) {
            case "E","e","Encrypt" -> System.out.println("Encrypt");
            case "D","d","Decrypt" -> System.out.println("Decrypt");
            default -> dispalyInput();
        }
    }

    public void runEncrypt() {
        System.out.println();
    }


    public String encryptMessage(String str, int shift) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

            char character = str.charAt(i);
            char shiftedCharacter = findLetterByNumber(findNumberByLetter(character) + shift);
            sb.append(shiftedCharacter);
        }
        return sb.toString();
    }

    final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";

    public char findLetterByNumber(int num) {
        return ALPHABET.charAt(num);
    }

    public int findNumberByLetter(char letter) {
        return ALPHABET.indexOf(letter);
    }


}
