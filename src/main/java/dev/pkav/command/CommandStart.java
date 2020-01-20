package dev.pkav.command;

import dev.pkav.dialog.Dialog;
import dev.pkav.dialog.DialogService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class CommandStart extends CommandProcessor{

//    private final Logger LOGGER = LogManager.getLogger(CommandProcessor.class);
    private final DialogService dialogService;

    public CommandStart(DialogService dialogService) {
        super("start", "start using bot\n");
        this.dialogService = dialogService;
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

        System.out.println("Ready to process command.");


        if(dialogService.addDialog(new Dialog(user, chat))){
            System.out.println("User " + user +" is added to list.");
        }
        SendMessage startMessage = new SendMessage(chat.getId(),
                "Hello, " + user.getUserName() +", you are added to list of users.");
        execute(absSender, startMessage, user);
    }
}
