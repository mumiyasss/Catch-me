package catchme.messenger.logic.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token {

    @SerializedName("token")
    @Expose
    private String token;

    public Token(String token) {
        this.token = "JWT " + token;
    }

    public Token() {}

    public Token(String token, int i) {
        this.token = token;
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