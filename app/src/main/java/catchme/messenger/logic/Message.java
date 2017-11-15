package catchme.messenger.logic;


import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by cosmo on 10-Nov-17. 9:13 PM
 */

public class Message extends SugarRecord {

    private Account owner;
    // PRIVATE IS NOT PERMANENT
    private String text;
    private Date date;

    // TODO think about bounds w/ chat


    public Message() {
    }

    public Message(Account owner, String text, Date date) {
        this.owner = owner;
        this.text = text;
        this.date = date;
    }

    // TODO toString();

    @Override
    public String toString() {
        return "Message{" +
                "owner=" + owner +
                ", text='" + text + '\'' +
                ", date=" + date.toString().split(" ")[3] +
                '}'
        ;
    }
}
