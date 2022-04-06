import javax.swing.table.TableCellEditor;
import java.security.spec.ECField;
import java.sql.Time;
import java.util.Arrays;


/**
 * Kokkulepped:
 * 1. Meie trips-traps-trulli mängulaual saab mängida, siis kui sümbolite arv (võiduks) on väiksem või võrdne ridade
 * ja veergude arvuga. st saab võita nii diagonaalis, ülevalt alla kui ka vasakult paremale.
 * 2. X ja O kutsume sümboliteks.
 * 3. Väärtustamisel tähistame sümbolit X arvuga 1 ja sümbolit O arvuga 2 (vaikimisi on tabelis 0-id)
 */

public class Tabel {
    protected int[][] mängulaud = new int[3][3];


    public void tabelKasutajale(){
        System.out.println("| - | - | - |");
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("| - | - | - |");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("| - | - | - |");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("| - | - | - |");
    }

    /**
     * 0 - ruut on tühi
     * 1 - ruudus on X
     * 2 - ruudus on O
     */
    public void näitaTabel(){
        System.out.println("| - | - | - |");
        System.out.println(väljastaRida(0));
        System.out.println("| - | - | - |");
        System.out.println(väljastaRida(1));
        System.out.println("| - | - | - |");
        System.out.println(väljastaRida(2));
        System.out.println("| - | - | - |");
    }


    /**
     * Et mitte liigselt korrata mängulaua kopeerimist teeme korraga ühe meetodi ridade printimiseks
     * meetodile näitaTabel.
     * @param rida
     * @return - tagastab kogu mängulaua ekraanile
     */
    private String väljastaRida(int rida) {
        StringBuilder ridaEkraanile = new StringBuilder("| ");
        for (int j = 0; j < 3; j++) {
            //Kui ruudus on väärtus 1, siis asendame selle X-ga
            if (mängulaud[rida][j] == 1)
                ridaEkraanile.append("X");
            //Kui ruudus on väärtus 1, siis asendame selle O-ga
            if (mängulaud[rida][j] == 2)
                ridaEkraanile.append("O");
            //Kui ruut on tühi, siis asendame selle tühikuga
            if (mängulaud[rida][j] == 0)
                ridaEkraanile.append(" ");

            //Lisame püstkriipsu ruutude eraldamiseks
            ridaEkraanile.append(" | ");
        }

        ridaEkraanile.deleteCharAt(ridaEkraanile.lastIndexOf(" "));
        return ridaEkraanile.toString();
    }

    public boolean kasRuutOnVaba(int asukoht, String sümbol){

        //Leiame, mis indeksile kahekordses massiivis sümbol pandi
        String asukohtSõne;
        switch (asukoht) {
            case 1 -> asukohtSõne = "00";
            case 2 -> asukohtSõne = "01";
            case 3 -> asukohtSõne = "02";
            case 4 -> asukohtSõne = "10";
            case 5 -> asukohtSõne = "11";
            case 6 -> asukohtSõne = "12";
            case 7 -> asukohtSõne = "20";
            case 8 -> asukohtSõne = "21";
            case 9 -> asukohtSõne = "22";
            default -> asukohtSõne = "00";
        }

        int rida = Integer.parseInt(String.valueOf(asukohtSõne.charAt(0)));
        int veerg= Integer.parseInt(String.valueOf(asukohtSõne.charAt(1)));

        //Kontrollime kas ruut on vaba
            if (mängulaud[rida][veerg] == 0){
            switch (sümbol) {
                case "X" -> mängulaud[rida][veerg] = 1;
                case "0" -> mängulaud[rida][veerg] = 2;
            }
            return true;
        }
        //Uuendame tabeli
        return false;
    }

    public boolean arvutiKäik(String sümbol){
        int rida = (int) (Math.random() * 3);
        int veerg = (int) (Math.random() * 3);
        boolean sümbolAsetati=false;

        while(!sümbolAsetati && kasMängulaualVabaRuut()) {
            if (mängulaud[rida][veerg] == 0) {
                switch (sümbol) {
                    case "X" -> mängulaud[rida][veerg] = 1;
                    case "0" -> mängulaud[rida][veerg] = 2;
                }
                return true;
            } else {
                rida = (int) (Math.random() * 3);
                veerg = (int) (Math.random() * 3);
            }
        }
        return sümbolAsetati;
    }

    public boolean kasMängulaualVabaRuut(){
        for (int rida=0; rida < 3; rida++) {
            for (int veerg = 0; veerg < 3; veerg++) {
                if (mängulaud[rida][veerg] == 0)
                    return true;
            }
        }
        return false;
    }

    public void kuvaMängulaud(){
        for (int[] rida : mängulaud) {
            System.out.println(Arrays.toString(rida));
        }
    }

    //meetod, mis sisestab kasutaja poolt määratud sümboli asukohale mängulaual
    public int[][] asetaMängulauale(int rida, int veerg, int sümbol){
        //Kontrollime kas sinna asukohta saab sümboli panna
        if(mängulaud[rida][veerg] == 0)
            mängulaud[rida][veerg] = sümbol;
        //else
            //throw new RuntimeError("Teie valitud asukohal on juba sümbol");
        return mängulaud;
    }


    public int[][] getMängulaud() {
        return mängulaud;
    }

    public static void main(String[] args){
        String asukohtSõne = "12";
        System.out.println(Integer.parseInt(String.valueOf(asukohtSõne.charAt(0))));
        System.out.println((int) (Math.random() * 3));
        System.out.println();


    }
}
