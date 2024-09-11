package DT2;

public class Runner
{
    public Runner() { }

    public void Run(String BossName, int Simulation_Rolls)
    {
        
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
