package dev.pkav.dialog;

import lombok.Data;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

@Data
public class Dialog {

//    private final Logger LOGGER = LogManager.getLogger(Dialog.class);
    private final String USER_CHAT_CANNOT_BE_NULL = "User or chat cannot be null!";

    private User user;
    private Chat chat;

    public Dialog(User user, Chat chat) {
        if(null == user || null == chat){
            System.out.println(USER_CHAT_CANNOT_BE_NULL);
            throw new IllegalStateException(USER_CHAT_CANNOT_BE_NULL);
        }
        this.user = user;
        this.chat = chat;
    }
}
