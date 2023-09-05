/* Online Java Compiler and Editor */
import java.util.HashMap;

public class VardorvisDrops{

     public static void main(String []args){
         // Roll 1/64
            // If not, 1/34 awakener orb
            // if not, 1/25 tablet
            // if not, 1/200 shadow quartz
            // if not, 1/5 for food
            // if not normal loots
        // for 1/64:
            // 1/8 virtus
                // 1/3 for which piece
            // 3/8 to get single vestige roll
            // 3/8 chromium ingot
            // 1/8 Siren's Staff
        
        int num_rolls = 1000;
        int unique_chance = 136;
        int awakener_orb_chance = 80;
        int tablet_chance = 25;
        int quartz_chance = 200;
        int vestige_rolls = 0;
        String OutputReward = "";
        boolean TabletOwned = false;

        // Hash Map for the Uniques
        HashMap<Integer, String> UniqueTable = new HashMap<Integer, String>();
        UniqueTable.put(1, "Virtus");
        UniqueTable.put(2, "Vestige Roll");
        UniqueTable.put(3, "Vestige Roll");
        UniqueTable.put(4, "Vestige Roll");
        UniqueTable.put(5, "Chromium");
        UniqueTable.put(6, "Chromium");
        UniqueTable.put(7, "Chromium");
        UniqueTable.put(8, "Executioner's Axe Head");

        // Hash Map for the Virtus Pieces
        HashMap<Integer, String> VirtusTable = new HashMap<Integer, String>();
        VirtusTable.put(1, "Virtus Mask");
        VirtusTable.put(2, "Virtus Shirt");
        VirtusTable.put(3, "Virtus Pants");

        // Simulate the kill
        // Step 1: roll the 1/90
        for (int i = 1; i <= num_rolls; i++){

            // Step 1: roll the 1/90
            if (RollTheDice(unique_chance)){
                // Roll an 8 sided die
                int DropRoll = DiceRoll(8);
                // Compare the result to the Uniques Table
                String reward = UniqueTable.get(DropRoll);

                // Check if the reward is a Virtus Piece
                if (reward.equals("Virtus")){
                    // Roll a 3 sided die to determine which piece of Virtus
                    DropRoll = DiceRoll(3);
                    // Compare the result to the Virtus Table
                    reward = VirtusTable.get(DropRoll);
                    // Output the reward to the player.
                    OutputReward = (reward + " awarded at kill " + i);
                }
                // Check if the reward is a Vestige Roll
                else if (reward.equals("Vestige Roll")){
                    // Increment the vestige_rolls by 1
                    vestige_rolls++;
                    // Change the output reward as a vestige roll (optional)
                    OutputReward = (reward + " " + vestige_rolls + " awarded at kill " + i);
                    // Check if that was the 3rd, if yes, reward it to the player.
                    if (vestige_rolls == 3){
                        // Output the Vestige itself to the player
                        OutputReward = ("**********Vestige awarded at kill " + i);
                        vestige_rolls = 0;
                    }
                }
                // If not either a Virtus piece or a Vestige, print reward as normal.
                else {
                    OutputReward = (reward + " awarded at kill " + i);
                }
                // At the end of the successful unique reward, output the reward.
                System.out.println(OutputReward);
            }

            // Step 2: Roll the 1/48 for orb
            else if (RollTheDice(awakener_orb_chance)){
                // Reward the player with an Awakener's orb
                OutputReward = ("Awakener's orb awarded at kill " + i);
                System.out.println(OutputReward);
            }

            // Step 3: Roll the 1/25 for tablet
            else if (RollTheDice(tablet_chance) && TabletOwned == false){
                // Reward the player with the Frozen Tablet
                OutputReward = ("Strangled Tablet awarded at kill " + i);
                TabletOwned = true;
                System.out.println(OutputReward);
            }

            // Step 4: Roll the 1/200 for Ice Quartz
            else if (RollTheDice(quartz_chance)){
                // Reward the player with the Ice Quartz
                OutputReward = ("Blood Quartz awarded at kill " + i);
                System.out.println(OutputReward);
            }
            else {
                // Reward the player with TRASH
            }
            
        }

        
     }
     
     public static boolean RollTheDice(int DropRate){
         double Check = Math.floor(Math.random()*(DropRate))+1;
         return (Check == DropRate);
     }

     public static int DiceRoll(int max){
        return (int)(Math.floor(Math.random()*(max))+1);
     }
     public static boolean VestigeRoll(){
         double Check = Math.floor(Math.random()*(8))+1;
         return (Check <= 3);
     }
}
       
