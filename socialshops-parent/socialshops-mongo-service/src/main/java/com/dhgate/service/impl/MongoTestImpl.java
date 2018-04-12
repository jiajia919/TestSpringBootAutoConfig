package com.dhgate.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.dhgate.po.Test1;
import com.dhgate.service.MongoTest;

@Service
public class MongoTestImpl implements MongoTest{
	@Resource(name = "mongoTemplate0001")
    private MongoTemplate mongoTemplate;
	
	
	public Test1 getMongo(){
		MongoTemplate mongo = mongoTemplate;
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("name").is("jiajia"));
        Query query = new Query(criteria);
        Test1 findOne = mongo.findOne(query, Test1.class);
        return findOne;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties property = new Properties();
		property.load(new FileInputStream("D:\\workspace-trunk\\socialshops-parent\\socialshops-mongo-service\\src\\main\\resources\\mongodb.properties"));
		String value = property.getProperty("rounterMongo.databaseName");
		System.out.println(value);
	}
}
