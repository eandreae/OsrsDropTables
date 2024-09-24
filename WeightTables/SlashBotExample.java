package WeightTables;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static net.dv8tion.jda.api.interactions.commands.OptionType.*;

public class SlashBotExample extends ListenerAdapter
{
    public static void main(String[] args)
    {
        JDA jda = JDABuilder.createLight("bot token", EnumSet.noneOf(GatewayIntent.class)) // slash commands don't need any intents
                .addEventListeners(new SlashBotExample())
                .build();

        // These commands might take a few minutes to be active after creation/update/delete
        CommandListUpdateAction commands = jda.updateCommands();

        // Simple reply commands
        commands.addCommands(
            Commands.slash("say", "Makes the bot say what you tell it to")
                .addOption(STRING, "content", "What the bot should say", true) // you can add required options like this too
        );

        // Commands without any inputs
        commands.addCommands(
            Commands.slash("leave", "Make the bot leave the server")
                .setGuildOnly(true) // this doesn't make sense in DMs
                .setDefaultPermissions(DefaultMemberPermissions.DISABLED) // only admins should be able to use this command.
        );

        commands.addCommands(
            Commands.slash("fart", "Make me fart uwu")
        );

        commands.addCommands(
            Commands.slash("raid", "Simulate A Raid!")
                .addOption(STRING, "name", "Chambers of Xeric", true, true)
                .addOption(INTEGER, "quantity", "How many raids?", true)
                .addOption(INTEGER, "points", "How many points?", true)
                .addOption(INTEGER, "party_size", "How many people?", true)
                .addOption(BOOLEAN, "show_normal_loot", "Show non purple loots from the raid?", true)
        );

        // Send the new set of commands to discord, this will override any existing global commands with the new set provided here
        commands.queue();
    }


    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event)
    {
        // Only accept commands from guilds
        if (event.getGuild() == null)
            return;
        switch (event.getName())
        {
        case "say":
            say(event, event.getOption("content").getAsString()); // content is required so no null-check here
            break;
        case "leave":
            leave(event);
            break;
        case "fart":
            fart(event);
            break;
        case "raid":
            raid(event,
                event.getOption("name").getAsString(),
                event.getOption("quantity").getAsInt(),
                event.getOption("points").getAsInt(),
                event.getOption("party_size").getAsInt(),
                event.getOption("show_normal_loot").getAsBoolean()
            );
            break;
        default:
            event.reply("English Motherfucker do you speak it").setEphemeral(true).queue();
        }
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event)
    {
        String[] id = event.getComponentId().split(":"); // this is the custom id we specified in our button
        String authorId = id[0];
        String type = id[1];
        // Check that the button is for the user that clicked it, otherwise just ignore the event (let interaction fail)
        if (!authorId.equals(event.getUser().getId()))
            return;
        event.deferEdit().queue(); // acknowledge the button was clicked, otherwise the interaction will fail

        MessageChannel channel = event.getChannel();
        switch (type)
        {
            case "prune":
                int amount = Integer.parseInt(id[2]);
                event.getChannel().getIterableHistory()
                    .skipTo(event.getMessageIdLong())
                    .takeAsync(amount)
                    .thenAccept(channel::purgeMessages);
                // fallthrough delete the prompt message with our buttons
            case "delete":
                event.getHook().deleteOriginal().queue();
        }
    }

    String words[] =
    {
        "Chambers of Xeric"
    };
    @Override
    public void onCommandAutoCompleteInteraction(CommandAutoCompleteInteractionEvent event) {
        if (event.getName().equals("raid") && event.getFocusedOption().getName().equals("name")) {
            List<Command.Choice> options = Stream.of(words)
                    .filter(word -> word.startsWith(event.getFocusedOption().getValue())) // only display words that start with the user's current input
                    .map(word -> new Command.Choice(word, word)) // map the words to choices
                    .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
    }

    public void say(SlashCommandInteractionEvent event, String content)
    {
        event.reply(content).queue(); // This requires no permissions!
    }

    public void leave(SlashCommandInteractionEvent event)
    {
        if (!event.getMember().hasPermission(Permission.KICK_MEMBERS))
            event.reply("You do not have permissions to kick me.").setEphemeral(true).queue();
        else
            event.reply("Leaving the server... :wave:") // Yep we received it
                .flatMap(v -> event.getGuild().leave()) // Leave server after acknowledging the command
                .queue();
    }

    public void fart(SlashCommandInteractionEvent event)
    {
        event.reply("teehee i farted").queue();
    }

    public void raid(SlashCommandInteractionEvent event, String name, int quantity, int points, int party_size, boolean show_normal_loot)
    {
        String output = "";
        switch (name)
        {
            case "Chambers of Xeric" :
            output += CoX.runCoX(quantity, points, party_size, show_normal_loot);
            break;
            
            default:
                output += "Not a valid raid!";
        }

        if (output.length() >= 2000)
        {
            output = "Response too large! Consider reducing the quantity of raids";
        }
        
        event.reply(output).queue();
    }
}