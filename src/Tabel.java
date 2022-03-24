import javax.swing.table.TableCellEditor;
import java.security.spec.ECField;
import java.util.Arrays;

/* Kokkulepped:
    1. Meie trips-traps-trulli mängulaual saab mängida, siis kui sümbolite arv (võiduks) on väiksem või võrdne ridade
       ja veergude arvuga. st saab võita nii diagonaalis, ülevalt alla kui ka vasakult paremale.
    2. X ja O kutsume sümboliteks.
    3. Väärtustamisel tähistame sümbolit X arvuga 1 ja sümbolit O arvuga 2 (vaikimisi on tabelis 0-id)
    .

 */

public class Tabel {
    int ridu;
    int veerge;
    int sümboliteArvVõiduks;

    /*kahemõõtmeline massiiv, millele antakse väärtus kui konstruktoris väärtustatakse väljad
      ja aktiveerub meetod looMängulaud*/
    int[][] mängulaud = looMängulaud();

    //konstruktor
    public Tabel(int ridu, int veerge, int sümboliteArvVõiduks) {
        //Kontrollime kas ridu ja veerge on piisavalt mängu jaoks jaoks
        if(ridu*veerge >= Math.pow(sümboliteArvVõiduks, 2)) {
            this.ridu = ridu;
            this.veerge = veerge;
            this.sümboliteArvVõiduks = sümboliteArvVõiduks;

            //Kui ridade ja veergude arv sobib, loome kahemõõtmelise massiivi
            looMängulaud();




        }
        else
            throw new java.lang.Error("Tabel pole piisavalt suur");
    }

    //get
    public int getRidu() {
        return ridu;
    }

    public int getVeerge() {
        return veerge;
    }

    public int getSümboliteArvVõiduks() {
        return sümboliteArvVõiduks;
    }

    //set
    public void setRidu(int ridu) {
        this.ridu = ridu;
    }

    public void setVeerge(int veerge) {
        this.veerge = veerge;
    }

    public void setSümboliteArvVõiduks(int sümboliteArvVõiduks) {
        this.sümboliteArvVõiduks = sümboliteArvVõiduks;
    }

    //meetod, mis väljastab mängulaua kahemõõtmelise massiivina
    public int[][] looMängulaud (){
        int [][] mängulaud = new int[ridu][veerge];

        return mängulaud;
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

    

    public static void main(String[] args){
        Tabel tripstrapstrull = new Tabel(3,3,3);
        System.out.println(Math.pow(5,2));


        //Väljastame etteantud väärtustustega uue mängulaua
        for (int[] rida : tripstrapstrull.looMängulaud()) {
            System.out.println(Arrays.toString(rida));
        }


        /*for (int[] rida : tripstrapstrull.asetaMängulauale(2,2, 1)) {
            System.out.println(Arrays.toString(rida));
        }*/
        //System.out.println(Table.);
    }
}
