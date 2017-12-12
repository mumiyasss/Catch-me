package catchme.messenger.logic;


import android.support.v4.media.AudioAttributesCompat;

import retrofit2.Call;
import retrofit2.http.Body;
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

public interface ServerApiInterface {

    @POST("auth/get_token/")
    Call<Token> getToken(
            @Header("Content-Type") String contentType,
            @Body Account account
    );

    @GET("lowMes/")
    Call<List<Chat>> getChats();

    @GET("lowMes/messages/?chat_id={chatId}/")
    Call<List<Message>> getMessages(
            @Path("chatId") Integer chatId,
            @Header("Authorization: ") String token // JWT eyJ0...
    );
}


























