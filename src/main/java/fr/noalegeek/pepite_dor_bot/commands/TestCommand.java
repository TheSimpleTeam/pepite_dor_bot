package fr.noalegeek.pepite_dor_bot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import fr.noalegeek.pepite_dor_bot.enums.CommandCategories;
import fr.noalegeek.pepite_dor_bot.utils.MessageHelper;

public class TestCommand extends Command {

    public TestCommand() {
        this.category = CommandCategories.MISC.category;
        this.help = "help.test";
        this.cooldown = 5;
        this.name = "test";
        this.hidden = true;
        this.aliases = new String[]{"t", "te", "tes"};
        this.ownerCommand = true;
    }

    @Override
    protected void execute(CommandEvent event) {
        String[] args = event.getArgs().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        /*
        stringBuilder.append("\"");
        for(String part1 : new String[]{"un", "u"}){
            for(String part2 : new String[]{"short", "s"}){
                for(String part3 : new String[]{"url", "u"}){
                    if(!(part1 + part2 + part3).equals("unshorturl")){
                        stringBuilder.append(part1 + part2 + part3).append("\",\"");
                    }
                }
            }
        }
        event.reply(stringBuilder.toString());*/
        stringBuilder.append("test 1234");
        event.reply(stringBuilder.substring(1));
    }
}
