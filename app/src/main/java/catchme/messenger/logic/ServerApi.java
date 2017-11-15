package catchme.messenger.logic;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

/**
 * Created by cosmo on 12-Nov-17.
 * interface to interact w/ server
 * author: cosmos
 */

public interface ServerApi {

    String ADDRESS = "http://ksftx.pythonanywhere.com/";

    // TODO this
    @GET("/api/get/")
    Call<List<Message>> getChat(
            @Query("name") String resourseName,
            @Query("num") int count
    );
}


























