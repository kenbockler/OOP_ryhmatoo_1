import java.util.concurrent.TimeUnit;

/**
 *
 */
public class Ajavõtt {
    private static long algusaeg;

    public Ajavõtt() {
        this.algusaeg = System.currentTimeMillis();
    }

    public static String kinni() {
        long praeguneaeg = System.currentTimeMillis();
        String aeg = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(praeguneaeg - algusaeg));
        return aeg;

    }

    public static void main(String[] args) {
        new Ajavõtt();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
        System.out.println(kinni());

    }
}
