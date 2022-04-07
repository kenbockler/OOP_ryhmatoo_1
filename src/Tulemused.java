import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Tulemused {

    /**
    loeb failist/salvestab faili tulemused kujul "võitja;kaotaja;aeg"
    failis kujul võitja;kaotaja;aeg - 2 min sekundite kujul: 120
     *
     * @param failinimi sisestame kust failist loeme
     * @return tagastame tulemuse järjendina
     * @throws IOException
     */
    public static List<Tulemus> loeFailist(String failinimi) throws IOException {
        List<Tulemus> tulemused = new ArrayList<>();
        File fail = new File(failinimi);


        try (Scanner sc = new Scanner(fail, StandardCharsets.UTF_8)) {
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                String[] andmed = rida.split(";");

                String võitja = andmed[0];
                String kaotaja = andmed[1];
                String aeg = andmed[2];
                Tulemus tulemus1 = new Tulemus(võitja, kaotaja, aeg);
                tulemused.add(tulemus1);
            }

        }
        return tulemused;
    }

    /**
     * meetod kirjutafaili kus loeme kõik tulemuste failist
     * ja lisame uue tulemuse juurde ja kirjutame tagasi tulemused
     *
     * @param failinimi failinimi kuhu kirjutada tahame
     * @param tulemus   tulemus mida tahame kirjutada faili
     */
    public static void kirjutaFaili(String failinimi, Tulemus tulemus) {
        try {
            List<Tulemus> vanad = loeFailist("tulemused.txt");
            vanad.add(tulemus);
            FileWriter fw = new FileWriter(failinimi);
            for (Tulemus tulem : vanad) {
                fw.write(tulem.võitja + ";" + tulem.kaotaja + ";" + tulem.aeg + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return tagastab viimased  5 tulemust kus,
     * viimane tulemus on kõige hiljutisem mäng
     * @throws IOException
     */
    public static List<String> tagastabViimased5() throws IOException {

        List<Tulemus> tulemused2 = loeFailist("tulemused.txt");
        List<String> viimased = new ArrayList<>();
        if (tulemused2.size() == 0){
            return viimased;
        }

        if (tulemused2.size()< 5){
            for (int i = 0 ; i < tulemused2.size(); i++) {
                viimased.add(String.valueOf(tulemused2.get(i)));
            }

        }
        else{
            for (int i = tulemused2.size() - 5; i < tulemused2.size(); i++) {
            viimased.add(String.valueOf(tulemused2.get(i)));
            }
        }
        return viimased;
    }

    /**
     * Sisestada mängija nimi et tema võite ja kaotusi näha
     * @return tagastab iga mängija võitude ja kaotuste arvu
     * @throws IOException
     */

    public static String loeVõidudJaKaotused(String nimi) throws IOException {
        List<Tulemus> kõik = loeFailist("tulemused.txt");
        Map<String, int[]> nimekiri = new HashMap<>();

        for (int i = 0; i < kõik.size(); i++) {
            String võitja = kõik.get(i).võitja;
            if (nimekiri.containsKey(võitja)) {
                nimekiri.put(võitja, new int[]{nimekiri.get(võitja)[0] + 1, nimekiri.get(võitja)[1]});
            } else nimekiri.put(võitja, new int[]{1, 0});
        }
        for (int i = 0; i < kõik.size(); i++) {
            String kaotaja = kõik.get(i).kaotaja;
            if (nimekiri.containsKey(kaotaja)) {
                System.out.println("kalla"+kaotaja);
                nimekiri.put(kaotaja, new int[]{nimekiri.get(kaotaja)[0], nimekiri.get(kaotaja)[1] + 1});
            } else nimekiri.put(kaotaja, new int[]{0, 1});
        }
        return nimi + ": võite= " + nimekiri.get(nimi)[0] + ", kaotusi= " + nimekiri.get(nimi)[1];
    }
}
