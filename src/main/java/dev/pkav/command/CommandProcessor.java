package dev.pkav.command;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public abstract class CommandProcessor extends BotCommand {

//    private final Logger LOGGER = LogManager.getLogger(CommandProcessor.class);

    /**
     *
     * @param commandIdentifier command which user typed
     * @param description       command description
     */
    public CommandProcessor(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    /**
     *
     * @param sender
     * @param command   command which user typed
     * @param user
     */
    public void execute(AbsSender sender, SendMessage command, User user) {

        try {
            sender.execute(command);
            System.out.println(user.getUserName() + " tried to execute " + getCommandIdentifier());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
