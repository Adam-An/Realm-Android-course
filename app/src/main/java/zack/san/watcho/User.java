package zack.san.watcho;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class User extends RealmObject {


@PrimaryKey
private int userId;
private String username;
private String password;
private int animeCount;
private int animeFav;


    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAnimeCount() {
        return animeCount;
    }

    public void setAnimeCount(int animeCount) {
        this.animeCount = animeCount;
    }

    public int getAnimeFav() {
        return animeFav;
    }

    public void setAnimeFav(int animeFav) {
        this.animeFav = animeFav;
    }
}
