package org.catchme.net.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token {

    @SerializedName("token")
    @Expose
    private String token;

    public Token(String token) {
        this.token = "JWT " + token;
        cutUnnecessaryJWT();
    }


    private void cutUnnecessaryJWT() {
        token = token.replace("JWT JWT ", "JWT ");
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                '}';
    }

}
