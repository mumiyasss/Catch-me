package catchmemessemger.itis.kpfu.ru.logic;

/**
 * Created by cosmo on 10-Nov-17. 9:15 PM
 */

public class User {
    private String name;
    private Account account;

    public User(Account account) {
        this.account = account;
    }

    public User(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    // TODO toString(); method

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", account=" + account +
                '}'
        ;
    }

}
