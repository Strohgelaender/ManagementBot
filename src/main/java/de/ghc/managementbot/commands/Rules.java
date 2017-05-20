package de.ghc.managementbot.commands;

import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.List;

import static de.ghc.managementbot.content.Content.isModerator;

public class Rules implements Command {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getGuild() != null)
            event.getMessage().delete().queue();


        if (isModerator(event.getMember())) {
            List<User> mentionedUsers = event.getMessage().getMentionedUsers();
            MessageBuilder builder = new MessageBuilder();
            mentionedUsers.forEach(builder::append);
            builder.append(" lies dir bitte die ")
                    .append(event.getGuild().getTextChannelById("269153175137812481"))
                    .append(" genau durch!");
            event.getTextChannel().sendMessage(builder.build()).queue();
        }
    }
}
