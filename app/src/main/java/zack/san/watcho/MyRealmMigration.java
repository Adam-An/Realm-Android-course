package zack.san.watcho;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

public class MyRealmMigration implements RealmMigration {

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();

        if (oldVersion == 0) {
            // Add the new 'animeCount' property to the User object
            schema.get("User")
                    .addField("animeCount", int.class);

            // Add the new 'animeFav' property to the User object
            schema.get("User")
                    .addField("animeFav", int.class);

            oldVersion++;
        }
    }


}
