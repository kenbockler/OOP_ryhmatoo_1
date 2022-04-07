import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PeaKlass {

    static ArrayList<Integer> mängija1Seis = new ArrayList<>();
    static ArrayList<Integer> mängija2Seis = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        List<Tulemus> tulemused11 = Tulemused.loeFailist("tulemused.txt");
        System.out.println(tulemused11);
        // Järgnev on lihtsalt kasutajale visuaalseks ettekujutuseks, milline tabel välja näeb.
        String[][] tabel = {
                {"   ", "|", "   ", "|", "   "},
                {"---", "+", "---", "+", "---"},
                {"   ", "|", "   ", "|", "   "},
                {"---", "+", "---", "+", "---"},
                {"   ", "|", "   ", "|", "   "}
        };
        väljastaTabel(tabel);

        //Järgnev osa määrab mängijate nimed
        Scanner sNimi = new Scanner(System.in);
        System.out.println("Sisesta esimese mängija nimi: ");
        String sisend1 = sNimi.nextLine();
        Mängija nimi1 = new Mängija(sisend1);
        System.out.println("Esimese mängija : " + sisend1 + ", sümbol: \"X\"");

        Scanner sNimi2 = new Scanner(System.in);
        System.out.println("Sisesta teise mängija nimi: ");
        String sisend2 = sNimi2.nextLine();
        Mängija nimi2 = new Mängija(sisend2);
        System.out.println("Teine mängija : " + sisend2 + ", sümbol: \"O\"");
        System.out.println();

        Ajavõtt aeg = new Ajavõtt(); //paneb aja tööle
        while (true) {
            //Järgnev osa määrab ära kasutaja valiku, kuhu ta enda märgi sisestab:
            Scanner s = new Scanner(System.in);
            System.out.println("Vali koht sümbolile (1-9):");
            int mängija1Koht = s.nextInt();
            System.out.println(mängija1Koht);



            // järgnev osa märgib sümboleid
            while (mängija1Seis.contains(mängija1Koht) || mängija2Seis.contains(mängija1Koht)) {
                System.out.println("Koht on võetud! Sisestage õige koha peale!");
                mängija1Koht = s.nextInt();
            }
            märgiSümbol(tabel, mängija1Koht, nimi1.getNimi(), nimi1,nimi2);
            väljastaTabel(tabel);
            String tulemus = leiaVõitja(nimi1);
            if (tulemus.length() > 0) {
                System.out.println(tulemus);
                aeg.kinni();
                Tulemus tulemusproov = new Tulemus(nimi1.getNimi(), nimi2.getNimi(), aeg.kinni());
                //salvestame faili
                Tulemused.kirjutaFaili("tulemused.txt", tulemusproov);
                break;
            }


            //Teise mängija kohta: Järgnev osa määrab ära kasutaja valiku, kuhu ta enda märgi sisestab:
            Scanner s2 = new Scanner(System.in);
            System.out.println("Vali koht sümbolile (1-9):");
            int mängija2Koht = s2.nextInt();
            System.out.println(mängija2Koht);
            // järgnev osa märgib sümboleid
            while (mängija1Seis.contains(mängija2Koht) || mängija2Seis.contains(mängija2Koht)) {
                System.out.println("Koht on võetud! Sisestage õige koha peale!");
                mängija2Koht = s.nextInt();
            }
            märgiSümbol(tabel, mängija2Koht, nimi2.getNimi(), nimi1,nimi2);
            väljastaTabel(tabel);
            String tulemus2 = leiaVõitja(nimi2);
            if (tulemus2.length() > 0) {
                System.out.println(tulemus2);
                aeg.kinni();
                Tulemus tulemusproov = new Tulemus(nimi1.getNimi(), nimi2.getNimi(), aeg.kinni());
                //salvestame faili
                Tulemused.kirjutaFaili("tulemused.txt", tulemusproov);
                break;
            }


        }//while

    }//main

    public static void väljastaTabel(String[][] näidisTabel) {
        for (String[] rida : näidisTabel) {
            for (String e : rida) {
                System.out.print(e);
            }
            System.out.println();
        } // for
    }// väljastaTabel

    public static void märgiSümbol(String[][] tabel, int koht, String kasutaja, Mängija nimi1, Mängija nimi2) {

        String sümbol = "   ";

        if (kasutaja.equals(nimi1.getNimi())) {
            sümbol = " X ";
            mängija1Seis.add(koht);
        } else if (kasutaja.equals(nimi2.getNimi())) {
            sümbol = " O ";
            mängija2Seis.add(koht);
        }

        switch (koht) {
            case 1 -> tabel[0][0] = sümbol;
            case 2 -> tabel[0][2] = sümbol;
            case 3 -> tabel[0][4] = sümbol;
            case 4 -> tabel[2][0] = sümbol;
            case 5 -> tabel[2][2] = sümbol;
            case 6 -> tabel[2][4] = sümbol;
            case 7 -> tabel[4][0] = sümbol;
            case 8 -> tabel[4][2] = sümbol;
            case 9 -> tabel[4][4] = sümbol;
        }

    }//märgiSümbol

    public static String leiaVõitja(Mängija nimi) {
        List<Integer> ülemineRida = Arrays.asList(1, 2, 3);
        List<Integer> keskmineRida = Arrays.asList(4, 5, 6);
        List<Integer> alumineRida = Arrays.asList(7, 8, 9);
        List<Integer> vasakVeerg = Arrays.asList(1, 4, 7);
        List<Integer> keskmineVeerg = Arrays.asList(2, 5, 8);
        List<Integer> paremVeerg = Arrays.asList(3, 6, 9);
        List<Integer> risti1 = Arrays.asList(1, 5, 9);
        List<Integer> risti2 = Arrays.asList(7, 5, 3);

        List<List<Integer>> võit = new ArrayList<>();
        võit.add(ülemineRida);
        võit.add(keskmineRida);
        võit.add(alumineRida);
        võit.add(vasakVeerg);
        võit.add(keskmineVeerg);
        võit.add(paremVeerg);
        võit.add(risti1);
        võit.add(risti2);

        for (List<Integer> a : võit) {
            if (mängija1Seis.containsAll(a)) {
                return nimi.getNimi() + " võitis!";
            } else if (mängija2Seis.containsAll(a)) {
                return nimi.getNimi() + " võitis!";
            } else if (mängija1Seis.size() + mängija2Seis.size() == 9) {
                return "Kumbiki ei võtnud, jooksite mõlemad tupikusse!";
            }


        }

        return "";
    }

}//PeaKlass
