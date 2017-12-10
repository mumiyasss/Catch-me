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

public interface ServerApiInterface {

    @GET("auth/get_token/")
    String getToken(
            @Header("Content-Type: application/json")
            Account account
    );

    @GET("lowMes/")
    Call<List<Chat>> getChats();

}


























