package catchme.messenger.logic.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by cosmo on 15-Nov-17.
 * 5:24 PM
 * author: cosmos
 */


public class Chat {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("members")
    @Expose
    private List<Integer> members;

    @SerializedName("id")
    @Expose
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getMembers() {
        return members;
    }

    public void setMembers(List<Integer> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "name='" + name + '\'' +
                ", members=" + members +
                ", id=" + id +
                '}';
    }
}
