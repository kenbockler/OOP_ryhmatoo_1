// OOP meetodil mängija objekt
public class Mängija {
    private String nimi;

    public Mängija(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public String toString() {
        return "Mängija{" +
                "nimi='" + nimi + '\'' +
                '}';
    }
}
