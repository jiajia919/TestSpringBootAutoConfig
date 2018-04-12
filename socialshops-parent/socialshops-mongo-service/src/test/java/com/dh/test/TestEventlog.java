package com.dh.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dhgate.po.Test1;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml", "classpath*:applicationContext-mongodb.xml" })
public class TestEventlog {

	@Resource(name = "mongoTemplate0001")
    private MongoTemplate mongoTemplate;
	
	@Test
	public void test() {
		MongoTemplate mongo = mongoTemplate;
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("name").is("jiajia"));
        Query query = new Query(criteria);
        Test1 findOne = mongo.findOne(query, Test1.class);
        System.out.println(findOne);
	}
	
	
	@Test
	public void testAdd() {
		MongoTemplate mongo = mongoTemplate;
		Test1 test1 = new Test1();
		test1.setName("jiajia");
		mongo.insert(test1,"test1");
	}
	
//	@Test
//	public void testRemove() {
//		MongoTemplate mongo = mongoTemplate;
//		Criteria criteria = Criteria.where("name").is("jiajia");
//		Query query = new Query(criteria);
//		mongo.remove(query,"test1");
//	}

}
