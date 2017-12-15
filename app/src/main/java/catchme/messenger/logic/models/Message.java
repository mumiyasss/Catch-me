package catchme.messenger.logic.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

/**
 * Created by cosmo on 15-Nov-17.
 * 5:11 PM
 * Author: cosmos
 */

public class Message extends SugarRecord {

    @SerializedName("chat")
    @Expose
    private Integer chat;

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("author")
    @Expose
    private Integer author;


    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }


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
                "\"chat\":" + chat.toString() +
            "}"
        ;
    }

}
