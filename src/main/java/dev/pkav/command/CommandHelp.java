package dev.pkav.command;

import dev.pkav.command.CommandProcessor;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.ICommandRegistry;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class CommandHelp extends CommandProcessor {

//    private final Logger LOGGER = LogManager.getLogger(CommandHelp.class);

    private final ICommandRegistry commandRegistry;

    public CommandHelp(ICommandRegistry commandRegistry) {
        super("help", "list all known commands\n");
        this.commandRegistry = commandRegistry;
    }

    /**
     * Execute the command
     *
     * @param absSender absSender to send messages over
     * @param user      the user who sent the command
     * @param chat      the chat, to be able to send replies
     * @param arguments passed arguments
     */
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {

        System.out.println("User {} invoked command list.");

        StringBuilder helpMessageBuilder = new StringBuilder("<b>Available commands:</b>");

        commandRegistry.getRegisteredCommands().forEach(cmd -> helpMessageBuilder.append(cmd.toString()).append("\n"));

        SendMessage helpMessage = new SendMessage();
        helpMessage.setChatId(chat.getId().toString());
        helpMessage.enableHtml(true);
        helpMessage.setText(helpMessageBuilder.toString());

        execute(absSender, helpMessage, user);
    }
}
