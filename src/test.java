import java.io.IOException;
import java.util.List;

public class test {

    public static void main(String[] args) throws IOException {
        List<Tulemus> tulemused11 = Tulemused.loeFailist(".idea/tulemused.txt");
        System.out.println(tulemused11);
        List<String> viimased5 = Tulemused.tagastabViimased5();
        System.out.println(viimased5);

        //mäng käima
        Ajavõtt aeg = new Ajavõtt(); //paneb aja tööle

        //siin toimub mängimine

        //mängu lõpp
        // String aeg = aeg.kinni(); paneb aja kinni
        //teeme tulemuse
        Tulemus tulemusproov = new Tulemus("Mari", "Karu", aeg.kinni());

        //salvestame faili
        Tulemused.kirjutaFaili(".idea/tulemused.txt", tulemusproov);


    }
}
