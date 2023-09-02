package TOA;

public class Main
{
    public static void main(String[] args) {
        // *************************************************************
        // Estimated points for a 300 = 19,114
        //      % chance = 4.248% (19,114 / 4,500) 
        //      roughly 1/23.54, assume 1/24.
        // Estimated points for a 350 = 20,437
        //      % chance = 5.839% (20,437 / 3500)
        //      roughly 1/17.13, assume 1/17.
        // *************************************************************
        int Purple_Chance    = 24;
        int Simulation_Rolls = 1000;
        Runner r = new Runner();
        r.Run(Purple_Chance, Simulation_Rolls);
    }
}