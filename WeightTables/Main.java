package WeightTables;

public class Main {
    public static void main(String[] args) {
        Runner r = new Runner();

        // 1/24 for 300 invo ToA
        // 1/29 for 30k point CoX
        int PURPLE_CHANCE = 24;
        int NUM_RAIDS = 30;
        // ToA, CoX, ToB
        String RAID = "ToA";

        r.run(PURPLE_CHANCE, NUM_RAIDS, RAID);
    }
}
