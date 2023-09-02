package TOA;

public class Runner
{
    public Runner() { }

    public void Run(int Purple_Chance, int Simulation_Rolls)
    {
        // The purpose of this program is to simulate Purple Drops.
        // First set up the drop rate of a 300 based off of the osrs wiki
        // No deaths, 300, Walk The Path, 2-Down = 19,114 Points, = 4.2476% Purple.
        // Formula for Uniques:
        // 1% chance for every 10,500 - 20(X + Y / 3)
        //      X = Raid level between 1 and 400
        //      Y = Raid level from 401 to 550
        // Example:
        //      For a 300 Invo, the 1% chance is
        //      10,500 - 20(300) = 4,500.
        //      For a 350 Invo, the 1% chance is
        //      10,500 - 20(350) = 3,500

        // *************************************************************
        // Estimated points for a 300 = 19,114
        //      % chance = 4.248% (19,114 / 4,500) 
        //      roughly 1/23.54, assume 1/24.
        // Estimated points for a 350 = 20,437
        //      % chance = 5.839% (20,437 / 3500)
        //      roughly 1/17.13, assume 1/17.
        // *************************************************************
        ToaTable RewardTable = new ToaTable();
        int Purple_Reward;
        String message = " awarded at kill ";
        
        for (int i = 1; i <= Simulation_Rolls; i++)
        {
            if (RollTheDice(Purple_Chance))
            {
                Purple_Reward = DiceRoll(RewardTable.getLength());
                PrintReward(RewardTable.getReward(Purple_Reward), message, i);
            }
        }
    }

    public static boolean RollTheDice(int DropRate){
        int Check = DiceRoll(DropRate);
        return (Check == DropRate);
    }

    public static int DiceRoll(int max){
       return (int)(Math.floor(Math.random()*(max))+1);
    }

    public static void PrintReward(String reward, String message, int kill)
    {
        System.out.println(reward + message + kill);
    }
}