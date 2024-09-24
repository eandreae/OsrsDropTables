package WeightTables;

import java.util.Collections;

import net.dv8tion.jda.api.*;

public class DiscordBotTest {
    public static void main(String[] args)
    {
        JDA jda = JDABuilder.createLight(token, Collections.emptyList())
        .addEventListener(new SlashCommandListener())
        .build();

        // Register your commands to make them visible globally on Discord:

        CommandListUpdateAction commands = jda.updateCommands();

        // Add all your commands on this action instance
        commands.addCommands(
            Commands.slash("say", "Makes the bot say what you tell it to")
            .addOption(STRING, "content", "What the bot should say", true), // Accepting a user input
            Commands.slash("leave", "Makes the bot leave the server")
            .setGuildOnly(true) // this doesn't make sense in DMs
            .setDefaultPermissions(DefaultMemberPermissions.DISABLED) // only admins should be able to use this command.
        );

        // Then finally send your commands to discord using the API
        commands.queue();
    }
}
