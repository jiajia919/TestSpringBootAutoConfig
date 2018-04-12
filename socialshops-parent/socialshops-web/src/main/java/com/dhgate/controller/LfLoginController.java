package com.dhgate.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dhgate.domain.User;
import com.dhgate.po.Test1;
import com.dhgate.service.UserService;

@Controller
@RequestMapping("/lfLogin")
public class LfLoginController {

    private static final Logger log = LoggerFactory.getLogger(LfLoginController.class);
	
    @Autowired
    private UserService userServiceImpl;
    @Resource(name = "mongoTemplate0001")
    private MongoTemplate mongoTemplate;
    
	@RequestMapping(value = "/toRegister", method = {RequestMethod.POST, RequestMethod.GET})
    /*@ResponseBody*/
    public String toRegister(Model model){
		System.out.println("1234");
		model.addAttribute("message","1234567890");
		return "userAdd";
    }
	
	@RequestMapping(value = "/toAdd", method = {RequestMethod.POST, RequestMethod.GET})
    public String mongoAdd(){
		MongoTemplate mongo = mongoTemplate;
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("name").is("jiajia"));
        Query query = new Query(criteria);
        Test1 findOne = mongo.findOne(query, Test1.class);
        System.out.println(findOne);
        return "userAdd";
    }
	
	@RequestMapping(value = "/tomysqlAdd", method = {RequestMethod.POST, RequestMethod.GET})
    public String mysqlAdd(){
		User user = new User();
		user.setName("jj");
		userServiceImpl.addUser(user);
        return "userAdd";
    }
}
