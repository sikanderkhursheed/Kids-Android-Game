package szabist.com.kidsgame.Model;

import java.io.Serializable;
/**
 * Created by sikander on 1/6/2017.
 */

public class Items implements Serializable {

    public int id;
    public String name;
    public String picture;

    public Items(int id, String name, String picture){
        this.id= id;
        this.name = name;
        this.picture = picture;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
