package controllers;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.Datastore;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class MorphiaObject {
    public static MongoClient mongo;
    public static Morphia morphia;
    public static Datastore datastore;
}
