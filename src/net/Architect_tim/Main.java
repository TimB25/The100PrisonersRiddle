package net.Architect_tim;

import java.util.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Main {
    //global variables


    public static void main(String[] args) {
        int prisioners = 100;
        int aantalPogingen = 50;

        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of prisioners:");

        try {
            prisioners = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Enter a number! Rerun the program or the number of prisioners wil be the default of 100!");
        }
        System.out.println("you have chosen that there wil be " + prisioners+" prisioners.");
        try {
            aantalPogingen = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Enter a number! Rerun the program or the number of aantalPogingen wil be the default of 50!");
        }
        System.out.println("you have chosen that there wil be " + aantalPogingen+" pogingen.");
        if (aantalPogingen > prisioners){
            System.out.println("ERROR: Het aantal pogingen is hoger dan het aantal dozen waar uit te kiezen is!");
            System.exit(1);
        }
        System.out.println("The simulaties will be run...");

        theSimulatie(prisioners, aantalPogingen);
    }

        // write your code here
        public static boolean theSimulatie(int prisioners, int aantalPogingen){
            HashMap bord = gameSetup(prisioners);
            int curentPrisoner = 1;
            while (curentPrisoner <=prisioners){
                //run code per prisoner
            }


            return true; //if won true if lost false
        }


        public static HashMap gameSetup ( int prisioners){
            int boxes = 1;
            int indexBoxes = 0;
            ArrayList<Integer> cards = generrateListOfZeroToPrisioners(prisioners);
            Collections.shuffle(cards);
            HashMap<Integer,Integer> bord = new HashMap<>();
            while (boxes <= prisioners) {


                bord.put(boxes,cards.get(indexBoxes));
                indexBoxes++;
                boxes++;
            }
            return bord;



        }

        public static ArrayList generrateListOfZeroToPrisioners ( int prisioners){
            ArrayList<Integer> zeroToPrisioners = new ArrayList<>();
            int i = 1;
            while (!(prisioners == 0)) {
                zeroToPrisioners.add(i);
                i++;
                prisioners--;

            }
            return zeroToPrisioners;
        }

        public  static boolean strategie1 (int currentprisioner, HashMap bord, int pogingen, int prisioners){
            ArrayList listOfClosedBoxes = generrateListOfZeroToPrisioners(prisioners);




        }

        public int generateRandomNumber(int min, int max){
            int int_random = (int)Math.floor(Math.random()*(max-min+1)+min);
            return int_random;
        }





}
