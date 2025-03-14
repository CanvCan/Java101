package javaapplication;

import java.util.Random;
import java.util.Scanner;

public class FruitSlotGame {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        char answer;
        int sumLoss = 0;
        int sumEarning = 0;
        int netIncome;

        do {

            System.out.println("L�tfen yat�rmak istedi�iniz para miktar�n� giriniz: ");
            double money = input.nextDouble();

            int earning = 0;
            int counterCilek = 0;
            int counterPortakal = 0;
            int counterElma = 0;
            int counterMuz = 0;
            int counterKiraz = 0;
            int counterKavun = 0;


            Random random = new Random();
            System.out.print("Se�ilen meyveler: ");


            for(int i = 0; i < 3 ; i++) {

                int number = random.nextInt(6);

                if (number == 0) {counterCilek += 1; System.out.print("�ilek ");}
                if (number == 1) {counterPortakal += 1; System.out.print("Portakal ");}
                if (number == 2) {counterElma += 1; System.out.print("Elma ");}
                if (number == 3) {counterMuz += 1;System.out.print("Muz ");}
                if (number == 4) {counterKiraz += 1;System.out.print("Kiraz ");}
                if (number == 5) {counterKavun += 1;System.out.print("Kavun ");}

            }

            if (counterCilek == 3 || counterPortakal == 3 || counterElma == 3 || counterMuz == 3 || counterKiraz == 3 || counterKavun == 3)
            {earning = (int) (money * 3);}
            if (counterCilek == 2 || counterPortakal == 2 || counterElma == 2 || counterMuz == 2 || counterKiraz == 2 || counterKavun == 2)
            {earning = (int) (money * 2);}



            System.out.println();
            System.out.println("Kazand���n�z para miktar�: " + earning);



            System.out.println("Tekrar oynamak ister misiniz? ");
            answer = input.next().charAt(0);

            sumLoss += money;
            sumEarning += earning;
            netIncome = sumEarning - sumLoss;

        } while (answer == 'y' || answer == 'Y'); {

            System.out.println("Harcad���n�z toplam para miktar�: " + sumLoss);
            System.out.println("Kazand���n�z toplam para miktar�: " + sumEarning);
            System.out.println("Net kazanc�n�z: " + netIncome);
            input.close();


        }

    }

}

