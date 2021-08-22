package fr.noalegeek.pepite_dor_bot.commands.moderation;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import fr.noalegeek.pepite_dor_bot.Main;
import fr.noalegeek.pepite_dor_bot.enums.CommandCategories;
import fr.noalegeek.pepite_dor_bot.utils.helpers.MessageHelper;
import net.dv8tion.jda.api.Permission;

public class KickCommand extends Command {
    public KickCommand() {
        this.name = "kick";
        this.aliases = new String[]{"k", "ki", "kic"};
        this.guildOnly = true;
        this.cooldown = 5;
        this.arguments = "arguments.kick";
        this.example = "363811352688721930";
        this.category = CommandCategories.STAFF.category;
        this.help = "help.kick";
    }
    @Override
    protected void execute(CommandEvent event) {
        if (event.getAuthor().isBot()) return;
        if(!event.getMember().hasPermission(Permission.KICK_MEMBERS)){
            event.replyError(MessageHelper.formattedMention(event.getAuthor()) + String.format(MessageHelper.translateMessage("error.commands.userHasNotPermission", event.getGuild().getId()), Permission.KICK_MEMBERS.getName()));
            return;
        }
        if(!event.getSelfMember().hasPermission(Permission.KICK_MEMBERS)){
            event.replyError(MessageHelper.formattedMention(event.getAuthor()) + String.format(MessageHelper.translateMessage("error.commands.botHasNotPermission", event.getGuild().getId()), Permission.KICK_MEMBERS.getName()));
            return;
        }
        String[] args = event.getArgs().split("\\s+");
        if (args.length == 0 || args.length >= 3) {
            event.replyError(MessageHelper.syntaxError(event, this));
            return;
        }
        Main.getJda().retrieveUserById(args[1].replaceAll("\\D+","")).queue(user -> event.getGuild().retrieveMember(user).queue(member -> {
            String reason;
            if(args[1] == null || args[1].isEmpty()) reason = MessageHelper.translateMessage("text.commands.reasonNull", event.getGuild().getId());
            else reason = MessageHelper.translateMessage("text.commands.reason", event.getGuild().getId()) + args[1];
            event.replySuccess(MessageHelper.formattedMention(event.getAuthor()) + String.format(MessageHelper.translateMessage("success.kick", event.getGuild().getId()), user.getName(), reason));
            event.getGuild().kick(member).queue();
        }, memberNull -> event.replyError(MessageHelper.formattedMention(event.getAuthor()) + MessageHelper.translateMessage("error.commands.memberNull", event.getGuild().getId()))), userNull -> event.replyError(MessageHelper.formattedMention(event.getAuthor()) + MessageHelper.translateMessage("error.commands.userNull", event.getGuild().getId())));
    }
}
