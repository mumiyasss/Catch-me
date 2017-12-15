package catchme.messenger.logic;

import com.orm.SugarRecord;

import catchme.messenger.logic.models.Token;

/**
 * Created by cosmo on 12-Dec-17.
 * read next doc comment below
 */


/**
 * USAGE
 * SAVE:
 *  TokenSaver ts = new TokenSaver("a;dlskfj");
 *  ts.save();
 * LOAD:
 *  TokenSaver ts = TokenSaver.findById(TokenSaver.class, 1);
 * ATTENTION:
 *  indexing starts with 1 (edinitsa)
 */

public class TokenSaver extends SugarRecord {

    private String token;

    public TokenSaver() {}

    public TokenSaver(String token) {
        this.token = token;
    }

    public TokenSaver(Token token) { this.token = token.getToken(); }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return token;
    }
}
