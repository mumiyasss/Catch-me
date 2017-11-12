package catchmemessemger.itis.kpfu.ru.logic;

import com.orm.SugarRecord;

/**
 * Created by cosmo on 10-Nov-17.
 * Author: cosmos
 */

public class Account extends SugarRecord {

    private String login;
    private String sessionId;

    // TODO store session id

    public Account() {
    }

    public Account(String login) {
        this.login = login;

        // TODO net stuff
        // get sessionid from server



        this.sessionId = "";
    }

    // TODO toString();

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login + '\'' +
                // !!!
                ", sessionId='" + sessionId + '\'' +
                '}'
        ;
    }
}

