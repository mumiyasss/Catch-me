package catchme.messenger.logic.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

public class Token extends SugarRecord {

    public void setToken(String token) {
        this.token = token;
    }

    @SerializedName("token")
    @Expose
    private String token;

    public Token(String token) {
        this.token = token;
    }

    public Token() {}

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