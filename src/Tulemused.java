import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Tulemused {

    //loe failist/salvestab faili tulemused kujul "võitja;kaotaja;aeg"
    //failis kujul võitja;kaotaja;aeg - 2 min sekundite kujul: 120
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

    //meetod kirjutafaili
    //kus loeme kõik tulemuste failist ja lisame uue tulemuse 
    // juurde ja kirjutame tagasi tulemused

    public static void kirjutaFaili(String failinimi, Tulemus tulemus) {
        try {
            List<Tulemus> vanad = loeFailist(".idea/tulemused.txt");
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

    //meetod mis tagastab viimased 5 tulemust, viimane on kõige hiljutisem mängija
    public static List<String> tagastabViimased5() throws IOException {

        List<Tulemus> tulemused2 = loeFailist(".idea/tulemused.txt");
        List<String> viimased = new ArrayList<>();

        for (int i = tulemused2.size() - 5; i < tulemused2.size(); i++) {
            viimased.add(String.valueOf(tulemused2.get(i)));
        }
        return viimased;
    }

    //meetod mis tagastab iga mängija võitude ja kaotuste arvu
    //ei ole lõpetatud

    public static int loeVõidudJaKaotused() throws IOException {
        List<Tulemus> kõik = loeFailist(".idea/tulemused.txt");
        Map<String, Integer[]> nimekiri = new HashMap<>();
        return 1;
    }

}
