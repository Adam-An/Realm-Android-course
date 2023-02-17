package zack.san.watcho;

import android.app.Application;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import zack.san.watcho.repository.RealmRepository;

public class MyApplication extends Application {




    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);


       /* RealmConfiguration config = new RealmConfiguration.Builder()
                .schemaVersion(2)
                .migration(new MyRealmMigration()) // set the migration object
                .build();
        Realm.setDefaultConfiguration(config);*/


        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
        Realm realm = Realm.getDefaultInstance();
        RealmRepository repository = new RealmRepository();
        //Insert
        User user = new User("isaac","pass");
        repository.saveUser(user);
        /*
        realm.beginTransaction();
        User user = realm.createObject(User.class);
        user.setUsername("isaac");
        user.setPassword("pass");*/


        //insert
        ArrayList<Anime> animeArrayList = new ArrayList<Anime>();
        animeArrayList.add(new Anime("One Punch Man", 24, "https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/d8eed44e3d48097ab5fd36b6815fc18e.jpe"));
        animeArrayList.add(new Anime("Great Teacher Onizuka",  43,"https://upload.wikimedia.org/wikipedia/en/b/b9/GTO_volume_1.jpg"));
        animeArrayList.add(new Anime("Naruto", 220,"https://upload.wikimedia.org/wikipedia/en/9/94/NarutoCoverTankobon1.jpg"));
        animeArrayList.add(new Anime("Cowboy Bebop", 26,"https://m.media-amazon.com/images/M/MV5BM2FiZmEzOGItODI3Ni00MDk2LWJhZWQtNGM2ODhlMWMzODZhXkEyXkFqcGdeQXVyMTEyMjM2NDc2._V1_FMjpg_UX1000_.jpg"));
        animeArrayList.add(new Anime("Death Note", 37, "https://cdn.myanimelist.net/images/anime/9/21498l.jpg"));
        animeArrayList.add(new Anime("Attack on Titan", 75, "https://cdn.myanimelist.net/images/anime/1824/110939l.jpg"));
        animeArrayList.add(new Anime("Fullmetal Alchemist", 27, "https://image.myanimelist.net/ui/2WKqUufwTqFEmbnAXxxIeLHjalfqphl2Trm-pNsdMAGJW7bM3aUxCQkTceY86CX1sXBe_xB_2gaircB1lDTPG_6CqWbiUwKauKozKnKopT3Yg52OblsZSxwphQcvArup"));
        animeArrayList.add(new Anime("One Piece", 1000, "https://comicvine.gamespot.com/a/uploads/scale_small/11161/111610434/8594314-9160985681-97840.jpg"));
        animeArrayList.add(new Anime("Demon Slayer", 23, "https://demonslayer-anime.com/risshihen/assets/img/top/img_main_sp.jpg"));

        for (Anime anime : animeArrayList) {
            Anime animeRealm = realm.createObject(Anime.class);
            animeRealm.setTitle(anime.getTitle());
            animeRealm.setImageUrl(anime.getImageUrl());
            animeRealm.setEpisodes(anime.getEpisodes());
        }

        realm.commitTransaction();

    }


}
