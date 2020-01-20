package dev.pkav;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.util.Properties;

public class BotInitializer {

//    private static final Logger LOGGER = LogManager.getLogger(BotInitializer.class);

    public static void main(String[] args) {
        try {
            System.out.println("Initializing API context...");
            ApiContextInitializer.init();

            TelegramBotsApi botsApi = new TelegramBotsApi();

            System.out.println("Configuring bot options...");

            System.out.println("Registering Anonymizer...");
            botsApi.registerBot(new CommandRegister());

        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
