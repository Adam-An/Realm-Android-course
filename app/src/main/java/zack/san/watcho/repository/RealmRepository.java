package zack.san.watcho.repository;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import zack.san.watcho.Anime;
import zack.san.watcho.MyRealmMigration;
import zack.san.watcho.User;

public class RealmRepository {

    private Realm realm;
    
    public RealmRepository() {
        this.realm = Realm.getDefaultInstance();
    }

    private int getNextUserId() {
        Number maxId = realm.where(User.class).max("userId");
        return maxId == null ? 1 : maxId.intValue() + 1;
    }

    public void saveUser(final User user) {


       // user.setUserId(getNextUserId());
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(user);
            }
        });
    }

    public User getUser(){
      return realm.where(User.class).findFirst();
    };

    public User getUser(String username) {
        return realm.where(User.class).equalTo("username", username).findFirst();
    }


    public void updateUser(final User user){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(user);
            }
        });
    }


    public User Login(String username,String password){

        return realm.where(User.class).equalTo("username", username).and().equalTo("password",password).findFirst();

    }

    public RealmResults<Anime> getAll(){
        return realm.where(Anime.class).findAll();
    }



}
