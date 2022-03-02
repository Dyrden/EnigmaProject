package com.company;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }


    public void run() {


    }
    final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";

    public char findLetterByNumber(int num) {
        return ALPHABET.charAt(num);
    }

    public int findNumberByLetter(char letter) {
        return ALPHABET.indexOf(letter);
    }


}
