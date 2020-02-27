package com.company;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randomGen = new Random();
        int target = 0;
        while (hasD(target = (randomGen.nextInt(9000) + 1000))) ;
        String targetSt = target + "";
        boolean youHaveGuessedIt = false;
        int guesses = 0;
        do{
            int bulls = 0;
            int cows = 0;
            System.out.print("Познай четирицифреното число без повтарящи се цифри ");
            int guess = input.nextInt();
                if(hasD(guess) || guess < 1000){
                    System.out.println("Въвел си еднакви числа или са по-малко от четири");
                    continue;
                }

            guesses++;
            String guessSt = guess + "";
            for(int i= 0;i < 4;i++){
                if(guessSt.charAt(i) == targetSt.charAt(i)){
                    bulls++;
                }else if(targetSt.contains(guessSt.charAt(i)+"")){
                    cows++;
                }
            }
            if(bulls == 4){
                youHaveGuessedIt = true;
            }else{
                System.out.println(cows+" Крави и "+bulls+" Бикове.");
            }
        }while(!youHaveGuessedIt);
        System.out.println("Ти спечели след "+guesses+" предположения!!!");
    }





    public static boolean hasD(int number) {
        boolean[] digits = new boolean[10];
        while (number > 0) {
            if (digits[number % 10])
                return true;
            digits[number % 10] = true;
            number /= 10;
        }
        return false;
    }

}

