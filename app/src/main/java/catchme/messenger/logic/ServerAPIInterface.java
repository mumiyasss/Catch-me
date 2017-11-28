package catchme.messenger.logic;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

/**
 * Created by cosmo on 12-Nov-17.
 * interface to interact with The Server
 * author: cosmos
 */

public interface ServerAPIInterface {

    String BASE_URL = "http://ksftx.pythonanywhere.com/api/";

    @POST("auth/register/")
    void register(
            @Header("Content-Type: application/json")
            Account newAccount
    );

    @GET("auth/get_token")
    String getToken(
            @Header("Content-Type: application/json")
            Account account
    );

    @GET("lowMes/")
    Call<List<Chat>> getChats(
            @Header("Authorization: ")
            String token // JWT eyJ0...
    );

    @GET("lowMes/messages/?chat_id={chatId}/")
    Call<List<Message>> getMessages(
            @Path("chatId") Integer chatId,
            @Header("Authorization: ") String token // JWT eyJ0...
    );

    @POST("lowMes/send_message/")
    void sendMessage(
            @Header("Authorization: ") String token, // JWT eyJ0...
            Message message
    );

    @POST("lowMes/new_chat/")
    void createChat(
            @Header("Authorization: ") String token, // JWT eyJ0...
            Chat newChat
    );

}


























