package catchme.net.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by cosmo on 15-Nov-17.
 * 5:06 PM
 * Author: cosmos
*/

public class Account {

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private String password;


    public Account() {}

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                '}';
    }
}

