package com.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.journaldev.bootifulmongodb.BootMongoDBApp;
import com.journaldev.bootifulmongodb.dal.UserRepository;
import com.journaldev.bootifulmongodb.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = BootMongoDBApp.class)
@EnableAutoConfiguration
@ComponentScan("com.journaldev.bootifulmongodb.dal")
public class MongoDBIntegrationTestIT {

	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void createUser() {
		
		User user = new User();
		user.setName("ITTest");
		user.setUserId("TestId");
		User returnUser = userRepo.save(user);
		Assert.assertNotNull(returnUser.getName());
	}
}
