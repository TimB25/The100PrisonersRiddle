package net.Architect_tim;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    //global variables


    public static void main(String[] args) {
        int prisioners = 100;


        Scanner sc= new Scanner(System.in);
        System.out.println("enter number of prisioners:");

        try {
            prisioners = sc.nextInt();
        } catch (InputMismatchException e){
            System.out.println("ERROR: Enter a number! Rerun the program or the number of prisioners wil be the default of 100!");
        }
        System.out.println(prisioners);



	// write your code here
    }

    public void gameSetup(int prisioners){

    }

    public ArrayList generrateListOfZeroToPrisioners(int prisioners){
        ArrayList<Integer> zeroToPrisioners = new ArrayList<>();
        int i = 1;
        while (!(prisioners == 0)){
            zeroToPrisioners.add(i);
            i++;
            prisioners--;

        }
        return zeroToPrisioners;
    }
}
