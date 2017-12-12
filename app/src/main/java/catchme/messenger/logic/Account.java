package catchme.messenger.logic;

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
/*
    @SerializedName("email")
    @Expose
    private String email;*/


    public Account() {}

    public Account(String username, String password/*, String email*/) {
        this.username = username;
        this.password = password;
//        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
/*
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }*/

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", token='" + token + '\'' +
                '}'
        ;
    }
}

