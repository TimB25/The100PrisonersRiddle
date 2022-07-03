package net.Architect_tim;

import java.security.PublicKey;
import java.util.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Main {
    //global variables


    public static void main(String[] args) {
        start();
    }

        public static void start(){
        int prisioners = 100;
        int aantalPogingen = 50;
        int aantalRuns = 1;
        int sucesFullRuns = 0;
        int lostRuns = 0;
        int algoritmeChoice = 0;


        Scanner sc = new Scanner(System.in);
        //start instellingen
        System.out.println("Hello, type 1 to start the program. Type 2 to get more info. Type 3 to get results that are already calculated. Type 4 to stop the program. ");
        int StartStatus = 2;
        try{
             StartStatus = sc.nextInt();

        } catch (InputMismatchException e){
            System.out.println("ERROR: Enter 1 or 2 or 3.");
            start();
        }

        if (StartStatus == 1) {} //runs the program
        else if (StartStatus == 2){
            MoreInfo();
            start();


        }
        else if(StartStatus == 3){
            AlreadyCalculated();
            start();
        }
        else if (StartStatus == 4){
            System.out.println("Thanks for using this program.");
            System.out.println("The program is stoping");
            System.exit(0);

        }
        else{
            System.out.println("ERROR: You haven't enterd 1 or 2 or 3. Please try again.");
            start();
        }



        //gets the strategie
        System.out.println("Type 1 to use Strategie(random) 1. Type 2 to use Strategie(the proposed solusion) 2. Type 3 to use Strategie 1 and 2: ");
            try{
                algoritmeChoice = sc.nextInt();

            } catch (InputMismatchException e){
                System.out.println("ERROR: Enter 1 or 2 or 3.");
                start();
            }
            if (algoritmeChoice == 3){
                System.out.println("ERROR: Work in progres!");
                start();
            }


        System.out.println("enter number of prisioners:");

        try {
            prisioners = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Enter a number! Rerun the program or the number of prisioners wil be the default of 100!");
        }
        System.out.println("you have chosen that there wil be " + prisioners+" prisioners.");
        System.out.println("enter number of pogingen that every prisener has:");
        try {
            aantalPogingen = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Enter a number! Rerun the program or the number of aantalPogingen wil be the default of 50!");
        }
        System.out.println("you have chosen that there wil be " + aantalPogingen+" pogingen.");
        if (aantalPogingen > prisioners){
            System.out.println("ERROR: Het aantal pogingen is hoger dan het aantal dozen waar uit te kiezen is!");
            System.out.println("please try again.");
            start();
        }
        System.out.println("enter het aantal runs dat wordt uigevoerd:");
        try {
            aantalRuns = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Enter a number! Rerun the program or the number of aantalRuns wil be the default of 1!");
        }
        System.out.println("you have chosen that there wil be " + aantalRuns+" runs of the program.");
        //now I have all the properties of the program

        System.out.println("The simulaties will be run...");
        while (aantalRuns >=1) { //runs the program x times
            Boolean result = theSimulatie(prisioners, aantalPogingen, algoritmeChoice);
            System.out.println(result);
            if (result){
                sucesFullRuns++;
            }
            if (!(result)){
                lostRuns++;
            }
            aantalRuns--;
        }
        System.out.println("sucesfulRuns: "+sucesFullRuns);
        System.out.println("lostRuns: "+lostRuns);
        System.out.println("end of program");
        System.out.println("program restarting...");
        System.out.println("program restarted.");
    }

        // write your code here
        public static boolean theSimulatie(int prisioners, int aantalPogingen, int algoritmeChoice){ //is run 1 time per simulatie

            HashMap bord = gameSetup(prisioners);
            int curentPrisoner = 1;
            boolean wonOrLost= true; //only needed to prevent error.
            while (curentPrisoner <=prisioners){
                if (algoritmeChoice == 1) {
                     wonOrLost = strategie1(curentPrisoner, bord, aantalPogingen, prisioners);
                }
                else if (algoritmeChoice == 2){
                     wonOrLost = strategie1(curentPrisoner, bord, aantalPogingen, prisioners);
                }
                if  (wonOrLost == false){
                    return false;
                }
                curentPrisoner++;
            }


            return true; //if won true
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

            ArrayList<Integer> listOfClosedBoxes = generrateListOfZeroToPrisioners(prisioners);
            while ((pogingen >=1)) {
                int chosenBox = 999999999;
                while (!(listOfClosedBoxes.contains(chosenBox))) {
                    int sizeOfListOfClosedBoxenIndex = listOfClosedBoxes.size();
                    sizeOfListOfClosedBoxenIndex--;
                     chosenBox = (int) listOfClosedBoxes.get(generateRandomNumber(0, sizeOfListOfClosedBoxenIndex));
                }
                listOfClosedBoxes.remove(listOfClosedBoxes.indexOf(chosenBox));
                int value = (int) bord.get(chosenBox);

                if (value == currentprisioner) {
                    return true;
                }else {
                    pogingen--;
                }


            }
            return false;





        }

        public static boolean strategie2(int currentprisioner, HashMap bord, int pogingen, int prisioners){
            int curentBox = currentprisioner;
            while (pogingen >=1){
                pogingen--;
                int value = (int) bord.get(curentBox);
                if (value == currentprisioner){
                    return true;
                } else {
                    curentBox = value;
                }

            }
            return false;
        }

        public static int generateRandomNumber(int min, int max){

            int int_random = (int)Math.floor(Math.random()*(max-min+1)+min);
            return int_random;
        }
        public static void MoreInfo(){
            System.out.println("More Info:");
            System.out.println("This is a program about the riddle of the 100 prisoners. ");
            System.out.println("For the riddle pleas look at the video from Veritasium.");
            System.out.println("https://www.youtube.com/watch?v=iSNsgj1OCLA&t=97s");
            System.out.println("This program simulates the two strategies discussed in the video.");
            System.out.println("Strategie 1 is what happends when every prissioner picks 50 random boxes.");
            System.out.println("Strategie 2 is what happens when every prissioner start whit the box of his number en then picks the box of the number in the box that he has opend.");
            System.out.println("Please note dat if you see that whit strategie 1 zero runs sucesful are that that is coused by the low change of winning and that the program is not broken.");
            System.out.println("You can check that by setting the amoud of prissioners to 100 and the ammound of boxes they get to open set to 99. ");
            System.out.println("When you start the program you get the choice of running Strategie 1 or running strategie 2 or running both. ");
            System.out.println("then you get the coice of the amound of prisioners and the amound of boxes each prisioner gets to open.");
            System.out.println("then you get to pick the amound of runs you want to run. ");



        }
        public static void AlreadyCalculated(){
            System.out.println("NOG TOE TE VOEGEN ");
        }







}
