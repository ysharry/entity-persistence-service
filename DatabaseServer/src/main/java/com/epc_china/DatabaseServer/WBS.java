package com.epc_china.DatabaseServer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class WBS {
	
	@Id
	@Type(type="objectid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String objectId;
	private String code;
	private String name;
	
	public WBS(String code, String name){
		this.code = code;
		this.name = name;
	}
	
	
}
