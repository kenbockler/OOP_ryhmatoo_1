//Selle klassi eesmärk on välja selgitada kas mäng on võidetud. St kontrollib kas n sümbolit on järjest.
public class Kohtunik {
    //Tahame kasutada klassi Tabel muutujat sümbolite ArvVõiduks, aga ei tea kuidas - get meetodiga nt


    public static boolean kasVõit(int [][] mängulaud, int rida, int veerg, int sümbol){

        int sümbolAsetatud = mängulaud[rida][veerg];

        //Kui ruut on tühi, siis pole võimalik võitu saavutada
        if (sümbolAsetatud == 0)
            return false;
        //Teostame kontrolli
        else{
            int loendur = 0;
            //Kontroll samalt realt
            for (int i = 0; i < 3; i++) {
                if (mängulaud[rida][i] != sümbolAsetatud) {
                    loendur = 0;
                    break;
                }
                loendur+=1;
                if (loendur == 3)
                    return true;

            }
            //Kontroll samalt veerult
            for (int i = 0; i < 3; i++) {
                if (mängulaud[i][veerg] != sümbolAsetatud) {
                    loendur=0;
                    break;
                }
                loendur+=1;
                if (loendur == 3)
                    return true;

            }

            //Kui sümbol asetati keskele, siis peab kontrollima ka diagonaale
            if (rida == 1 && veerg == 1){

                //Vasakult ülevalt paremale alla
                for (int i = 0; i < 3; i++) {
                    if (mängulaud[i][i] != sümbolAsetatud) {
                        loendur = 0;
                        break;
                    }
                    loendur+=1;
                    if (loendur == 3)
                        return true;
                }

                //Paremalt alt vasakule üles
                for (int i = 2; i >= 0 ; i--) {
                    if (mängulaud[i][i] != sümbolAsetatud) {
                        loendur = 0;
                        break;
                    }
                    loendur+=1;
                    if (loendur == 3)
                        return true;
                }
            }

        }

        return false;
    }

}
