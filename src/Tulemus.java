public class Tulemus {
    public String võitja;
    public String kaotaja;
    public String aeg;

    public Tulemus(String võitja, String kaotaja, String aeg) {
        this.võitja = võitja;
        this.kaotaja = kaotaja;
        this.aeg = aeg;
    }

    public String getVõitja() {return võitja;}

    public String getKaotaja() {return kaotaja;}

    public String getAeg() {return aeg;}

    @Override
    public String toString() {
        return "Võitja: " + võitja +
                ", kaotaja: " + kaotaja  +
                ", aeg: " + aeg;
    }

}
