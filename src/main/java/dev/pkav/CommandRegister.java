package dev.pkav;

import dev.pkav.command.CommandHelp;
import dev.pkav.command.CommandStart;
import dev.pkav.dialog.DialogService;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Properties;


public class CommandRegister extends TelegramLongPollingCommandBot {

    private static final String BOT_NAME = "BratkaBot";
    private static final String BOT_TOKEN = "1033184086:AAGtb_kba52281BFwcYZUpN_vwhr94GlKDo";
//    private final Properties properties;
    private static final Properties properties = new Properties();
    private final DialogService dialogService;

//    private final Logger LOGGER = LogManager.getLogger(CommandRegister.class);

    public CommandRegister() {
        super();
//        this.properties = new Properties();

        System.out.println("Initializing BratkaBot...");
        this.dialogService = new DialogService();

        System.out.println("Registering commands...");
        System.out.println("Registering '/start'...");
        register(new CommandStart(dialogService));

        System.out.println("Registering '/help'...");
        register(new CommandHelp(this));
    }

    public void processNonCommandUpdate(Update update) {
        System.out.println("No-command processing...");

    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
//        return properties.getProperty("telegram.bot.name");
    }

    public String getBotToken() {
        return BOT_TOKEN;
//        return properties.getProperty("telegram.bot.token");
    }

}
