import java.util.concurrent.TimeUnit;

public class Ajavõtt {

    private static long algusaeg;
    /**
     * ajavõtt võtab algusajaks selle aja,
     * millal meetod tööle pannakse
     */
    public Ajavõtt() {
        this.algusaeg = System.currentTimeMillis();
    }

    /**
     * meetod kinni võtab kinnipaneku aja ja lahutab kinnipaneku ajast algus aja
     * @return tagastab String kujul mängu kestuse sekundites
     */
    public static String kinni() {
        long praeguneaeg = System.currentTimeMillis();
        String aeg = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(praeguneaeg - algusaeg));
        return aeg;
    }
}
