package javaapplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Employee {

    private String adSoyad;
    private String departman;
    private String pozisyon;
    private String kurumSicilNo;

    public Employee() {

        adSoyad = null;
        departman = null;
        pozisyon = null;
        kurumSicilNo = "9999";

    }

    public Employee(String newAdSoyad, String newKurumSicilNo, String newDepartman, String newPozisyon){

        adSoyad = newAdSoyad;
        kurumSicilNo = newKurumSicilNo;
        departman = newDepartman;
        pozisyon = newPozisyon;

    }


    public String getAdSoyad() {return adSoyad;}
    public void setAdSoyad(String adSoyad) {this.adSoyad = adSoyad;}

    public String getKurumSicilNo() {return kurumSicilNo;}
    public void setKurumSicilNo(String kurumSicilNo) {this.kurumSicilNo = kurumSicilNo;}

    public String getDepartman() {return departman;}
    public void setDepartman(String departman) {this.departman = departman;}

    public String getPozisyon() {return pozisyon;}
    public void setPozisyon(String pozisyon) {this.pozisyon = pozisyon;}


    public String toString() {return "Ad Soyad: " + getAdSoyad() + ", Kurum Sicil No: " + getKurumSicilNo() + ", Departman: " + getDepartman() + ", Pozisyon: " + getPozisyon();}


    public static void main(String[] args ) throws IOException {

        try {

            BufferedReader bReader = new BufferedReader(new FileReader("C:\\Users\\Can\\Desktop\\girdiQuiz1.txt"));
            String lineText;
            while ((lineText = bReader.readLine()) != null) {

                if (lineText.equals("Default")) {

                    Employee worker = new Employee();
                    System.out.println(worker);
                    System.out.println("*****************************************************************************************************");

                } else {

                    String[] line = lineText.split(",");

                    Employee worker = new Employee(line[0], line[1], line[2], line[3]);
                    System.out.println(worker);
                    System.out.println("*****************************************************************************************************");

                }

            }
            bReader.close(); } catch (IOException e) {
            System.out.println("File Read Error !");
        }

    }

}



 