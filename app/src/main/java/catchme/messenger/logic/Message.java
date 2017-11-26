package catchme.messenger.logic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

/**
 * Created by cosmo on 15-Nov-17.
 * 5:11 PM
 * Author: cosmos
 */

public class Message extends SugarRecord {

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("chat")
    @Expose
    private Integer chat;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getChat() {
        return chat;
    }

    public void setChat(Integer chat) {
        this.chat = chat;
    }

    @Override
    public String toString() {
        return
            "{" +
                "\"text\":\"" + text + "\"," +
                "\"char\":" + chat.toString() +
            "}"
        ;
    }

}
