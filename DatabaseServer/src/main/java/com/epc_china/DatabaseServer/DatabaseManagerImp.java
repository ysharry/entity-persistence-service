package com.epc_china.DatabaseServer;

import java.net.UnknownHostException;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence; 
import javax.jws.WebService;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


@WebService (endpointInterface="com.epc_china.DatabaseServer.DatabaseManager",
		serviceName = "DBService",portName="DBPort") 
public class DatabaseManagerImp implements DatabaseManager{
	
	private static EntityManagerFactory entityManagerFactory;
	private Activity act;
	private WBS wbs;
	
	public void saveActivity(String dbname, Object obj){
		entityManagerFactory = Persistence.createEntityManagerFactory(dbname);
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		
		if(obj.getClass() == Activity.class){
			act = (Activity) obj;
			entityManager.persist( act );
		} else if (obj.getClass() == WBS.class){
			wbs = (WBS) obj;
			entityManager.persist( wbs );
		}

		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		entityManagerFactory.close();		
	}
	
	public void removeAllCollections(String dbname){
		try {
			MongoClient m = new MongoClient("localhost",27017);
			DB db = m.getDB(dbname);
			Set<String> coll = db.getCollectionNames();
			for (String s : coll){
				if(!s.equals("system.indexes")){
					db.getCollection(s).drop();
				}
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeAllRecords(String dbname, String collname){
		try {
			MongoClient m = new MongoClient("localhost",27017);
			DB db = m.getDB(dbname);
			DBCollection coll = db.getCollection(collname);
			
			DBCursor dbCursor = coll.find();
			for (DBObject dbObject : dbCursor) {
				coll.remove(dbObject);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
