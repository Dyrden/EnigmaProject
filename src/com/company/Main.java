package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        new Main().run();
    }


    public void run() {
        System.out.println(encryptMessage("TESTER", 5));

        /*
        Scanner sc = new Scanner(System.in);
        String input;


        System.out.println("Input text to encrypt");
        input = sc.nextLine();

        if (input.equalsIgnoreCase("encrypt")) {
            System.out.println("Input text to encrypt");
            input = sc.nextLine();


            // run encrypting

        } else {

            // run decrypting
        }


        System.out.println("Input text to encrypt");
        int shift = sc.nextInt();

        * */

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
