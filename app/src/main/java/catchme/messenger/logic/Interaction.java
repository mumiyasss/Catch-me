package catchme.messenger.logic;

import java.util.List;

import catchme.messenger.logic.models.*;

/**
 * Created by kolya on 24.01.18.
 */

public interface Interaction {

    List<Chat> getChatList();

    List<Message> getChatMessages(Integer chatId);

    // Возможно нужно возвращать отчет о доставке (ответ сервера)
    void sendMessage(SendingMessage sm);


}
