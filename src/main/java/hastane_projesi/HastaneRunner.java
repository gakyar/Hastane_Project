package hastane_projesi;

import java.util.Scanner;

public class HastaneRunner {
    private static Hastane hastane1 = new Hastane();


    public static void main(String[] args) {



        String hastaDurumu;
        String unvan;


        Scanner scan = new Scanner(System.in);

        do {

            System.out.println("Lütfen hastanın durumunu giriniz, ÇIKIŞ için q giriniz:  :  ");
            hastaDurumu = scan.nextLine();
            unvan = doktorUnvan(hastaDurumu);

            if (hastaDurumu.equalsIgnoreCase("q")) {
                System.out.println("iyi günler,tekrar bekleriz...");

            } else if (unvan.equalsIgnoreCase("Yanlis unvan")) {
                System.out.println("Hatalı hasta durumu girdiniz. Tekrar deneyiniz.");

            } else {

                hastane1.setDoktor(doktorBul(unvan));
                hastane1.setHasta(hastaBul(hastaDurumu));


                System.out.println("-".repeat(46)+"\n");
                System.out.println("===========> HASTANEMİZE HOŞGELDİNİZ <========"+"\n");
                System.out.println("-".repeat(46));
                System.out.println("==============> Hasta Bilgileri <=============");
                System.out.println("-".repeat(46));
                System.out.println("Hasta ismi : " + hastane1.getHasta().getIsim());
                System.out.println("Hasta Soyismi : " + hastane1.getHasta().getSoyIsim());
                System.out.println("Hasta durumu : " + hastane1.getHasta().getHastaDurumu().getAktuelDurum());

                if ( hastane1.getHasta().getHastaDurumu().isAciliyet()== true) {
                    System.out.println("Hasta aciliyeti : Durumu acildir.");
                } else {
                    System.out.println("Hasta aciliyeti : Durumu acil değildir.");
                }
                System.out.println("Hasta ID Numarası : " + hastane1.getHasta().getHastaID());
                System.out.println("-".repeat(46));
                System.out.println("==============> Doktor Bilgileri <============");
                System.out.println("-".repeat(46));
                System.out.println("Doktor ismi : " + hastane1.getDoktor().getIsim());
                System.out.println("Doktor Soyismi : " + hastane1.getDoktor().getSoyIsim());
                System.out.println("Doktor Branşı : " + hastane1.getDoktor().getUnvan());
                System.out.println("-".repeat(46));
            }

        } while (!hastaDurumu.equalsIgnoreCase("q"));


    }


    //pdf sayfa 14  1.metod
    public static String doktorUnvan(String aktuelDurum) {

        String unvan = "";

        for (int i = 0; i < hastane1.durumlar.length; i++) {
            if (hastane1.durumlar[i].equalsIgnoreCase(aktuelDurum)) {
                unvan = hastane1.unvanlar[i];
                break;
            } else {
                unvan = "Yanlis unvan";
            }
        }

        return unvan;
    }


       /*  //pdf sayfa 14  1.metod  bu şekilde de olabilir


    public static String doktorUnvan(String aktuelDurum) {


       if (aktuelDurum.equalsIgnoreCase("Allerji")) {
            return "Allergist";

        } else if (aktuelDurum.equalsIgnoreCase("Bas agrisi")) {
            return "Norolog";


        } else if (aktuelDurum.equalsIgnoreCase("Diabet")) {
            return "Genel cerrah";

        } else if (aktuelDurum.equalsIgnoreCase("Soguk alginligi")) {
            return "Cocuk Doktoru";

        } else if (aktuelDurum.equalsIgnoreCase("Migren")) {
            return "Dahiliye";

        } else if (aktuelDurum.equalsIgnoreCase("Kalp hastaliklari")) {
            return "Kardiolog";

        } else {
            return "Yanlis unvan";
        }
        }
*/



    //pdf sayfa 16  2.metod
    public static Doktor doktorBul(String unvan) {

        Doktor doktor = new Doktor();

        for (int i = 0; i < hastane1.unvanlar.length; i++) {

            if (unvan.equalsIgnoreCase(hastane1.unvanlar[i])) {


                doktor.setIsim(hastane1.doctorIsimleri[i]);
                doktor.setSoyIsim(hastane1.doctorSoyIsimleri[i]);
                doktor.setUnvan(hastane1.unvanlar[i]); //yada doktor.setUnvan(unvan)
            }
        }

        return doktor;

    }


    //pdf sayfa 17  3.metod
    public static Durum hastaDurumuBul(String aktuelDurum) {
        Durum hastaDurumu = new Durum();


        switch ((aktuelDurum.toLowerCase())) {

            case "allerji", "soguk alginligi", "bas agrisi", "diabet":
                hastaDurumu.setAktuelDurum(aktuelDurum);
                hastaDurumu.setAciliyet(false);
                break;

            case "migren", "kalp hastaliklari":
                hastaDurumu.setAktuelDurum(aktuelDurum);
                hastaDurumu.setAciliyet(true);
                break;

            default:
                System.out.println("Gecerli bir durum değil");
                break;
        }
        return hastaDurumu;
    }


    //pdf sayfa 19 4.metod
    public static Hasta hastaBul(String aktuelDurum) {
        Hasta hasta = new Hasta();

        for (int i = 0; i < hastane1.durumlar.length; i++) {

            if (aktuelDurum.equalsIgnoreCase(hastane1.durumlar[i])) {

                hasta.setIsim(hastane1.hastaIsimleri[i]);
                hasta.setSoyIsim(hastane1.hastaSoyIsimleri[i]);
                hasta.setHastaID(hastane1.hastaIDleri[i]);
                hasta.setHastaDurumu(hastaDurumuBul(aktuelDurum));


            }
        }
        return hasta;

    }


}


















