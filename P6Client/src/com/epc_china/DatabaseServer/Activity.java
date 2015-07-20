package com.epc_china.DatabaseServer;

public class Activity {
	
	public String ObjectId = "default";
	
	public String createUser = "default";
	public double earnedValueCost = 0;
	public double plannedTotalCost = 0;
	
	public String WBSName;
	public String WBSCode;
	
	public void setWBS(WBS wbs){
		this.WBSCode = wbs.code;
		this.WBSName = wbs.name;
	}
	
	public void setCreateUser(String s){
		this.createUser = s;
	}
	public void setEarnedValueCost(double d){
		this.earnedValueCost = d;
	}
	public void setPlannedTotalCost(double d){
		this.plannedTotalCost = d;
	}
}
