package com.dhgate.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dhgate.po.Test1;
import com.dhgate.service.MongoTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml","classpath*:applicationContext-*.xml"})
public class TestMongo {

	@Resource(name = "mongoTestImpl")
    private MongoTest mongoTest;
	
	@Test
	public void test() {
		Test1 mongo = mongoTest.getMongo();
        System.out.println(mongo);
	}
}
