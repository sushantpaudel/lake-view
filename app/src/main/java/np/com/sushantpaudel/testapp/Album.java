package np.com.sushantpaudel.testapp;

/**
 * Created by sushantpaudel on 1/22/2017.
 */

public class Album {
    private String name;
    private int thumbnail;
    public Album(){
    }
    public Album(String name, int thumbnail){
        this.thumbnail=thumbnail;
        this.name=name;

    }
    public String getName(){return name; }

    public void setName(String name){ this.name=name; }

    public int getThumbnail(){ return thumbnail;}

    public void setThumbnail(int thumbnail){ this.thumbnail=thumbnail; }
}
