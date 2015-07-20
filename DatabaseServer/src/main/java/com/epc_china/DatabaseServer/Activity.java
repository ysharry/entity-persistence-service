package com.epc_china.DatabaseServer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

@Entity
public class Activity {
	
	@Id
	@Type(type="objectid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String ObjectId = "default";
	
	public String createUser = "default";
	public double earnedValueCost = 0;
	public double plannedTotalCost = 0;
	
	public String WBSName;
	public String WBSCode;
}
