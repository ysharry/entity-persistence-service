package com.epc_china.DatabaseServer;

import javax.xml.ws.Endpoint;


public class Test {
	
	public static void main(String args[]){
        
		String address = "http://localhost:8129/ActivityService";  
        Endpoint.publish(address, new DatabaseManagerImp()); 
		
	}
}
