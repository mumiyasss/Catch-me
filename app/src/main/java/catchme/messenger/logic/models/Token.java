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

<<<<<<< HEAD
    public Token() {}

=======
>>>>>>> 8c8bc3ee7622039134030a0c17c451b7d88142de
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