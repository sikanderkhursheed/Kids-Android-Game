package szabist.com.kidsgameadmin.Model;

/**
 * Created by sikander on 1/6/2017.
 */

public class Items {

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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
