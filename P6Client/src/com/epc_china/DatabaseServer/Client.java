package com.epc_china.DatabaseServer;

import java.net.MalformedURLException;  

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
  
public class Client {    
    public static void main(String[] args) throws MalformedURLException {  


        String url = "http://localhost:8129/ActivityService";  
        
        JaxWsProxyFactoryBean svr = new JaxWsProxyFactoryBean();
        svr.setServiceClass(DatabaseManager.class);
        svr.setAddress(url);
        
        DatabaseManager dm = (DatabaseManager) svr.create();
        
        WBS wbs = new WBS("6666","Construction");
        
        Activity myact = new Activity();
        myact.setCreateUser("Harry");
        myact.setEarnedValueCost(500);
        myact.setPlannedTotalCost(10000);
        myact.setWBS(wbs);
        
        Activity myact2 = new Activity();
        myact2.setCreateUser("Michael");
        myact2.setEarnedValueCost(300);
        myact2.setPlannedTotalCost(20000);
        myact2.setWBS(wbs);
        
        dm.removeAllCollections("ActivityDB");
        //dm.save("ActivityDB", wbs);
        dm.saveActivity("ActivityDB", myact);
        dm.saveActivity("ActivityDB", myact2);
          
    }
}
