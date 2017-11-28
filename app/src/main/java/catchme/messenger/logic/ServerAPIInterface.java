package catchme.messenger.logic;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

/**
 * Created by cosmo on 12-Nov-17.
 * interface to interact with The Server
 * author: cosmos
 */

public interface ServerApiInterface {

    String BASE_URL = "http://ksftx.pythonanywhere.com/api/";

    @POST("auth/register/")
    void register(
            Account newAccount
    );

    @POST("auth/get_token")
    String getToken(
            Account account
    );

    @POST("lowMes/")
    Call<List<Chat>> getChats();

    @POST("lowMes/messages/?chat_id={chatId}/")
    Call<List<Message>> getMessages(
            @Path("chatId") Integer chatId
    );

    @POST("lowMes/send_message/")
    void sendMessage(
            Message message
    );

    @POST("lowMes/new_chat/")
    void createChat(
            Chat newChat
    );

}


























