package DesertTreasure2;

public class Main
{
    public static void main(String[] args) {
        // *************************************************************
        // 4 Possible Bosses to simulate.
        // 1. Duke Sucellus
        // 2. Leviathan
        // 3. Vardorvis
        // 4. Whisperer
        // *************************************************************
        String[] BossNames = {"Duke", "Leviathan", "Vardorvis", "Whisperer"};
        // 1 for Duke, 2 for Leviathan, 3 for Vardorvis, 4 for Whisperer.
        int BossIndex = 1;
        int Simulation_Rolls = 1000;
        Runner r = new Runner();
        r.Run(BossNames[BossIndex-1], Simulation_Rolls);
    }
}