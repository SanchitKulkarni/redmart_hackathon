import org.mongodb.morphia.Morphia;
import com.mongodb.MongoClient;
import controllers.MorphiaObject;
import play.GlobalSettings;
import play.Logger;

public class Global extends GlobalSettings{

    @Override
    public void onStart(play.Application argo) {
        super.beforeStart(argo);
        Logger.debug("** on start **");
        try {
            MorphiaObject.mongo = new MongoClient("127.0.0.1", 27017);
        }catch(Exception e){
            e.printStackTrace();
        }
        MorphiaObject.morphia = new Morphia();
        MorphiaObject.datastore = MorphiaObject.morphia.createDatastore(MorphiaObject.mongo, "redmart_todo");
        MorphiaObject.datastore.ensureIndexes();
        MorphiaObject.datastore.ensureCaps();

        Logger.debug("** Morphia datastore: " + MorphiaObject.datastore.getDB());
    }
}