package catchme.messenger.logic;


import catchme.messenger.logic.models.Account;
import catchme.messenger.logic.models.Chat;
import catchme.messenger.logic.models.Message;
import catchme.messenger.logic.models.SendingMessage;
import catchme.messenger.logic.models.Token;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

/**
 * Created by cosmo on 12-Nov-17.
 * interface to interact with The Server
 * author: cosmos
 */

public interface ServerApiInterface {

    @POST("auth/get_token/")
    Call<Token> getToken(
            @Header("Content-Type") String contentType,
            @Body Account account
    );


    @GET("lowMes/")
    Call<List<Chat>> getChats(
            @Header("Authorization") String token // JWT eyJ0...
    );

    @GET("lowMes/messages/")
    Call<List<Message>> getMessages(
            @Query("chat_id") Integer chatId,
            @Header("Authorization") String token // JWT eyJ0...
    );

    @POST("lowMes/send_message/")
    Call<Message> sendMessage(
            @Header("Content-Type") String contentType,
            @Header("Authorization") String token,
            @Body SendingMessage message

    );

}


























