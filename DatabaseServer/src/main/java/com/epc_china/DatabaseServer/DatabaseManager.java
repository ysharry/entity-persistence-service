package com.epc_china.DatabaseServer;

import javax.jws.WebService;

@WebService
public interface DatabaseManager {
	
	public void saveActivity(String dbname, Object obj);
	
	public void removeAllCollections(String dbname);
	
	public void removeAllRecords(String dbname, String collname);
}
