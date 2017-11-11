package catchmemessemger.itis.kpfu.ru.logic;

import com.orm.SugarRecord;

/**
 * Created by cosmo on 10-Nov-17.
 * Author: cosmos
 */

public class Account extends SugarRecord {

    private String login;
    private String password;

    // TODO store session id

    public Account() {
    }

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    // TODO toString();

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login + '\'' +
                // !!!
                ", password='" + "****" + '\'' +
                '}'
        ;
    }
}

