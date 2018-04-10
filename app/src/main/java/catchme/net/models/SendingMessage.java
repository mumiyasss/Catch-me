package catchme.net.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kolya on 15.12.17.
 */

public class SendingMessage {
    @SerializedName("text")
    @Expose
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public SendingMessage(String text, Integer chatId) {

        this.text = text;
        this.chatId = chatId;
    }

    @SerializedName("chat")
    @Expose
    private Integer chatId;
}
