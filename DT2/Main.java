package DT2;

public class Main
{
    public static void main(String[] args) {
        // Possible Boss Names
        // 1. Duke
        // 2. Leviathan
        // 3. Vardorvis
        // 4. Whisperer
        String[] BossNames = {"Duke", "Leviathan", "Vardorvis", "Whisperer"};
        int BossIndex = 1;
        int Simulation_Rolls = 1000;
        Runner r = new Runner();
        r.Run(BossNames[BossIndex], Simulation_Rolls);
    }
}
