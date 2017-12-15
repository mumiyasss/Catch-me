package catchme.messenger.logic.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

public class Token extends SugarRecord {

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