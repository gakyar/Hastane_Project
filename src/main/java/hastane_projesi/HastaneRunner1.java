package hastane_projesi;

public class HastaneRunner1 {

    private static Hastane hastane1 = new Hastane();



    public static void main(String[] args) {


        String hastaDurumu="kalp hastaliklari";
        String unvan = doktorUnvan(hastaDurumu);

      hastane1.setDoktor(doktorBul(unvan));
      hastane1.setHasta(hastaBul(hastaDurumu));

        System.out.println(hastane1.getHasta().getIsim());
        System.out.println(hastane1.getHasta().getSoyIsim());
        System.out.println(hastane1.getHasta().getHastaDurumu().getAktuelDurum());
        if (hastane1.getHasta().getHastaDurumu().isAciliyet()==false) {
            System.out.println("Hastanın durumu acil değildir");
        } else {
            System.out.println("Hastanın durumu acildir");
        }

        System.out.println(hastane1.getHasta().getHastaID());
        System.out.println(hastane1.getDoktor().getIsim());
        System.out.println(hastane1.getDoktor().getSoyIsim());
        System.out.println( hastane1.getDoktor().getUnvan());










    }


    //pdf sayfa 14  1.metod
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








    //pdf sayfa 16  2.metod
    public static Doktor doktorBul(String unvan) {

        Doktor doktor = new Doktor();


        for (int i = 0; i < hastane1.unvanlar.length; i++) {
            if (unvan.equalsIgnoreCase(hastane1.unvanlar[i])){

                doktor.setIsim(hastane1.doctorIsimleri[i]);
                doktor.setSoyIsim(hastane1.doctorSoyIsimleri[i]);
                doktor.setUnvan(hastane1.unvanlar[i]);

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




















