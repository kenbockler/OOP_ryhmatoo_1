import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class test {

    /**
     * lisaklass, kus saab proovida
     * mängida trips-traps-trulli arvuti vastu
     *
     * peameetod
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //klassi Tabel ja Kohtunik testimine
        System.out.println("---------------------");
        Scanner sc = new Scanner(System.in);
        Tabel tripstrapstrull = new Tabel();

        tripstrapstrull.tabelKasutajale();
        System.out.println("Vali ruut sümboli asetamiseks:");
        int ruuduAsukoht = sc.nextInt();
        tripstrapstrull.kasRuutOnVaba(ruuduAsukoht,"X");

        while(tripstrapstrull.kasMängulaualVabaRuut()){

            tripstrapstrull.arvutiKäik("0");
            tripstrapstrull.näitaTabel();

            System.out.println("Vali järgmine ruut:");
            ruuduAsukoht = sc.nextInt();
            tripstrapstrull.kasRuutOnVaba(ruuduAsukoht,"X");

        }
    }
}
