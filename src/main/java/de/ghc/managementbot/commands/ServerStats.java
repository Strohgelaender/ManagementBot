package de.ghc.managementbot.commands;

import de.ghc.managementbot.content.Content;
import de.ghc.managementbot.content.Database;
import de.ghc.managementbot.content.Strings;
import de.ghc.managementbot.entity.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import static de.ghc.managementbot.content.Content.formatDate;

public class ServerStats extends Database implements Command {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String string = getStats();
        if (string != null) {
            String[] values = string.split(" ");
            System.out.println(values[2]);
            StringBuilder dates = new StringBuilder(), numbers = new StringBuilder();
            for (int i = 2; i < values.length; i += 2) {
                dates.append(values[i]).append("\n");
            }
            for (int i = 3; i < values.length; i += 2) {
                numbers.append(values[i]);
            }
            event.getChannel().sendMessage(new EmbedBuilder().setTitle("IP-Updates", url).setDescription(url).setColor(Content.getRandomColor()).addField("Datum", dates.toString(), true).addField("Updated", numbers.toString(), true).setFooter("Stand: " + formatDate(), Content.GHCImageURL).build()).queue();
        }
    }
}
